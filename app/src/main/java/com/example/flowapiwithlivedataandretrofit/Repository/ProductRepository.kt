package com.example.flowapiwithlivedataandretrofit.Repository

import com.example.flowapiwithlivedataandretrofit.model.ProductItem
import com.example.flowapiwithlivedataandretrofit.network.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProductRepository {
    fun getProduct() : Flow<List<ProductItem>> = flow {
        val productList= RetrofitBuilder.api.getProducts()
        emit(productList)
    }.flowOn(Dispatchers.IO)
}