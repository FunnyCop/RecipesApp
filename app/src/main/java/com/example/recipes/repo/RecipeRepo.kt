package com.example.recipes.repo

import com.example.recipes.repo.local.Recipe
import com.example.recipes.repo.local.RecipeDao
import kotlinx.coroutines.flow.Flow

class RecipeRepo(private val recipeDao: RecipeDao) {

    val recipes: Flow<List<Recipe>> = recipeDao.getRecipes()

    fun addRecipe(recipe: Recipe) = recipeDao.addRecipe(recipe)

    fun deleteRecipe(recipe: Recipe) = recipeDao.deleteRecipe(recipe)

}