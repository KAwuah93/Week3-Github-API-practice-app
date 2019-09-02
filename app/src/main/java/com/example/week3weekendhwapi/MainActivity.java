package com.example.week3weekendhwapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionCallback;
import com.example.week3weekendhwapi.model.datasource.remote.httpurlconnection.HttpUrlConnectionRunnable;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements HttpUrlConnectionCallback {

    public static final String TAG = "TAG_ACT_MAIN";
    ImageView avatar;
    TextView company, location, bio, repo, followerCount, followingCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Remember to implement the class in the Main Thread.
        Thread httpUrlQueryThread = new Thread(new HttpUrlConnectionRunnable(this));
        httpUrlQueryThread.start();
        //Bind the View
        bind();
        //Start the animation
        animate();
    }
    @Override
    public void onUserCallResult(final User user){
        Log.d(TAG, "onUserCallResult: " + user.getName());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Attach the data to the views
                Picasso.get().load(user.getAvatarUrl()).into(avatar);
                company.setText(user.getCompany());
                location.setText(user.getLocation());
                bio.setText(user.getBio());
                followerCount.setText(""+user.getFollowers());
                followingCount.setText(""+user.getFollowing());
                repo.setText("Numer of Repos:" + user.getPublicRepos());
            }
        });
    }
    public void bind(){
        // company, location, bio, repo, followerCount, followingCount;
        avatar = findViewById(R.id.ivAvatar);
        company = findViewById(R.id.tvCompany);
        location = findViewById(R.id.tvLocation);
        bio = findViewById(R.id.tvBio);
        followerCount = findViewById(R.id.tvFollowersCount);
        followingCount = findViewById(R.id.tvFollowingCount);
        repo = findViewById(R.id.tvRepoCount);
    }
    public void animate(){
        FrameLayout layout = findViewById(R.id.frameLayout);
        AnimationDrawable aniDrawable = (AnimationDrawable)layout.getBackground();
        aniDrawable.setEnterFadeDuration(2000);
        aniDrawable.setExitFadeDuration(4000);
        aniDrawable.start();
    }
    public void toRepo(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}
