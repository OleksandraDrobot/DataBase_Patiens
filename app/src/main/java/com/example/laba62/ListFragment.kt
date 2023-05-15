package com.example.laba62

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laba62.adapter.Adapter
import com.example.laba62.DetailsFragment
import javax.security.auth.callback.Callback

class ListFragment : Fragment(), Callback {

    private lateinit var listRecyclerView: RecyclerView

    private val patients = arrayListOf(
        Patient("Alice", "Smith", "20", "female"),
        Patient("Daniel", "Smith", "15", "male"),
        Patient("Miley", "Syrus", "30", "female"),
        Patient("Max", "Black", "80", "male"),
        Patient("Ketty", "Perry", "25", "female"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listRecyclerView = view.findViewById(R.id.ListRecyclerView)
        listRecyclerView.adapter = Adapter(patients, requireContext(), this)
        listRecyclerView.layoutManager = LinearLayoutManager(activity)
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4: String) = ListFragment()
    }

    fun onItemSelected(i: Int) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.detailsFrame, DetailsFragment.newInstance(patients[i].name, patients[i].lastName, patients[i].age, patients[i].sex))
            ?.addToBackStack(null)
            ?.commit()
    }
}