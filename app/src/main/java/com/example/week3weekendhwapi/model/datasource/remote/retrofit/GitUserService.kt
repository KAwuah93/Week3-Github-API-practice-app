package com.example.week3weekendhwapi.model.datasource.remote.retrofit

import com.example.week3weekendhwapi.Repository
import com.example.week3weekendhwapi.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface GitUserService {
    //Lets do this thing
    companion object{
        fun createService() : GitUserService =
                RetrofitHelper().RetrofitHelperInstance().create(GitUserService::class.java)
    }
    @GET("users/KAwuah93")
    fun getUserProfile(): Observable<UserResponse>
    //I hate jose
    @GET("users/KAwuah93/repos")
    fun getReposList(): Observable<List<Repository>>

}