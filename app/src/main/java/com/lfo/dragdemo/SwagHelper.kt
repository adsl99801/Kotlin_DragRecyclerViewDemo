package com.lfo.dragdemo

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

/**
 * Created by home on 2017/9/20.
 */
class SwagHelper(var adapter:MAdapter) : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP  or ItemTouchHelper.DOWN,0){
    override fun onMove(recyclerView: RecyclerView, from: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
        adapter.swag(from.adapterPosition,target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
    }

}