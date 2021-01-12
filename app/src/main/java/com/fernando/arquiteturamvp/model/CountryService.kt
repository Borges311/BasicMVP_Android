package com.fernando.arquiteturamvp.model

import retrofit2.Call
import retrofit2.http.GET

interface CountryService {

    @GET("all")
    fun getCountries(): Call<List<Country>>

}