package com.apps.madnotdead.notiapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

/**
 * Created by madnotdead on 7/29/17.
 */

fun ImageView.loadFromUrl(url: String) {

    Glide.with(ctx).load(url).into(this)
}