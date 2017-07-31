package com.apps.madnotdead.notiapp.ui.adapter

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by madnotdead on 7/30/17.
 */
class ArticleItemDecoration(val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {

        when(parent?.getChildAdapterPosition(view)){
            0 -> setUpFirst(outRect,space)
            else -> setUpRectTopAndBottom(outRect,space)
        }

    }

    fun setUpFirst(outRect: Rect?, space: Int) {

        outRect?.bottom = space
        outRect?.top = space
    }

    fun setUpRectTopAndBottom(outRect: Rect?, space: Int) {

        outRect?.bottom = space
    }
}