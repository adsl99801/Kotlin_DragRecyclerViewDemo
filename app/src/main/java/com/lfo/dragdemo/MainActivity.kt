package com.lfo.dragdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val context = applicationContext

        var mlist = ArrayList<MAdapter.Entity>()
        (0..10).mapTo(mlist) { MAdapter.Entity(it, "t" + it) }
        var madapter = MAdapter(mlist).apply { attach(listview1) }
        butShow.setOnClickListener {
            Log.i("show:", madapter.mlist.toString())
        }
        listview1.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = madapter
        }
    }

}