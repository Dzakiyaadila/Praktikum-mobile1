package com.example.mycontact.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//interface yg dipake untuk komunikasi antara table atau data dengan controller atau activity
//biasanya dsebut model dalam asitektur mvc

@Dao
interface ContactDao {
    //buat fungsi untuk insert data
    @Insert
    suspend fun insert(contact: Contact) : Long

    //fungsi untk update
    @Update
    suspend fun update(contact: Contact)

    //fungsi untuk delete
    @Delete
    suspend fun delete(contact: Contact)

    @Query("SELECT * FROM contact ORDER BY name ASC")
    suspend fun getAll(): List<Contact>
}