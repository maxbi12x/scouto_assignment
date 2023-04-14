package com.example.scoutoassignment

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FirstLastItemMarginDecoration(private val margin: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        // Get the position of the current item
        val position = parent.getChildAdapterPosition(view)

        // If it's the first item, remove the left margin
        if (position != 0) {
            outRect.left = margin
        }

        // If it's not the last item, add the right margin
        if (position != parent.adapter?.itemCount?.minus(1)) {
            outRect.right = margin
        }
    }
}