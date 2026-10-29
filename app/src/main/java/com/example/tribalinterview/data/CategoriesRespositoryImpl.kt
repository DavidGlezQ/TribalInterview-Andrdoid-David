package com.example.tribalinterview.data

import com.example.tribalinterview.domain.Categories
import com.example.tribalinterview.domain.CategoriesRepository

class CategoriesRepositoryImpl(
    private val api: CategoriesApi
): CategoriesRepository {

    override suspend fun getCategories(): Result<Categories> {
        return runCatching {
            val response = api.getCategories()

            Categories(categories = response)
        }
    }
}