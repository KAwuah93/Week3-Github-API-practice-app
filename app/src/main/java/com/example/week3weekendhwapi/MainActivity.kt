package com.example.week3weekendhwapi

import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionCallback
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionRunnable
import com.example.week3weekendhwapi.model.datasource.remote.retrofit.GitUserService
import com.squareup.picasso.Picasso
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HttpUrlConnectionCallback {
    //TODO the bound views

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Remember to implement the class in the Main Thread.
        //val httpUrlQueryThread = Thread(HttpUrlConnectionRunnable(this))
        //httpUrlQueryThread.start()

        //Start the animation
        initUserPage()
        animate()
    }

    //Left ovver from HTTPURLCONNECTION
    override fun onUserCallResult(user: User) {
        Log.d(TAG, "onUserCallResult: " + user.name!!)
        runOnUiThread {
            //Attach the data to the views
            //TODO sort out the views

            Picasso.get().load(user.avatarUrl).into(ivAvatar)
            tvCompany.text = user.company
            tvLocation.text = user.location
            tvBio.text = user.bio
            tvFollowersCount.text = "" + user.followers
            tvFollowingCount.text = "" + user.following
            tvRepoCount.text = "Number of Repos:" + user.publicRepos
        }
    }

    fun onResult(user: UserResponse){
        Picasso.get().load(user.avatarUrl).into(ivAvatar)
        tvCompany.text = user.company
        tvLocation.text = user.location
        tvBio.text = user.bio
        tvFollowersCount.text = "" + user.followers
        tvFollowingCount.text = "" + user.following
        tvRepoCount.text = "Number of Repos:" + user.publicRepos

    }

    fun animate() {
        val layout = findViewById<FrameLayout>(R.id.frameLayout)
        val aniDrawable = layout.background as AnimationDrawable
        aniDrawable.setEnterFadeDuration(2000)
        aniDrawable.setExitFadeDuration(4000)
        aniDrawable.start()
    }

    fun toRepo(view: View) {
        val intent = Intent(this, RecyclerViewActivity::class.java)
        startActivity(intent)
    }

    companion object {
        val TAG = "TAG_ACT_MAIN"
    }

    fun initUserPage(){
        GitUserService
                .createService()
                .getUserProfile()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        object : Observer<UserResponse>{
                            lateinit var userResponse: UserResponse
                            override fun onComplete() {
                                onResult(userResponse)
                            }

                            override fun onSubscribe(d: Disposable) {
                            }

                            override fun onNext(t: UserResponse) {
                                userResponse = t
                            }

                            override fun onError(e: Throwable) {
                            }
                        }
                )
    }
}
