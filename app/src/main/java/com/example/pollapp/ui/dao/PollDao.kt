package com.example.pollapp.ui.dao

import androidx.room.*
import com.example.pollapp.ui.data.model.Poll

@Dao
interface PollDao {


    //creo las funciones de tipo suspencion para que no se ejecuten en el hilo principal
    //ahora puedo ejecutarlo en cualquier bloque de corrutinas
    @Query("SELECT * FROM Poll")
     fun getAll():List<Poll>

    @Query("SELECT * FROM Poll WHERE id= :id")
    fun getById(id: Int):Poll

    @Update
     fun update(poll: Poll)

    @Delete
     fun delete(poll: Poll)

    @Insert
     fun insert(poll: List<Poll>)

    @Insert
     fun insert(poll: Poll)

}