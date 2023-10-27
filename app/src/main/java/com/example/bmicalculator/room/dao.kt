package com.example.bmicalculator.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface dao {

    @Insert
    fun insertLogin(data: data)

}