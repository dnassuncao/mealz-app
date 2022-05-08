package br.com.dnassuncao.mealzapp.model

import br.com.dnassuncao.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }

}