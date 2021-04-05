package com.rifdahalf.newsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rifdahalf.newsapp.model.Article
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(var context : Context, var listNews : List<Article?>?) //parameter
    : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    inner class NewsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        //untuk menggabungkan data dan view (tampilan)
        fun bind (news : Article){
            with(itemView){
                tv_item_title_news.text = news.title
                tv_date_item_news.text = news.publishedAt
                tv_time_item_news.text = news.author

                Glide.with(context).load(news.urlToImage).centerCrop().into(iv_item_news)

            }
        }
    }


    //layout mana yang mau digabungin
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    //untuk mengatur data sesuai posisi list
    //data ke 1, berarti posisi ke 0
    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.bind(listNews?.get(position)!!)
    }

    //banyak data yang mau ditampilin/ buat ngitung jumlah datanya
    override fun getItemCount(): Int = listNews!!.size



}