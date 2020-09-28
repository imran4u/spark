package com.imran.spark.view.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


/**
 * Created by imran on 2020-09-28.
 */

@BindingAdapter("app:setView")
fun setView(view: AppCompatTextView, viewCount: Int?) {
    view.text = if (viewCount == null || viewCount == 0) {
        "View NA"
    } else if (viewCount == 1) {
        "$viewCount View"
    } else {
        "$viewCount Views"
    }
}

@BindingAdapter("app:setLike")
fun setLike(view: AppCompatTextView, likeCount: Int?) {
    view.text = if (likeCount == null || likeCount == 0) {
        "Like NA"
    } else if (likeCount == 1) {
        "$likeCount Like"
    } else {
        "$likeCount Likes"
    }
}

@BindingAdapter("app:Drawable")
fun setDrawableUrl(image: AppCompatImageView, url: Any?) {
    if (url != null) {
        Glide.with(image.context).load(url).into(image)
    }
}

@BindingAdapter("app:CircularDrawable")
fun setCircularDrawableUrl(image: AppCompatImageView, url: Any?) {
    if (url != null) {
        Glide.with(image.context).load(url).circleCrop().into(image)
    }
}
