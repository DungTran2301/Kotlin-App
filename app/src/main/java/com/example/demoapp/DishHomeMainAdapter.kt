package com.example.demoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DishHomeMainAdapter(var clickListner: HomeMainFragment): RecyclerView.Adapter<DishHomeMainAdapter.ViewHolder>() {
    private var dishHomeMainList: ArrayList<DishHomeMain> = ArrayList()

    fun setData(dishList: ArrayList<DishHomeMain>) {
        this.dishHomeMainList = dishList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishHomeMainAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_dish_home_main, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: DishHomeMainAdapter.ViewHolder, position: Int) {
        holder.dishName.text = dishHomeMainList[position].name
        holder.dishImage.setImageResource(dishHomeMainList[position].image)
    }

    override fun getItemCount(): Int {
        return dishHomeMainList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var dishImage: ImageView
        var dishName: TextView
        init {
            dishImage = itemView.findViewById(R.id.img_dish_home_main)
            dishName = itemView.findViewById(R.id.tv_dish_name_home_main)
        }

        fun initialize(item: DishHomeMain, action: OnDishHomeMainItemClickListner) {
            dishImage.setImageResource(item.image)
            dishName.text = item.name

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
            }
        }
    }
    interface OnDishHomeMainItemClickListner{
        fun onItemClick(item: DishHomeMain, position: Int)
    }
}