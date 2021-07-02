package com.example.pollapp.ui.rv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pollapp.R
import com.example.pollapp.ui.PollDB
import com.example.pollapp.ui.data.model.Poll
import kotlinx.android.synthetic.main.fragment_poll_rv.*
import kotlinx.android.synthetic.main.fragment_poll_rv.btn_send_user
import kotlinx.android.synthetic.main.fragment_poll_rv.rv_users
import kotlinx.android.synthetic.main.fragment_users_rv.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PollListFragment : Fragment() {


    private lateinit var data: List<Poll>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_poll_rv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = PollDB.getDatabase(requireContext().applicationContext)
        //el recicler view va a tener un linear loyout manager
        rv_users.layoutManager = LinearLayoutManager(requireContext())
        var adapter = getAdapterOthers()




        GlobalScope.launch {
            data = db.pollDao().getAll()
        }
        Thread.sleep(3000)
            adapter.setData(data)



        rv_users.adapter = adapter
        radioGroup.setOnCheckedChangeListener { group, checkId ->
            if (rb_otras.isChecked) {

                rv_users.adapter = adapter
            }
            if (rb_mias.isChecked) {
                btn_send_user.visibility = View.VISIBLE
            }

        }

    }

    private fun getAdapterOthers(): OthersPollListRecyclerViewAdapter {
        return OthersPollListRecyclerViewAdapter(requireContext())
    }

    private fun getAdapterMy(): MyPollListRecylerViewAdapter {
        return MyPollListRecylerViewAdapter(requireContext())
    }
}
