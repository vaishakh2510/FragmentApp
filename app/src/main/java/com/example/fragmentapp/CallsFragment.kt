package com.example.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class CallsFragment : Fragment() {

//    private val crScp = CoroutineScope(Job() + Dispatchers.Main)
//    private lateinit var retrofit: Retrofit
//    private lateinit var crud: AppCrud

//    private lateinit var parentActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app: MyApp = activity?.application as MyApp

//        parentActivity = activity as MainActivity

//        retrofit = RetrofitClient.create()
//        crud = retrofit.create(AppCrud::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recWeb = view.findViewById<RecyclerView>(R.id.recWeb)
        recWeb.layoutManager = LinearLayoutManager(recWeb.context)

        val app: MyApp = activity?.application as MyApp

        app.coroutineScope().launch {

            val apps: List<App>? = app.crudInterface().apps().body()

            apps?.let {
                println(apps)
                val adapter = AppsAdapter(apps)
                recWeb.adapter = adapter
            }
        }
    }
}