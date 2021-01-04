package com.example.sherlock.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sherlock.model.Item

@Dao
interface ItemDao {

    // CRUD

    @Query("SELECT * FROM itemTable")
    fun getAll(): LiveData<List<Item>>

    @Insert
    fun insert(item: Item)

    @Update
    fun update(item: Item)

    @Delete
    fun delete(item: Item)

    @Query("DELETE FROM itemTable")
    fun deleteAll()

    @Query("SELECT * FROM itemTable WHERE status = 'Gevonden'")
    fun getAllFound(): LiveData<List<Item>>

    @Query("SELECT * FROM itemTable WHERE status = 'Verloren'")
    fun getAllLost(): LiveData<List<Item>>
}