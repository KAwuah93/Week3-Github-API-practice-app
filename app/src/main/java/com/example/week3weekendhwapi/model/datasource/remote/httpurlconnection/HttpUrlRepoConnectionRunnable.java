package com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection;

public class HttpUrlRepoConnectionRunnable implements Runnable{
    HttpUrlRepoConnectionCallback callback;

    public HttpUrlRepoConnectionRunnable(HttpUrlRepoConnectionCallback callback){
        this.callback = callback;
    }

    @Override
    public void run() {
        HttpUrlConnectionHelper.getRepos(callback);
    }
}
