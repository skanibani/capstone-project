package com.example.sherlock.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sherlock.R

import com.example.sherlock.model.Item
import com.example.sherlock.model.ItemViewModel
import com.example.sherlock.ui.adapter.ItemAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout

class OverviewFragment : Fragment() {

    // Binding
//    private var _binding: FragmentOverviewBinding? = null
//    private val binding get() = _binding!!

    // ViewBinding does not work with included nav_host_fragments
    // Use regular findViewByID for <include> tags.

    // Needed for RecyclerView
    private val registeredItems = arrayListOf<Item>()
    private val itemAdapter = ItemAdapter(registeredItems)

    // ViewModel see onViewCreated()
    private lateinit var viewModel: ItemViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_overview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ViewModel
        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
        // viewModel.deleteAllItems()
        init(view)

        observeViewModel()
    }

    private fun init(view: View) {
        // Set up ViewHolder and Adapter
        val rvRgisteredItems = view.findViewById<RecyclerView>(R.id.rvRegisteredItems)
        rvRgisteredItems.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        rvRgisteredItems.adapter = itemAdapter
        rvRgisteredItems.addItemDecoration(
            DividerItemDecoration(
                context,
            DividerItemDecoration.VERTICAL
            )
        )

        // Fab
        val fabOverview = view.findViewById<FloatingActionButton>(R.id.fabOverview)
        fabOverview.setOnClickListener {
            findNavController().navigate(R.id.action_OverviewFragment_to_AddItemFragment)
        }

        // Overview Tabs
//        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
//        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                TODO("Not yet implemented")
//            }
//        })
    }

    private fun observeViewModel() {
        viewModel.items.observe(viewLifecycleOwner, Observer<List<Item>> {
            registeredItems.clear()
            registeredItems.addAll(it)
            itemAdapter.notifyDataSetChanged()
        })
    }

    override fun onResume() {
        super.onResume()
        itemAdapter.notifyDataSetChanged()
    }

    private fun viewAllLostItems() {
        viewModel.lostItems.observe(viewLifecycleOwner, Observer<List<Item>> {
            registeredItems.clear()
            registeredItems.addAll(it)
            itemAdapter.notifyDataSetChanged()
        })
    }

    private fun viewAllFoundItems() {
        viewModel.foundItems.observe(viewLifecycleOwner, Observer<List<Item>> {
            registeredItems.clear()
            registeredItems.addAll(it)
            itemAdapter.notifyDataSetChanged()
        })
    }
}