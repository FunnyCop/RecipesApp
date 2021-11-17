package com.example.recipes.repo.local

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {

    abstract fun recipeDao(): RecipeDao

    companion object {

        @Volatile
        private var database: RecipeDatabase? = null

        fun getDatabase(context: Context): RecipeDatabase {

            val instance = database

            if (instance != null)
                return instance

            synchronized(this) {

                return Room.databaseBuilder(

                    context.applicationContext,
                    RecipeDatabase::class.java,
                    "recipes"

                ).build().also { database = it }

            }

        }

    }

}