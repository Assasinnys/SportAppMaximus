package com.example.sportappmaximus.ui.store

import androidx.lifecycle.*
import com.example.sportappmaximus.api.Api
import com.example.sportappmaximus.model.GoodsModel
import com.example.sportappmaximus.util.BASE_URL
import com.example.sportappmaximus.util.CATEGORY_EQUIPMENT
import com.example.sportappmaximus.util.CATEGORY_FOOD
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class StoreGoodsListViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _goodsList = MutableLiveData<MutableList<GoodsModel>>(mutableListOf())
    val goodsList: LiveData<MutableList<GoodsModel>> get() = _goodsList

    private var category = CATEGORY_FOOD

    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).build())
            .build()
            .create(Api::class.java)

    fun notifySelectedCategory(category: String?) {
        when (category) {
            CATEGORY_FOOD -> this.category = CATEGORY_FOOD
            CATEGORY_EQUIPMENT -> this.category = CATEGORY_EQUIPMENT
        }
    }

    override fun onStart(owner: LifecycleOwner) {
        viewModelScope.launch {
            try {
                val response = retrofit.getGoods(category)
                if (response.isSuccessful)
                    _goodsList.value = response.body()?.toMutableList()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}