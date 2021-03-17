package com.hari.sample.utils.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.hari.sample.R
import com.squareup.picasso.Picasso


@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String?) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.placeholder)
        .error(R.drawable.placeholder)
        .into(this)
}