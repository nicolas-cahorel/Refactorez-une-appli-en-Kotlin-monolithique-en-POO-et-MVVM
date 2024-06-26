package com.openclassrooms.notes.ui.recyclerview

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * A decoration that adds spacing between items in a RecyclerView.
 * @param spaceSize The size of the spacing in pixels.
 * @param spanCount The number of columns in the RecyclerView.
 */
class NoteItemDecoration(
    private val spaceSize: Int,
    private val spanCount: Int
) : ItemDecoration() {

    /**
     * Adds spacing around the items in the RecyclerView.
     * @param outRect The Rect to receive the output bounds.
     * @param view The child view to decorate.
     * @param parent The RecyclerView this ItemDecoration is decorating.
     * @param state The current state of RecyclerView.
     */
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) < spanCount) {
                top = spaceSize
            }

            if (parent.getChildAdapterPosition(view) % spanCount == 0) {
                left = spaceSize
            }

            right = spaceSize
            bottom = spaceSize
        }
    }
}