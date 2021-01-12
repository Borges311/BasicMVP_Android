package com.fernando.arquiteturamvp.model


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CountryApi {
    private val URL = "https://restcountries.eu/rest/v2/"

    fun getCountryService(): CountryService =
         Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryService::class.java)

}