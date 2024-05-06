package com.example.fragmentapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class User(
    val id : Int,
    val usNm: String
)

typealias OnDeleteListener = (user: User) -> Unit

class UserAdapter(
    val users : List<User>
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    //    private lateinit var deleteListener: (pos : Int) -> Unit
    private lateinit var deleteListener: OnDeleteListener

    //    fun setOnDeleteListener(listener : (pos : Int) -> Unit) {
    fun setOnDeleteListener(listener : OnDeleteListener) {
        deleteListener = listener
    }
    class UserViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val txtUsNm : TextView = view.findViewById(R.id.textView3)
        val txtId: TextView = view.findViewById(R.id.textView5)
        val imgDel: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.txtUsNm.text = users.get(position).usNm
        holder.txtId.text = "${users[position].id}"
        holder.imgDel.setOnClickListener { deleteListener(users[position]) }
    }
}