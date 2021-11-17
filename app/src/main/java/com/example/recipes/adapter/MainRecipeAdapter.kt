package com.example.recipes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipes.databinding.RecipeItemBinding
import com.example.recipes.repo.local.Recipe

class MainRecipeAdapter(

    private val recipes: List<Recipe>,
    private val deleteRecipe: (Recipe) -> Unit,
    private val recipeDetails: (Recipe) -> Unit

) : RecyclerView.Adapter<MainRecipeAdapter.MainRecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MainRecipeViewHolder.getInstance(parent)

    override fun onBindViewHolder(holder: MainRecipeViewHolder, position: Int) =
        holder.loadRecipe(recipes[position], deleteRecipe, recipeDetails)

    override fun getItemCount() = recipes.size

    class MainRecipeViewHolder(

        private val binding: RecipeItemBinding

    ) : RecyclerView.ViewHolder(binding.root) {

        companion object {

            fun getInstance(parent: ViewGroup) = RecipeItemBinding.inflate(

                LayoutInflater.from(parent.context),
                parent,
                false

            ).run { MainRecipeViewHolder(this) }

        }

        fun loadRecipe(

            recipe: Recipe,
            deleteRecipe: (Recipe) -> Unit,
            recipeDetails: (Recipe) -> Unit

        ) = with(binding) {

            tvName.text = recipe.name
            tvDescription.text = recipe.description
            btnDelete.setOnClickListener { deleteRecipe(recipe) }
            btnDetail.setOnClickListener { recipeDetails(recipe) }

        }

    }

}