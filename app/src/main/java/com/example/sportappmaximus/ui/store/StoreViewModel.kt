package com.example.sportappmaximus.ui.store

import android.util.Log
import androidx.lifecycle.*
import com.example.sportappmaximus.api.Api
import com.example.sportappmaximus.model.ProductModel
import com.example.sportappmaximus.util.BASE_URL
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okio.IOException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class StoreViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _hotGoods = MutableLiveData<MutableList<ProductModel>>(mutableListOf())
    val hotProduct: LiveData<MutableList<ProductModel>> = _hotGoods

    private val _isConnectionError = MutableLiveData(false)
    val isConnectionError: LiveData<Boolean> get() = _isConnectionError

    private val _isDataLoading = MutableLiveData(false)
    val isDataLoading: LiveData<Boolean> get() = _isDataLoading

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.SECONDS).build())
            .build()
            .create(Api::class.java)

    override fun onStart(owner: LifecycleOwner) {
        _isConnectionError.value = false
        viewModelScope.launch {
            _isDataLoading.value = true
            try {
                val productListResponse = retrofit.getGoods()
                if (productListResponse.isSuccessful) {
                    val goodList = productListResponse.body()
                    test()
                    _hotGoods.value = goodList?.toMutableList()?.subList(0, 3)
                }
            } catch (e: IOException) {
                e.printStackTrace()
                _isConnectionError.value = true
            }
            _isDataLoading.value = false
        }
    }

    suspend fun test() {
        val testResult = retrofit.getGoodsTest()
        Log.d("ASD", "Json: ${testResult.string()}")

    }
}