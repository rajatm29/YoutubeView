package com.example.rajatmonga.kotlinyouttubelbta

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rajatmonga.youtubekotlin.CourseDetailActivity
import com.example.rajatmonga.youtubekotlin.HomeFeed
import com.example.rajatmonga.youtubekotlin.Video
import com.squareup.picasso.Picasso
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
        // how we create a view

        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)

        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        //val videoTitle = videoTitles.get(position)

        val video = homeFeed.videos.get(position)
        holder?.view?.textView_video_title?.text = video.name
        holder?.view?.textView_channel_name?.text = video.channel.name + " • " + "100k Views\n5 days ago"

        val thumbnailImageView = holder?.view?.imageView_video_thumbnail

        Picasso.with(holder?.view?.context).load(video.imageUrl)
                .into(thumbnailImageView)

        val channelProfileImageView = holder?.view?.imageView_image_profile
        Picasso.with(holder?.view?.context).load(video.channel.profileImageUrl).into(channelProfileImageView)

        holder?.video = video
    }
}

class CustomViewHolder(val view: View, var video: Video?= null): RecyclerView.ViewHolder(view){

    companion object {
        val VIDEO_TITLE_KEY = "VIDEO_TITLE"
        val VIDEO_ID_KEY = "VIDEO_ID"
    }

    init {

        view.setOnClickListener {

            val intent = Intent(view.context, CourseDetailActivity::class.java)
            intent.putExtra(VIDEO_TITLE_KEY, video?.name)
            intent.putExtra(VIDEO_ID_KEY, video?.id)

            view.context.startActivity(intent)

        }

    }

}



