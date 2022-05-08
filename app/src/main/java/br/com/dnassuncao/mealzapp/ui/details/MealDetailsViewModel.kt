package br.com.dnassuncao.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.com.dnassuncao.mealzapp.model.MealsRepository
import br.com.dnassuncao.mealzapp.model.response.MealResponse

class MealDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var mealState = mutableStateOf<MealResponse?>(null)
    private val repository: MealsRepository = MealsRepository.getInstance()

    init {
        val mealId = savedStateHandle.get<String>("meal_category_id") ?: ""
        mealState.value = repository.getMeal(mealId)
    }

}