package com.example.sportappmaximus.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GoodsModel(
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "cost")
    val cost: Long,
    @Json(name = "category")
    val category: CategoryModel,
    @Json(name = "image")
    val image: String
)