package com.mungaicodes.roomdemoapp.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mungaicodes.roomdemoapp.R
import com.mungaicodes.roomdemoapp.data.ViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {

    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val adapter = ListAdapter()

        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        viewModel.readAllData.observe(viewLifecycleOwner) { user ->
            adapter.setData(user)
        }

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }

        return view
    }
}