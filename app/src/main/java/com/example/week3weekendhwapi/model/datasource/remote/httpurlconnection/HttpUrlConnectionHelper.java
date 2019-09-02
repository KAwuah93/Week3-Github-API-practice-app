package com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection;


import android.util.Log;

import com.example.week3weekendhwapi.Repository;
import com.example.week3weekendhwapi.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import okio.Utf8;

public class HttpUrlConnectionHelper {
    //Put the dang-gum code in this mofo
    //Gives you the basic user object/call
    public static final String GITHUB_USER_URL = "https://api.github.com/users/KAwuah93";
    public static final String GITHUB_USER_REPOS = "https://api.github.com/users/KAwuah93/repos";

    public static final String TAG = "TAG_HTTP_CALL";
    public static void getUserProfJson(HttpUrlConnectionCallback callback){
        String jsonResponse = "";
        try{
            //Create the URL object for the Github call, feed it the basic url
            // TODO figure out the solution for the OAuth calls
            URL userUrlCall = new URL(GITHUB_USER_URL);
            //Get the connection going
            HttpURLConnection httpURLConnection = (HttpURLConnection)userUrlCall.openConnection();
            //Stream that data - Connected to the HTTP object
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //get the first read fom the stream
            int currentRead = inputStreamReader.read();
            while(currentRead > -1){
                char currentChar = (char)currentRead;
                jsonResponse += currentChar;
                currentRead = inputStreamReader.read();
            }
            //Gson to parse the json into the RandomMeResponse object
            User user = new Gson().fromJson(jsonResponse, User.class);
            callback.onUserCallResult(user);

        }catch(Exception e){
            Log.e(TAG, "getUserProfJson: Error:", e);
        }
    }
    public static void getRepos(HttpUrlRepoConnectionCallback callback){
        String jsonResponse = "";
        ArrayList<Repository> repos = new ArrayList<>();
        try{
            //Create the URL object for the Github call, feed it the basic url
            // TODO figure out the solution for the OAuth calls
            URL repoCall = new URL(GITHUB_USER_REPOS);
            //Get the connection going
            HttpURLConnection httpURLConnection = (HttpURLConnection)repoCall.openConnection();
            //Stream that data - Connected to the HTTP object
            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            //using Json Reader instead
            JsonReader reader = new JsonReader(inputStreamReader);
            Gson gson = new GsonBuilder().create();
            reader.beginArray();

            while(reader.hasNext()){
                //reading the data into the object
                Repository repository = gson.fromJson(reader, Repository.class);
                repos.add(repository);
            }
            //close the reader boys
            reader.close();
            //Send back the list of objects
            callback.onRepoCallResult(repos);
        }catch(Exception e){
            Log.e(TAG, "getRepoJson: Error:", e);
        }
    }
}
