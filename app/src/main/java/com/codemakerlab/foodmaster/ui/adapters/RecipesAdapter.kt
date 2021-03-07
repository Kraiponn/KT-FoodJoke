package com.codemakerlab.foodmaster.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codemakerlab.foodmaster.data.models.FoodRecipe
import com.codemakerlab.foodmaster.data.models.Result
import com.codemakerlab.foodmaster.databinding.RecipeRowLayoutBinding
import com.codemakerlab.foodmaster.utils.RecipesDiffUtil

class RecipesAdapter : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {
    private var recipes = emptyList<Result>()


    fun setData(newData: FoodRecipe) {
        val recipeDiffUtil = RecipesDiffUtil(recipes, newData.results)
        val diffUtilResult = DiffUtil.calculateDiff(recipeDiffUtil)

        recipes = newData.results
        diffUtilResult.dispatchUpdatesTo(this)
        //notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentResult = recipes[position]
        holder.bind(currentResult)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    class RecipeViewHolder(private val binding: RecipeRowLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result) {
            binding.result = result
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): RecipeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipeRowLayoutBinding.inflate(
                        layoutInflater,
                        parent,
                        false
                )

                return RecipeViewHolder(binding)
            }
        }

    }

}