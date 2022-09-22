package com.mungaicodes.roomdemoapp.fragments.update

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
import androidx.navigation.fragment.navArgs
import com.mungaicodes.roomdemoapp.R
import com.mungaicodes.roomdemoapp.model.User
import com.mungaicodes.roomdemoapp.viewmodels.ViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {


    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        view.update_first_name.setText(args.currentUser.firstName)
        view.update_last_name.setText(args.currentUser.lastName)
        view.update_age.setText(args.currentUser.age.toString())

        view.update_button.setOnClickListener {
            updateItem()
        }

        return view
    }

    private fun updateItem() {
        val firstName = update_first_name.text.toString()
        val lastName = update_last_name.text.toString()
        val age = Integer.parseInt(update_age.text.toString())

        if (inputCheck(firstName, lastName, update_age.text)) {
            val updatedUser = User(args.currentUser.id, firstName, lastName, age)

            viewModel.updateUser(updatedUser)

            findNavController().navigate(R.id.action_updateFragment_to_listFragment)

            Toast.makeText(requireContext(), "Successfully updated user", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Update Failure, fill all the fields!!!", Toast.LENGTH_LONG).show()

        }
    }


    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(
            age
        ))
    }

}