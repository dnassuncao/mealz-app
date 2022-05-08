package br.com.dnassuncao.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.dnassuncao.mealzapp.model.MealsRepository
import br.com.dnassuncao.mealzapp.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    // Custom Scope sample
    private val mealsJob = Job()

    init {
        // Custom Scope sample
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)

        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList())

    override fun onCleared() {
        super.onCleared()
        // Custom Scope sample
        mealsJob.cancel()
    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}