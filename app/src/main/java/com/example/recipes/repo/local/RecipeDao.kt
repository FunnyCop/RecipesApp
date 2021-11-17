package com.example.recipes.repo.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao interface RecipeDao {

    @Query("SELECT * FROM recipes ORDER BY name ASC")
    fun getRecipes(): Flow<List<Recipe>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addRecipe(recipe: Recipe)

    @Delete
    fun deleteRecipe(recipe: Recipe)

}