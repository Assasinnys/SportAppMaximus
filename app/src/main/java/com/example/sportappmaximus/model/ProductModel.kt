package com.example.sportappmaximus.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductModel(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "cost")
    val cost: Long,
    @Json(name = "category")
    val categoryId: Int,
    @Json(name = "image")
    val image: String
)