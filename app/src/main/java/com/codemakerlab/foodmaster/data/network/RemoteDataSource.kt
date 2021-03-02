package com.codemakerlab.foodmaster.data.network

import com.codemakerlab.foodmaster.data.models.FoodRecipe
import com.codemakerlab.foodmaster.data.network.FoodRecipesAPI
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
        private val foodRecipesAPI: FoodRecipesAPI
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipesAPI.getRecipes(queries)
    }

}