package com.example.sportappmaximus.api

import com.example.sportappmaximus.model.GoodsModel
import com.example.sportappmaximus.util.GOODS_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(GOODS_ENDPOINT)
    suspend fun getGoods(): Response<List<GoodsModel>>

    @GET(GOODS_ENDPOINT)
    suspend fun getGoodsWithCategory(@Query("category") category: Int): Response<List<GoodsModel>>
}