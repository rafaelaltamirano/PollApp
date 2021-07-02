package com.example.pollapp.ui.rv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pollapp.R
import com.example.pollapp.ui.data.model.User
import kotlinx.android.synthetic.main.fragment_users_rv.*

class UserListFragment : Fragment(), UsersListRecyclerViewAdapter.UserCheckListener{

    private lateinit var items: ArrayList<User>
    //var auxiliar donde se guardaran los items marcados del check
    private var itemsSelected: ArrayList<User> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_users_rv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val user1 = User(
            id = 1,
            name = "Matias",
            surname = "Quiroga",
            rol = "Desarollador"

        )
        val user2 = User(
            id = 1,
            name = "Mauro",
            surname = "Rodriguez",
            rol = "Desarollador"
        )
        val user3 = User(
            id = 1,
            name = "Cecilia",
            surname = "Lavallen",
            rol = "People"
        )
        items = arrayListOf(user1, user2, user3)


        //el recicler view va a tener un linear loyout manager
        rv_users.layoutManager = LinearLayoutManager(requireContext())
        //el this es el listener que esta esperando el recycler
        var adapter = UsersListRecyclerViewAdapter(requireContext(),this)
        adapter.setData(items)
        rv_users.adapter = adapter

        btn_send_user.setOnClickListener {
            //foreach, recorro la lista de items, it es el item que esta recorriendo ahora
             itemsSelected.map{
                Toast.makeText(requireContext(),it.name,Toast.LENGTH_SHORT).show()
             }
        }

       // txt_searchUser.addTextChangedListener()
        // toma el texto del rv xml, lo busca dentro de la lista del rv, crea una lista filtrada y la muestra con el set data
    }



    //implemento la interface del metodo que se ejecuta cuando hago click en el check
    override fun getPoll(user: User) {
        if(itemsSelected.contains(user)){
            itemsSelected.remove(user)
        }
        else{
            itemsSelected.add(user)
        }
    }


}