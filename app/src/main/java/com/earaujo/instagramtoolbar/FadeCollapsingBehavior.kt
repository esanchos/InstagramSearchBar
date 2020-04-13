package com.earaujo.instagramtoolbar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout

internal class FadeCollapsingBehavior : ViewOffsetBehavior<View?> {

    constructor() {}
    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
    }

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: View,
        dependency: View
    ): Boolean {
        if (dependency is AppBarLayout) {
            topAndBottomOffset = dependency.top //bottom - child.height - systemWindowInsetTop - 20
            val alpha: Float =
                (-dependency.top).toFloat() / dependency.totalScrollRange
            child.alpha = 1f - alpha
        }
        return true
    }

}
