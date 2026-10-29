package com.example.tribalinterview.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tribalinterview.domain.GetCategoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<CategoriesUIState>(CategoriesUIState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        getCategories()
    }

    private fun getCategories() {
        _uiState.value = CategoriesUIState.Loading

        viewModelScope.launch {
            getCategoriesUseCase().fold(
                onSuccess = { categories ->
                    _uiState.value = CategoriesUIState.Success(categories = categories)

                },
                onFailure = {
                    _uiState.value = CategoriesUIState.Error(messageError = "Error getting categories")
                }
            )
        }
    }
}