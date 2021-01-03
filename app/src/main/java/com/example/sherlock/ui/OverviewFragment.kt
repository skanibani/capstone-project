package com.example.sherlock.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sherlock.R

import com.example.sherlock.databinding.FragmentOverviewBinding
import com.example.sherlock.model.Item
import com.example.sherlock.model.ItemViewModel

class OverviewFragment : Fragment() {

    // Binding
    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!

    // Needed for RecyclerView
    private val registeredItems = arrayListOf<Item>()
    private val itemAdapter = ItemAdapter(registeredItems)

    // ViewModel see onViewCreated()
    private lateinit var viewModel: ItemViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        init()

        observeViewModel()
    }

    private fun init() {
        // Set up ViewHolder and Adapter

        binding.rvRegisteredItems.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.rvRegisteredItems.adapter = itemAdapter
        binding.rvRegisteredItems.addItemDecoration(
            DividerItemDecoration(
                context,
            DividerItemDecoration.VERTICAL
            )
        )

        // Fab
        binding.fabOverview.setOnClickListener {
            findNavController().navigate(R.id.action_OverviewFragment_to_addItemActivity)
        }

    }

    private fun observeViewModel() {
        viewModel.items.observe(viewLifecycleOwner, Observer<List<Item>> {
            registeredItems.addAll(it)
            itemAdapter.notifyDataSetChanged()
        })
    }
}