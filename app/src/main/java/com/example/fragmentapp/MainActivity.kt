package com.example.fragmentapp


import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

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
}