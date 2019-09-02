package com.example.week3weekendhwapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.week3weekendhwapi.model.RepoRVAdapter;
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionCallback;
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionRunnable;
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlRepoConnectionCallback;
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlRepoConnectionRunnable;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity implements HttpUrlRepoConnectionCallback {

    RecyclerView recyclerView;
    String TAG = "Recycler View";
    RepoRVAdapter repoRVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //register the recyclerView
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Thread httpUrlQueryThread = new Thread(new HttpUrlRepoConnectionRunnable(this));
        httpUrlQueryThread.start();
    }

    @Override
    public void onRepoCallResult(final ArrayList<Repository> repos){
        Log.d(TAG, "onUserCallResult: " + repos.size());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //setting stuff onto the RVadapter
                repoRVAdapter = new RepoRVAdapter(repos);
                recyclerView.setAdapter(repoRVAdapter);
            }
        });
    }
}
