package com.apps.madnotdead.notiapp.ui.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.apps.madnotdead.notiapp.R
import com.apps.madnotdead.notiapp.data.model.Article
import com.apps.madnotdead.notiapp.data.remote.ArticleService
import com.apps.madnotdead.notiapp.data.remote.response.ArticleResponse
import com.apps.madnotdead.notiapp.ui.adapter.ArticleItemDecoration
import com.apps.madnotdead.notiapp.ui.adapter.ArticlesAdapter
import com.apps.madnotdead.notiapp.utils.longToast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , Callback<ArticleResponse> {

    private val articles: MutableList<Article> = ArrayList()

    private lateinit var articleAdapter : ArticlesAdapter

    private var source: String = "the-next-web"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initArticleList()
        getArticles()
    }

    private fun getArticles() {
        ArticleService.articleApi.getArticles(source).enqueue(this)
    }

    override fun onFailure(call: Call<ArticleResponse>?, t: Throwable?) {
        longToast(t!!.message.toString())
    }

    override fun onResponse(call: Call<ArticleResponse>?, response: Response<ArticleResponse>?) {

        if(response!!.isSuccessful) {
            setArticleAdapter(response!!.body()!!.articles)
        }else {
            longToast("Error al obtener articulos. Mensaje: ${response.message()}")
        }
    }

    fun initArticleList() {
        rvArticles.layoutManager = LinearLayoutManager(this)
        rvArticles.setHasFixedSize(true)
        val space = resources.getDimensionPixelOffset(R.dimen.mid_size)
        rvArticles.addItemDecoration(ArticleItemDecoration(space))
    }

    fun setArticleAdapter(articleList: List<Article>) {
        articleAdapter = ArticlesAdapter{ openUrl(it.url) }

        articles.addAll(articleList)
        articleAdapter.loadArticles(articles)
        rvArticles.adapter = articleAdapter
    }


    fun openUrl(url: String) {
        var i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

}
