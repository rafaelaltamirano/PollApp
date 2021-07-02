package com.example.pollapp.ui.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pollapp.R
import com.example.pollapp.ui.data.model.User

class UsersListRecyclerViewAdapter(private val context: Context,
                                   private val pollCheckListener: UserCheckListener):
    RecyclerView.Adapter<UsersListRecyclerViewAdapter.ViewHolder>() {

    interface UserCheckListener {
        fun getPoll(user:User)
    }
    //listado donde se guardaran los elementos del rv
    private lateinit var items: List<User>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.fragment_user_item, parent, false)
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
    fun setData(users: List<User>) {
        items = users
        notifyDataSetChanged()
    }

    //se usa inner class para que la instancia de esta clase muera cuando muera el recycler view
    //mapea los elementos del layout  y le agrega la info que queremos
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val idView: TextView = view.findViewById(R.id.txt_user_id)
        private val userNameView: TextView = view.findViewById(R.id.txt_user_name)
        private val userSurnameView: TextView = view.findViewById(R.id.txt_user_surname)
        private val userRolView: TextView = view.findViewById(R.id.txt_creator)
        private val checkUserView: CheckBox = view.findViewById(R.id.chkb_send_user)

        //recibe un item y lo carga al textview
        fun binData(item: User) {
            idView.text = item.id.toString()
            userNameView.text = item.name
            userSurnameView.text = item.surname
            userRolView.text = item.rol
            //escucha lo que hace el check
                checkUserView.setOnClickListener{
                pollCheckListener.getPoll(item)
              }

        }
    }
}


