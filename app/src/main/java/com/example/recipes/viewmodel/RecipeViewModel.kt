package com.example.recipes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.recipes.repo.RecipeRepo
import com.example.recipes.repo.local.Recipe
import com.example.recipes.repo.local.RecipeDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(application: Application) : AndroidViewModel(application) {

    private val recipeRepository = RecipeRepo(RecipeDatabase.getDatabase(application).recipeDao())

    val recipes = recipeRepository.recipes.asLiveData(viewModelScope.coroutineContext + Dispatchers.IO)

    fun addRecipe(recipe: Recipe) {

        viewModelScope.launch(Dispatchers.IO) {

            recipeRepository.addRecipe(recipe)

        }

    }

    fun deleteRecipe(recipe: Recipe) {

        viewModelScope.launch(Dispatchers.IO) {

            recipeRepository.deleteRecipe(recipe)

        }

    }

}