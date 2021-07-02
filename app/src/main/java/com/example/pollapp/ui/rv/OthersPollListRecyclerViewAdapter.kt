package com.example.pollapp.ui.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pollapp.R
import com.example.pollapp.ui.data.model.Poll

//este adapter hereda de recycler view adapter
class OthersPollListRecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<OthersPollListRecyclerViewAdapter.ViewHolder>() {

    //listado donde se guardaran los elementos del rv
    private lateinit var items: List<Poll>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_poll_item, parent, false)
        return ViewHolder(view)
    }

    // esto va iterando por cada posicion
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binData(item)
    }

    //devuelve el tamaño de la lista
    override fun getItemCount(): Int = items.size

    //actualiza los datos del rv
    fun setData(polls: List<Poll>) {
        items = polls
        notifyDataSetChanged()
    }

    //se usa inner class para que la instancia de esta clase muera cuando muera el recycler view
    //mapea los elementos del layout  y le agrega la info que queremos
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleView: TextView = view.findViewById(R.id.txt_user_name)
        private val creatorView: TextView = view.findViewById(R.id.txt_creator)

        //recibe un item y lo carga al textview
        fun binData(item: Poll) {
            titleView.text = item.title
            creatorView.text = item.creator
        }
    }
}