package com.example.topheadlines.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.topheadlines.model.Articles
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_card_layout.view.*

class TopHeadlinesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bind(articles: Articles, onClickItemListener: OnClickItemListener) {
        itemView.setOnClickListener{
            onClickItemListener.onClick(articles)
        }
    }

    var title = itemView.tv_tittle
    var description = itemView.tv_description
    var image = itemView.iv_headline
}