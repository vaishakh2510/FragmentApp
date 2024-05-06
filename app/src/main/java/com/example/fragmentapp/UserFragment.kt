package com.example.fragmentapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UsersFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val users: ArrayList<User> = arrayListOf(
            User(1, "abc"),
            User(2, "pqr"),
            User(3, "lmn"),
            User(4, "xyz"),
            User(5, "tuv"),
            User(6, "ddr"),
            User(7, "tty"),
            User(8, "qwe"),
            User(9, "iop"),
            User(10, "but"),
        )

        val adapter = UserAdapter(users)
        adapter.setOnDeleteListener {
            val pos = users.indexOf(it)
            adapter.notifyItemRemoved(pos)
            adapter.notifyItemRangeChanged(pos, users.size)
            users.remove(it)
        }

        val recUsrs =  view.findViewById<RecyclerView>(R.id.recUsr)
        recUsrs.layoutManager = LinearLayoutManager(requireActivity())
        recUsrs.addItemDecoration(DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL))

        recUsrs.adapter = adapter
    }
}