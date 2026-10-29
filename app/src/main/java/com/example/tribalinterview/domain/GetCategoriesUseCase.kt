package com.example.tribalinterview.domain

import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository
) {
    suspend operator fun invoke(): Result<Categories> = repository.getCategories()
}