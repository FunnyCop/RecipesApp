package com.example.recipes.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.recipes.databinding.RecipeDetailsFragmentBinding
import com.example.recipes.repo.local.Recipe

class RecipeDetailsFragment : Fragment() {

    private var _binding: RecipeDetailsFragmentBinding? = null
    private val binding get() = _binding!!

    private var _recipe: Recipe? = null
    private val recipe get() = _recipe!!

    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ) = RecipeDetailsFragmentBinding.inflate(

        layoutInflater,
        container,
        false

    ).also {

        _binding = it
        _recipe = arguments?.getParcelable("recipe")

    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()

    }

    override fun onDestroyView() {

        super.onDestroyView()

        _binding = null

    }

    private fun initViews() {

        binding.tvName.text = recipe.name
        binding.tvDescription.text = recipe.description
        binding.tvBody.text = recipe.body

    }

    private fun initListeners() {

        binding.btnHome.setOnClickListener {

            findNavController().navigate(RecipeDetailsFragmentDirections.actionRecipeDetailsFragmentToMainFragment())

        }

    }

}