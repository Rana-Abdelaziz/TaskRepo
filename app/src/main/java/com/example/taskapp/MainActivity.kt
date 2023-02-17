package com.example.taskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.coroutineScope
import com.example.taskapp.databinding.ActivityMainBinding
import com.example.taskapp.models.MovieModel
import com.example.taskapp.network.ApiClient
import com.example.taskapp.network.ApiService
import com.example.taskapp.network.MovieRecycleViewAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val apiKey = "k_vizmc9cr"
    var movieList:List<MovieModel.Item> = arrayListOf()
    lateinit var adapter:MovieRecycleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)






lifecycle.coroutineScope.launch {
                val productsService = ApiClient.getClient()?.create(ApiService::class.java)
                 val response =  productsService?.getMovies(apiKey)
    withContext(Dispatchers.Main){
        if (response != null) {
            if(response.isSuccessful){
                System.out.println("dataa"+response.body().toString())
                movieList = response.body()?.items ?: arrayListOf()
                var sortedList = response.body()?.items?.sortedBy { it.year?.toInt() }
                adapter = MovieRecycleViewAdapter(sortedList?: arrayListOf(),this@MainActivity)
                binding.movieRecycleView.adapter = adapter
                adapter.notifyDataSetChanged()

            }
            else{
                System.out.println("dataa"+response.message())



            }
        }
    }

}
        binding.rateTxt.setOnClickListener {
            binding.rateTxt.setTextColor(resources.getColor(R.color.light_blue))
            binding.releaseYearTxt.setTextColor(resources.getColor(R.color.black))

            var sortedList = movieList.sortedBy { it.imDbRating?.toFloat() }.asReversed()
            adapter = MovieRecycleViewAdapter(sortedList?: arrayListOf(),this@MainActivity)
            binding.movieRecycleView.adapter = adapter
            adapter.notifyDataSetChanged()
        }
        binding.releaseYearTxt.setOnClickListener {
            binding.rateTxt.setTextColor(resources.getColor(R.color.black))
            binding.releaseYearTxt.setTextColor(resources.getColor(R.color.light_blue))
            var sortedList = movieList.sortedBy { it.year?.toInt() }
            adapter = MovieRecycleViewAdapter(sortedList?: arrayListOf(),this@MainActivity)
            binding.movieRecycleView.adapter = adapter
            adapter.notifyDataSetChanged()

        }

        setContentView(binding.root)
    }
}