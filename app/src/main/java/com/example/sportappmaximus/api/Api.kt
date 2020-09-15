package com.example.sportappmaximus.api

import com.example.sportappmaximus.model.ProductModel
import com.example.sportappmaximus.util.GOODS_ENDPOINT
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(GOODS_ENDPOINT)
    suspend fun getGoods(): Response<List<ProductModel>>

    @GET(GOODS_ENDPOINT)
    suspend fun getGoodsTest(): ResponseBody

    @GET(GOODS_ENDPOINT)
    suspend fun getGoodsWithCategory(@Query("category") category: Int): Response<List<ProductModel>>
}