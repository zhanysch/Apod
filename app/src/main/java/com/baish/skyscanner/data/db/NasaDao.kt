package com.baish.skyscanner.data.db

import androidx.lifecycle.LiveData
import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.baish.skyscanner.data.model.nasa.imageofday.ImageOfTheDayModel
import com.baish.skyscanner.data.model.nasa.mars.Photos


@Dao
interface NasaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveContent(user: List<ImageOfTheDayModel>)

    @Query("SELECT * FROM ImageOfTheDayModel")
   fun getContent(): LiveData<ImageOfTheDayModel>

   @Insert
   fun insert(data: List<Photos>)

   @Query("SELECT * FROM Photos")
   fun getAll(): PagingSource<Int, Photos>

}