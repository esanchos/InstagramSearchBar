package com.earaujo.instagramtoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_scrolling.*

class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setup()
    }

    private fun setup() {
        imagesRecyclerView.addItemDecoration(SpaceDecoration(resources.getDimension(R.dimen.dividerSize).toInt()))
        imagesRecyclerView.adapter = ImagesAdapter(ImageList.imageList)
    }

}

