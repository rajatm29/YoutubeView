package com.example.rajatmonga.youtubekotlin

/**
 * Created by rajatmonga on 1/11/18.
 */


import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rajatmonga.kotlinyouttubelbta.CustomViewHolder
import com.example.rajatmonga.kotlinyouttubelbta.R
import kotlinx.android.synthetic.main.activity_main.*

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        //recyclerView_main.setBackgroundColor(Color.RED)
        recyclerView_main.layoutManager = LinearLayoutManager(this)
        recyclerView_main.adapter = CourseDetailAdapter()

        val navBarTitle = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title = navBarTitle


        val videoId = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)

        val courseDetailUrl = "https://api.letsbuildthatapp.com/youtube/course_detail?id=" + videoId

        //println(courseDetailUrl)

        //fetchJSON()




    }

    private fun fetchJSON() {

    }


    private class CourseDetailAdapter: RecyclerView.Adapter<CourseLessonViewHolder>() {

        override fun getItemCount(): Int {
            return 5
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CourseLessonViewHolder{

            val layoutInflator = LayoutInflater.from(parent?.context)
            val customView = layoutInflator.inflate(R.layout.course_lesson_row, parent, false)

           // val blueView = View(parent?.context)
           // blueView.setBackgroundColor(Color.BLUE)
           // blueView.minimumHeight = 50

            return CourseLessonViewHolder(customView)
        }

        override fun onBindViewHolder(holder: CourseLessonViewHolder?, position: Int) {



        }

    }

    private class CourseLessonViewHolder(val customView: View): RecyclerView.ViewHolder(customView) {



    }
}