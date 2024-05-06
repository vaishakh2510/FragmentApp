package com.example.fragmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MessagesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_messages, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button4).setOnClickListener {
            showOkayCancelDialog()
        }
    }

    private fun showOkayCancelDialog() {
        val dialog: AlertDialog = AlertDialog.Builder(requireActivity())
            .setTitle("Title")
            .setMessage("Message")
            .setPositiveButton("Okay") { _, _ -> st("Okay")}
            .setNegativeButton("Cancel") { di, int -> st("Cancel") }
            .create()
        dialog.show()
    }

    private fun st(msg : String) {
        Toast.makeText(
            requireActivity(),
            msg,
            Toast.LENGTH_LONG
        ).show()
    }
}