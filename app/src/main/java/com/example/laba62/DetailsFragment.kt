package com.example.laba62

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.laba62.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"

class DetailsFragment : Fragment() {
    private var name: String? = null
    private var lastName: String? = null
    private var age: String? = null
    private var sex: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_PARAM1)
            lastName = it.getString(ARG_PARAM2)
            age = it.getString(ARG_PARAM3)
            sex = it.getString(ARG_PARAM4)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvLastName = view.findViewById<TextView>(R.id.tvLastName)
        val tvAge = view.findViewById<TextView>(R.id.tvAge)
        val tvSex = view.findViewById<TextView>(R.id.tvSex)
        tvName.text = name
        tvLastName.text = lastName
        tvAge.text = age
        tvSex.text = sex
    }

    companion object {
        fun newInstance(name: String, lastName: String, age: String, sex: String) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, name)
                    putString(ARG_PARAM2, lastName)
                    putString(ARG_PARAM3, age)
                    putString(ARG_PARAM4, sex)
                }
            }
    }
}
