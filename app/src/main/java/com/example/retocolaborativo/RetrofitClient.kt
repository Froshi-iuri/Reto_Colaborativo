package com.example.retocolaborativo

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitClient {
    private const val BASE_URL = "https://dummyjson.com/"

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY

    }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}