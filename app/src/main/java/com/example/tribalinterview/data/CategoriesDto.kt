package com.example.tribalinterview.data

import com.example.tribalinterview.domain.Categories
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesDto(
    val categories: List<String>
)

fun CategoriesDto.toDomain(): Categories {
    return Categories(
        categories = this.categories
    )
}