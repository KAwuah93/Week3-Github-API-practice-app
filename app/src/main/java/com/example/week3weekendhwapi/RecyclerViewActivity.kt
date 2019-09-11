package com.example.week3weekendhwapi

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import com.example.week3weekendhwapi.model.RepoRVAdapter
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionCallback
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionHelper.getRepos
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionRunnable
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlRepoConnectionCallback
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlRepoConnectionRunnable
import com.example.week3weekendhwapi.model.datasource.remote.retrofit.GitUserService
import com.squareup.picasso.Picasso
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recycler_view.*

import java.util.ArrayList

class RecyclerViewActivity : AppCompatActivity(), HttpUrlRepoConnectionCallback {


    val TAG = "Recycler View"
    //var repoRVAdapter: RepoRVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        //register the recyclerView

        RVView.layoutManager = LinearLayoutManager(this)

        //val httpUrlQueryThread = Thread(HttpUrlRepoConnectionRunnable(this))
        //httpUrlQueryThread.start()
        getRepoList()
    }

    override fun onRepoCallResult(repos: ArrayList<Repository>) {
        Log.d(TAG, "onUserCallResult: " + repos.size)
        runOnUiThread {
            //setting stuff onto the RVadapter
            var repoRVAdapter = RepoRVAdapter(repos)
            RVView.adapter = repoRVAdapter
        }
    }

    fun onResult(repos: List<Repository>){
        var repoRVAdapter = RepoRVAdapter(repos)
        RVView.adapter = repoRVAdapter;
    }

    fun getRepoList(){
        GitUserService
                .createService()
                .getReposList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        object: Observer<List<Repository>>{
                            lateinit var list: List<Repository>
                            override fun onComplete() {
                                onResult(list)
                            }

                            override fun onSubscribe(d: Disposable) {
                            }

                            override fun onNext(t: List<Repository>) {
                                list = t
                            }

                            override fun onError(e: Throwable) {
                            }

                        }
                )
    }
}
