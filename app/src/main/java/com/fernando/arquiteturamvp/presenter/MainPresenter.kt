package com.fernando.arquiteturamvp.presenter

import android.util.Log
import com.fernando.arquiteturamvp.model.Country
import com.fernando.arquiteturamvp.model.CountryApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(view: View) {
    private var view: View
    private val api by lazy { CountryApi.getCountryService().getCountries() }
    private val listCountries = mutableListOf<Country>()

    init{
        this.view = view
        fetchCountries()
    }

    fun fetchCountries(){
        api.enqueue(object : Callback<List<Country>>{
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                if (response.isSuccessful){
                    response.body().let {
                        view.setValues(it as List<Country>)
                    }
                }
            }
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Log.d("TAG", t.localizedMessage)
                view.onError()
            }
        })

    }
    fun onRefresh() { fetchCountries() }

    interface View{
    fun setValues(countries: List<Country>)
    fun onError()
    }
}