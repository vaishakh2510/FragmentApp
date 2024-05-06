package com.example.fragmentapp


import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    private val crScp = CoroutineScope(Job() + Dispatchers.Main)
    private lateinit var retrofit: Retrofit
    private lateinit var crud: AppCrud

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        retrofit = RetrofitClient.create()
        crud = retrofit.create(AppCrud::class.java)

        findViewById<Button>(R.id.button).setOnClickListener {
            val txn = supportFragmentManager.beginTransaction()
            txn.replace(R.id.main, UsersFragment())
            txn.commit()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val txn = supportFragmentManager.beginTransaction()
            txn.replace(R.id.main, MessagesFragment())
            txn.commit()
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            val txn = supportFragmentManager.beginTransaction()
            txn.replace(R.id.main, CallsFragment())
            txn.commit()
        }
    }

    fun getRetrofit() = retrofit

    fun crudInterface() = crud

    fun coroutineScope() = crScp
}