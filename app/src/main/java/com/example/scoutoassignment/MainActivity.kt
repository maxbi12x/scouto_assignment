package com.example.scoutoassignment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var scrollView: ScrollView
    private lateinit var recyclerView : RecyclerView
    private lateinit var des : TextView
    private lateinit var cause : TextView
    private lateinit var adapter : CustomAdapter
    private var prev = -1;
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViews()
        val data = getData()
        if(data!=null&&data.size!=0){
            prev = 0;
            data[0].isSelected=true
            des.text = data[0].description
            cause.text = data[0].cause
        }
        setAdapter(data)
    }
    private fun findViews(){
        recyclerView  = findViewById(R.id.recycler)
        des = findViewById(R.id.description_text)
        cause = findViewById(R.id.cause_text)
        scrollView = findViewById(R.id.scroll)
    }
    private fun setAdapter(data : ArrayList<Dataset>){
        adapter = CustomAdapter(data, object : OnClickListner {
            override fun onClick(position: Int) {
                if(prev!=-1){
                    data[prev].isSelected = false
                    adapter.notifyItemChanged(prev)
                }
                data[position].isSelected = true
                prev = position
                des.text = data[position].description
                cause.text = data[position].cause
                adapter.notifyItemChanged(position)

            }
        });
        val margin = resources.getDimensionPixelSize(R.dimen.hor_dim_item) // Replace with your margin value
        val decoration = FirstLastItemMarginDecoration(margin)
        recyclerView.addItemDecoration(decoration)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }
    private fun getData() : ArrayList<Dataset>{
        val data = ArrayList<Dataset>()
        data.add(Dataset("P00042",
            "1 Lorem ipsum dolor sit amet, Aliquam bibendum eleifend pharetra quam sed amet ultrices vulputate. consectetur adipiscing elit. ",
            "1 Aliquam bibendum eleifend\n" +
                    "pharetra quam ",false))
        data.add(Dataset("P00043",
            "2 Lorem ipsum dolor sit amet, Aliquam bibendum eleifend pharetra quam sed amet ultrices vulputate. consectetur adipiscing elit. ",
            "2 Aliquam bibendum eleifend\n" +
                    "pharetra quam ",false))
        data.add(Dataset("P00044",
            "3 Lorem ipsum dolor sit amet, Aliquam bibendum eleifend pharetra quam sed amet ultrices vulputate. consectetur adipiscing elit. ",
            "3 Aliquam bibendum eleifend\n" +
                    "pharetra quam ",false))
        data.add(Dataset("P00045",
            "4 Lorem ipsum dolor sit amet, Aliquam bibendum eleifend pharetra quam sed amet ultrices vulputate. consectetur adipiscing elit. ",
            "4 Aliquam bibendum eleifend\n" +
                    "pharetra quam ",false))
        data.add(Dataset("P00046",
            "5 Lorem ipsum dolor sit amet, Aliquam bibendum eleifend pharetra quam sed amet ultrices vulputate. consectetur adipiscing elit. ",
            "5 Aliquam bibendum eleifend\n" +
                    "pharetra quam ",false))
        data.add(Dataset("P00047",
            "6 Lorem ipsum dolor sit amet, Aliquam bibendum eleifend pharetra quam sed amet ultrices vulputate. consectetur adipiscing elit. ",
            "6 Aliquam bibendum eleifend\n" +
                    "pharetra quam ",false))
        data.add(Dataset("P00048",
            "6 Lorem ipsum dolor sit amet, Aliquam bibendum eleifend pharetra quam sed amet ultrices vulputate. consectetur adipiscing elit. ",
            "6 Aliquam bibendum eleifend\n" +
                    "pharetra quam ",false))
        return data
    }

}