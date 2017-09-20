package com.lfo.dragdemo

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.adapter_item.view.*
import java.util.*

/**
 * Created by home on 2017/9/20.
 */
class MAdapter(  var mlist :ArrayList<Entity>):RecyclerView.Adapter<MAdapter.ViewHolder>(){


    val itemTouchHelper = ItemTouchHelper(SwagHelper(this))
    var mclickListener: ClickListener?=null
    fun attach(list : RecyclerView){
        itemTouchHelper.attachToRecyclerView(list)
    }
    fun swag(fromPosition:Int,toPosition:Int){
        Collections.swap(mlist,fromPosition,toPosition)
        notifyItemMoved(fromPosition, toPosition)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var entity=mlist[position]

        holder.bind(itemTouchHelper,entity,position,mclickListener)

    }

    override fun getItemCount()=mlist.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.adapter_item,parent,false)
        return ViewHolder(view)
    }

    class ViewHolder(item : View):RecyclerView.ViewHolder(item) {
        fun bind(helper:ItemTouchHelper ,entity: Entity, position:Int,mclickListener: ClickListener?) {
            itemView.setOnClickListener({
                mclickListener?.click(entity,position)
            })
            itemView.but1.setOnTouchListener(object:View.OnTouchListener{
                override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                    helper.startDrag(this@ViewHolder)
                  return true
                }
            })
            itemView.tv1.text=entity.text
        }

    }
    data class Entity(var id:Int,var text:String)


}
interface ClickListener{
    fun click(entity : MAdapter.Entity, positon:Int)
}
