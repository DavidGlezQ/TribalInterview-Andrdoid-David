package com.example.tribalinterview.data

import retrofit2.http.GET

interface CategoriesApi {
    @GET("categories")
    suspend fun getCategories(): List<String>
}