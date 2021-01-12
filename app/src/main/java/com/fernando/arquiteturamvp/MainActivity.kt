package com.fernando.arquiteturamvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fernando.arquiteturamvp.model.Country
import com.fernando.arquiteturamvp.model.CountryAdapter
import com.fernando.arquiteturamvp.presenter.MainPresenter

class MainActivity : AppCompatActivity(), MainPresenter.View {
    private lateinit var presenter: MainPresenter
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var rv: RecyclerView
    private val listValues = arrayListOf<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)


        initRecyclerView()
    }

    private fun initRecyclerView(){
    rv = findViewById(R.id.recyclerView)
    countryAdapter = CountryAdapter(listValues)
        rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = countryAdapter
        }
    }

    override fun setValues(countries: List<Country>) {
        listValues.addAll(countries)
        countryAdapter.notifyDataSetChanged()
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

}