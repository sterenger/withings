package com.mobile.withings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.withings.model.DataAdapter
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

       // mPhotoUrl = intent.getStringArrayExtra(ListActivity.SELECTED_DATA)!!
        Log.d("urls",intent.getStringArrayListExtra(ListActivity.SELECTED_DATA)!![0])

        card_recycler_view.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        val adapter = DataAdapter(this,intent.getStringArrayListExtra(ListActivity.SELECTED_DATA)!!)
        card_recycler_view.adapter = adapter
        card_recycler_view.layoutManager= LinearLayoutManager(this)

    }


}