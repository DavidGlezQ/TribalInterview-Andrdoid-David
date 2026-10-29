package com.example.tribalinterview.ui.presentation

import com.example.tribalinterview.domain.Categories

sealed interface CategoriesUIState {
    data object Loading: CategoriesUIState
    data class Success(val categories: Categories): CategoriesUIState
    data class Error(val messageError: String): CategoriesUIState
}