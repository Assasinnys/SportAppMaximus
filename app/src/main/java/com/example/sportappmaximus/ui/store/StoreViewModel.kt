package com.example.sportappmaximus.ui.store

import androidx.lifecycle.*
import com.example.sportappmaximus.api.Api
import com.example.sportappmaximus.model.GoodsModel
import com.example.sportappmaximus.util.BASE_URL
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class StoreViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _hotGoods = MutableLiveData<MutableList<GoodsModel>>(mutableListOf())
    val hotGoods: LiveData<MutableList<GoodsModel>> = _hotGoods

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).build())
            .build()
            .create(Api::class.java)

    override fun onStart(owner: LifecycleOwner) {
        viewModelScope.launch {
            try {
                val goodsListResponse = retrofit.getGoods()
                if (goodsListResponse.isSuccessful) {
                    val goodList = goodsListResponse.body()
                    _hotGoods.value = goodList?.toMutableList()
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}