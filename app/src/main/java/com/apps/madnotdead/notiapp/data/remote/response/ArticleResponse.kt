package com.apps.madnotdead.notiapp.data.remote.response

import com.apps.madnotdead.notiapp.data.model.Article
import com.google.gson.annotations.SerializedName

/**
 * Created by madnotdead on 7/29/17.
 */
class ArticleResponse( @SerializedName("source") val source: String, @SerializedName("articles") val articles: List<Article>)