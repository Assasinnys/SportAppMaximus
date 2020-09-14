package com.example.sportappmaximus.ui.store

import androidx.lifecycle.*
import com.example.sportappmaximus.api.Api
import com.example.sportappmaximus.model.ProductModel
import com.example.sportappmaximus.util.BASE_URL
import com.example.sportappmaximus.util.CATEGORY_EQUIPMENT
import com.example.sportappmaximus.util.CATEGORY_SPORTSWEAR
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class StoreGoodsListViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _goodsList = MutableLiveData<MutableList<ProductModel>>(mutableListOf())
    val productList: LiveData<MutableList<ProductModel>> get() = _goodsList

    private val _isConnectionError = MutableLiveData(false)
    val isConnectionError: LiveData<Boolean> get() = _isConnectionError

    private val _isDataLoading = MutableLiveData(false)
    val isDataLoading: LiveData<Boolean> get() = _isDataLoading

    private var category = CATEGORY_EQUIPMENT

    private val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).build())
            .build()
            .create(Api::class.java)

    fun notifySelectedCategory(category: Int) {
        this.category = category
    }

    override fun onStart(owner: LifecycleOwner) {
        _isConnectionError.value = false
        viewModelScope.launch {
            _isDataLoading.value = true
            try {
                val response = retrofit.getGoodsWithCategory(category)
                if (response.isSuccessful)
                    _goodsList.value = response.body()?.toMutableList()
                if (category == CATEGORY_SPORTSWEAR) {
                    val response2 = retrofit.getGoodsWithCategory(2)
                    _goodsList.value = _goodsList.value?.plus(response2.body()!!)?.toMutableList()
                }
            } catch (e: IOException) {
                e.printStackTrace()
                _isConnectionError.value = true
            }
            _isDataLoading.value = false
        }
    }
}