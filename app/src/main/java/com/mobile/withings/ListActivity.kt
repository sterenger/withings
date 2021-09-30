package com.mobile.withings

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.withings.model.ImageResponse
import com.mobile.withings.model.ImageResult
import com.mobile.withings.retrofit.ApiClient
import kotlinx.android.synthetic.main.activity_list_search.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class ListActivity : AppCompatActivity() {

    var searchList = ArrayList<ImageResult>()
    var selectedItems = ArrayList<String>()
    companion object {
        const val SELECTED_DATA = "post_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_search)
        rvItemsSearch.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val searchWord = intent.getStringExtra(MainActivity.SEARCH_WORD)
        getData(searchWord.toString())
        val adapter = ListAdapter(searchList)
        rvItemsSearch.adapter = adapter
        adapter.onItemClick = { item ->
            var resultSearch = selectedItems.find { s -> s == item.webformatURL }
            if (resultSearch == null) {
                selectedItems.add(item.webformatURL)
                item.isSelected = true
            }else{
                selectedItems.removeAt(selectedItems.indexOf(item.webformatURL))
                item.isSelected = false
            }
            btnShowImages.isEnabled = selectedItems.size >= 2
        }

        btnShowImages.setOnClickListener{
            val intentDetail = Intent(this@ListActivity, DetailActivity::class.java)
            intentDetail.putStringArrayListExtra(SELECTED_DATA, selectedItems as ArrayList<String?>?)
            startActivity(intentDetail)
        }
    }

    private fun getData(wordSearch : String) {
        val call: Call<ImageResponse> = ApiClient.getPhotos.searchImage(wordSearch)
        call.enqueue(object : Callback<ImageResponse> {

            override fun onResponse(call: Call<ImageResponse>?, response: Response<ImageResponse>) {
                Log.d("Response", response.body().toString())
                searchList.addAll(response.body()!!.hits)
                rvItemsSearch.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<ImageResponse>?, t: Throwable?) {
                println("Process Failed")
                if (t != null) {
                    Log.d("GET api",t.message.toString())
                }
            }
        })

    }
}