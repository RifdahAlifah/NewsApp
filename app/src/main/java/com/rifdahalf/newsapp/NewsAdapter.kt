package com.rifdahalf.newsapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rifdahalf.newsapp.model.Article

class NewsAdapter(var context : Context, var listNews : List<Article?>?)
    : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        TODO("Not yet implemented")
    }


    //banyak data yang mau ditampilin
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}