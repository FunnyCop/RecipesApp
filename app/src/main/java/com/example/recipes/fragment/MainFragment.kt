package com.example.recipes.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.adapter.MainRecipeAdapter
import com.example.recipes.databinding.MainFragmentBinding
import com.example.recipes.repo.local.Recipe
import com.example.recipes.viewmodel.RecipeViewModel

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val recipeViewModel by viewModels<RecipeViewModel>()

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ) = MainFragmentBinding.inflate(

        layoutInflater,
        container,
        false

    ).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener {

            findNavController().navigate(

                MainFragmentDirections.actionMainFragmentToAddRecipeFragment()

            )

        }

        recipeViewModel.recipes.observe(viewLifecycleOwner) {

            binding.rvMain.adapter = MainRecipeAdapter(it, ::deleteRecipe, ::recipeDetails)

        }

    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null

    }

    private fun deleteRecipe(recipe: Recipe) = recipeViewModel.deleteRecipe(recipe)

    private fun recipeDetails(recipe: Recipe) =
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToRecipeDetailsFragment(recipe))

}