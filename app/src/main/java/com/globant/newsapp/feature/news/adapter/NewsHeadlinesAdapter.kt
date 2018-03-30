package com.globant.newsapp.feature.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.globant.newsapp.Article
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.globant.newsapp.MyApplication
import com.globant.newsapp.R
import com.squareup.picasso.Picasso
import javax.inject.Inject

/**
 * Created by mahesh.chakkarwar on 29/03/18.
 */
class NewsHeadlinesAdapter(val context: Context, picasso: Picasso, newsList: ArrayList<Article>) : RecyclerView.Adapter<NewsHeadlinesAdapter.Companion.ViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)
    val newsHeadlines = newsList;
    val picasso = picasso

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_news_headline, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return newsHeadlines.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.textViewHeadLine?.setText(newsHeadlines.get(position).title)

        picasso.load(newsHeadlines.get(position).urlToImage).error(R.mipmap.ic_launcher_round).into(holder?.imageView)

    }

    companion object Companion {
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var imageView = itemView.findViewById<ImageView>(R.id.imageView)
            var textViewHeadLine = itemView.findViewById<TextView>(R.id.textViewHeadline)
        }
    }


    fun updateList(list: ArrayList<Article>) {
        newsHeadlines.clear()
        newsHeadlines.addAll(0, list)
        notifyDataSetChanged()
    }
}