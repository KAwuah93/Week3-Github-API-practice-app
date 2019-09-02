package com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection;

import com.example.week3weekendhwapi.Repository;

import java.util.ArrayList;

public interface HttpUrlRepoConnectionCallback {
    void onRepoCallResult(ArrayList<Repository> repository);
}
