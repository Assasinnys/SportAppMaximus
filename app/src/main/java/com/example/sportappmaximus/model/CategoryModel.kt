package com.example.sportappmaximus.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryModel(
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "image")
    val image: String
)