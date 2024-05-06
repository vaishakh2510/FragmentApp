package com.example.fragmentapp

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.Retrofit

class MyApp : Application() {
    private lateinit var crScp: CoroutineScope
    private lateinit var retrofit: Retrofit
    private lateinit var crud: AppCrud

    override fun onCreate() {
        super.onCreate()
        crScp = CoroutineScope(Job() + Dispatchers.Main)
        retrofit = RetrofitClient.create()
        crud = retrofit.create(AppCrud::class.java)
    }

    fun getRetrofit() = retrofit

    fun crudInterface() = crud

    fun coroutineScope() = crScp
}