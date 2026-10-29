package com.example.tribalinterview.domain

interface CategoriesRepository {
    suspend fun getCategories(): Result<Categories>
}