package com.mungaicodes.roomdemoapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mungaicodes.roomdemoapp.R
import com.mungaicodes.roomdemoapp.model.User
import com.mungaicodes.roomdemoapp.viewmodels.ViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        view.update_button.setOnClickListener {
            insertDataToDataBase()
        }

        return view
    }

    private fun insertDataToDataBase() {
        val firstName = update_first_name.text.toString()
        val lastName = update_last_name.text.toString()
        val age = update_age.text

        if (inputCheck(firstName, lastName, age)) {
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            viewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added user", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Fill out all the fields", Toast.LENGTH_LONG).show()

        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(age))
    }
}