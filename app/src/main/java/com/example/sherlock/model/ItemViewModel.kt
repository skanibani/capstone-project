package com.example.sherlock.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.sherlock.database.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ItemViewModel(application: Application) : AndroidViewModel(application) {

    private val itemRepository = ItemRepository(application.applicationContext)
    var items = itemRepository.getAllItems()

    fun getAllItems() {
        items = itemRepository.getAllItems()
    }

    fun insertItem(item: Item) {
        itemRepository.insertItem(item)
    }
}