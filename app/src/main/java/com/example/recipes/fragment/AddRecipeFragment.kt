package com.example.recipes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipes.databinding.AddRecipeFragmentBinding
import com.example.recipes.repo.local.Recipe
import com.example.recipes.viewmodel.RecipeViewModel

class AddRecipeFragment : Fragment() {

    private var _binding: AddRecipeFragmentBinding? = null
    private val binding get() = _binding!!

    private val recipeViewModel by viewModels<RecipeViewModel>()

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ) = AddRecipeFragmentBinding.inflate(

        layoutInflater,
        container,
        false

    ).also { _binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initListeners()

    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null

    }

    private fun initListeners() {

        binding.btnSubmit.setOnClickListener {

            val name = binding.etName.text.toString()
            val description = binding.etDescription.text.toString()
            val body = binding.etBody.text.toString()

            recipeViewModel.addRecipe(Recipe(name = name, description = description, body = body))

            navigateHome()

        }

        binding.btnHome.setOnClickListener { navigateHome() }

    }

    private fun navigateHome() =
        findNavController().navigate(AddRecipeFragmentDirections.actionAddRecipeFragmentToMainFragment())

}