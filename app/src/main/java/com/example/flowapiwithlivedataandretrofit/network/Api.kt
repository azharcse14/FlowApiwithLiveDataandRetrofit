package com.example.flowapiwithlivedataandretrofit.network

import com.example.flowapiwithlivedataandretrofit.model.ProductItem
import retrofit2.http.GET

interface Api {
    @GET("products")
    suspend fun getProducts() : List<ProductItem>
}