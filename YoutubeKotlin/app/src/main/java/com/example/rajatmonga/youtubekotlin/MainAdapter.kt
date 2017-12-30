package com.example.rajatmonga.kotlinyouttubelbta

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.video_row.view.*

/**
 * Created by rajatmonga on 12/28/17.
 */
class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>() {

    val videoTitles = listOf<String>("First Title", "Second Title", "Third")

    // numberOfItems

    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {

        // how do we even create a view

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        //val videoTitle = videoTitles.get(position)

        val video = homeFeed.videos.get(position)
        holder?.view?.textView_video_title?.text = video.name

    }

}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view){

}



