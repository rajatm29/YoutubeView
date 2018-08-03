package com.example.rajatmonga.kotlinyouttubelbta

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.rajatmonga.youtubekotlin.HomeFeed
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        //recyclerView_main.adapter = MainAdapter()
        fetchJson()
    }

    fun fetchJson() {
        println("attempting to fetch JSON")
        //URL HERE
        val url = "https://api._.com/youtube/home_feed"

        val client = OkHttpClient()
        //converted OkHttp Java syntax to Kotlin from Docs for request
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object: Callback {

            override fun onResponse(call: Call?, response: Response?) {
                val body = response?.body()?.string()
                println(body)
                val gson = GsonBuilder().create()
                val homefeed = gson.fromJson(body, HomeFeed:: class.java)
                runOnUiThread{
                    recyclerView_main.adapter = MainAdapter(homefeed)
                }

            }
            override fun onFailure(call: Call?, e: IOException?) {
                println("failed to execute request")
            }
        })
    }
}
