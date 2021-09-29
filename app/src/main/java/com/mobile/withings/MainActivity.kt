package com.mobile.withings

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    companion object {
        val SEARCH_WORD = "post_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSearch = findViewById<Button>(R.id.btnSearch)
        val edSearch = findViewById<EditText>(R.id.etSearch)
        btnSearch.setOnClickListener {
            if (edSearch.text.isNotEmpty()){
                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra(SEARCH_WORD, edSearch.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this@MainActivity, "No word to search !", Toast.LENGTH_SHORT).show()
            }
        }
    }


}