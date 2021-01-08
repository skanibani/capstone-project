package com.example.sherlock.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.sherlock.databinding.FragmentAddItemBinding
import com.example.sherlock.model.Item
import com.example.sherlock.model.ItemViewModel

class AddItemFragment : Fragment() {

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ItemViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        initViews()
    }

    private fun initViews() {
        binding.btnRegisterItem.setOnClickListener {

            // TODO safety check before creating new item
            val newItem = Item(
                    flight = binding.txtInputFlight.editText?.text.toString(),
                    seat = binding.txtInputSeat.editText?.text.toString(),
                    category = binding.inputAddItemType.editText?.text.toString(),
                    brand = binding.inputAddItemBrand.editText?.text.toString(),
                    description = binding.inputAddItemDescription.editText?.text.toString(),
                    details = binding.inputAddItemDetails.editText?.text.toString(),
                    material = binding.inputAddItemMaterial.editText?.text.toString(),
                    ownerName = "None",
                    location = binding.inputAddItemLocation.editText?.text.toString(),
                    status = binding.inputAddItemStatus.editText?.text.toString()
            )

            registerItem(newItem)

            // TODO refactor app so proper navigation is possible
            findNavController().navigateUp()
        }
    }

    private fun registerItem(item: Item) {
        viewModel.insertItem(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}