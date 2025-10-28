package com.example.mycontact.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//data class --> skema dari sebuah data, sekaligus sebagai blueprintd dari sebuah data

@Entity (tableName = "contact")//memberi tau java kalau ini itu data gitu deh
data class Contact (
    //buat primary key dengan nama id dan tipe data long, lalu kasih default value nol
    @PrimaryKey(autoGenerate = true) val id : Long = 0,
    val name : String,
    val phone : String
)