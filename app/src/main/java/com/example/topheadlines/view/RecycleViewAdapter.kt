package com.example.topheadlines.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.topheadlines.R
import com.example.topheadlines.model.TopHeadlines
import com.squareup.picasso.Picasso

class RecycleViewAdapter(var topHeadlines: TopHeadlines?, var onClickItemListener: OnClickItemListener): RecyclerView.Adapter<TopHeadlinesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHeadlinesViewHolder {
        //return MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.cardlayout, parent, false))
        return TopHeadlinesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_card_layout, parent, false))
    }

    override fun getItemCount(): Int {

        return topHeadlines!!.articles.size
    }

    override fun onBindViewHolder(holder: TopHeadlinesViewHolder, position: Int) {
        holder.description.text = topHeadlines!!.articles[position].description
        holder.title.text = topHeadlines!!.articles[position].title
        Picasso.get().load(topHeadlines!!.articles[position].urlToImage).into(holder.image)

        holder.bind(topHeadlines!!.articles[position], onClickItemListener)
    }
}