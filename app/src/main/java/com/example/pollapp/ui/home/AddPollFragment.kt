package com.example.pollapp.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.pollapp.R
import com.example.pollapp.ui.PollDB
import com.example.pollapp.ui.data.model.Poll
import com.example.pollapp.ui.data.model.User
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddPollFragment : Fragment() {

    private lateinit var data: List<Poll>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_new_poll, container, false)
        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = PollDB.getDatabase(requireContext().applicationContext)


        val poll1 = Poll(
            0L,
            "encuesta 1",
           "rafael"
        )

        GlobalScope.launch {
            db.pollDao().insert(poll1)
            data = db.pollDao().getAll()
        }
        Thread.sleep(3000)
        data.map {
            Toast.makeText(requireContext(),it.title,Toast.LENGTH_SHORT).show()
        }
    }


}