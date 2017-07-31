package com.apps.madnotdead.notiapp.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.apps.madnotdead.notiapp.R
import com.apps.madnotdead.notiapp.data.model.Article
import com.apps.madnotdead.notiapp.utils.loadFromUrl
import com.apps.madnotdead.notiapp.utils.toDateWithFormat

/**
 * Created by madnotdead on 7/29/17.
 */
class ArticlesAdapter(val listener: (Article) -> Unit) : RecyclerView.Adapter<ArticlesAdapter.ArticleHolder> () {


    private var articles: List<Article> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesAdapter.ArticleHolder {
        val  view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ArticleHolder(view)
    }

    override fun onBindViewHolder(holder: ArticlesAdapter.ArticleHolder?, position: Int) {

        with(articles[position]) {
            holder?.bindArticle(this)
            holder?.itemView!!.setOnClickListener { listener (this)}
        }
    }

    override fun getItemCount(): Int =  articles.size

    fun loadArticles(articles: List<Article>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    fun clearArticles() {
        this.articles = ArrayList()
        notifyDataSetChanged()
    }
    class ArticleHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {


        var ivImage: ImageView? = itemView?.findViewById(R.id.image)
        var tvTitle: TextView? = itemView?.findViewById(R.id.title)
        var tvDescription: TextView? = itemView?.findViewById(R.id.description)
        var tvDate: TextView? = itemView?.findViewById(R.id.date)


        fun bindArticle(article: Article) {

            with(article) {

                tvTitle?.text = title
                tvDescription?.text = description
                tvDate?.text = publishedAt?.toDateWithFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", "MMM dd")
                ivImage?.loadFromUrl(image)

            }
        }

    }
}