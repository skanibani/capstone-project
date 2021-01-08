package com.example.sherlock.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.sherlock.dao.ItemDao
import com.example.sherlock.model.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ItemRepository(context: Context) {

    // Repository is responsible for handling many data sources.
    // Handle scope dispatchers in this repository.

    private val itemDao: ItemDao
    private val mainScope = CoroutineScope(Dispatchers.Main)

    init {
        // Dependency injection for context
        itemDao = ItemDatabase.getInstance(context).itemDao
    }

    // TODO implement safety checks for CRUDs

    fun getAllItems(): LiveData<List<Item>> {
        return itemDao.getAll()
    }

    fun getAllLost(): LiveData<List<Item>> {
        return itemDao.getAllLost()
    }

    fun getAllFound(): LiveData<List<Item>> {
        return itemDao.getAllFound()
    }

    fun insertItem(item: Item) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                itemDao.insert(item)
            }
        }
    }

    fun updateItem(item: Item) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                itemDao.update(item)
            }
        }
    }

    fun deleteItem(item: Item) {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                itemDao.delete(item)
            }
        }
    }

    fun deleteAllItems() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                itemDao.deleteAll()
            }
        }
    }
}
