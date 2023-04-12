package com.example.scoutoassignment

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataSet: ArrayList<Dataset>,private val click : OnClickListner) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.textview)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_item, viewGroup, false)

        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
//        if(position==0){
////            dataSet[position].isSelected = true
//            click.onClick(position)
//        }
        viewHolder.textView.text = dataSet[position].errorID
        if(dataSet[position].isSelected){
            viewHolder.textView.setBackgroundResource(R.drawable.selected_background)
            viewHolder.textView.setTextColor(Color.parseColor("#ffffff"))
        }else{
            viewHolder.textView.setBackgroundResource(R.drawable.not_selected_background)
            viewHolder.textView.setTextColor(Color.parseColor("#2E054E"))
        }
//        viewHolder.textView.isSelected = true

        viewHolder.textView.setOnClickListener{
            if(!dataSet[position].isSelected)
            click.onClick(position)
        }


    }
    override fun getItemCount() = dataSet.size



}
public interface OnClickListner{
    fun onClick(position: Int)
}