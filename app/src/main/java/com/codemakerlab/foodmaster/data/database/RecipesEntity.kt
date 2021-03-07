package com.codemakerlab.foodmaster.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codemakerlab.foodmaster.data.models.FoodRecipe
import com.codemakerlab.foodmaster.utils.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
data class RecipesEntity(val foodRecipe: FoodRecipe) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0

}
