package com.example.demoapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.ViewHolder>(){
    private var titles = arrayOf("Burger", "Chicken", "Alcoholic", "Hotdog", "Egg coffee", "Pancake", "Strawberry", "Sweet Pea", "Burger", "Chicken", "Hotdog", "Pancake")
    private var prices = arrayOf(100, 150, 80, 50, 60, 75, 100, 95, 100, 150, 50, 75)
    private var images = arrayOf(R.drawable.ic_burger, R.drawable.ic_chicken, R.drawable.ic_alcoholic, R.drawable.ic_hotdog, R.drawable.ic_eggcoffee, R.drawable.ic_pancake, R.drawable.ic_strowberry,  R.drawable.ic_sweetpea, R.drawable.ic_burger, R.drawable.ic_chicken, R.drawable.ic_hotdog, R.drawable.ic_pancake)
    private var dishList: ArrayList<Dish> = ArrayList()

    fun setData(dishList: ArrayList<Dish>) {
        this.dishList = dishList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = dishList[position].name
        holder.itemImage.setImageResource(dishList[position].image)
        holder.itemPrice.text = String.format("%,d", dishList[position].price * 1000) + " Đ"
        holder.itemDetail.text = dishList[position].detail
    }

    override fun getItemCount(): Int {
        if (dishList.size == 0) return 0
        return dishList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemPrice: TextView
        init {
            itemImage = itemView.findViewById(R.id.food_image)
            itemTitle = itemView.findViewById(R.id.tv_title)
            itemDetail = itemView.findViewById(R.id.tv_detail)
            itemPrice = itemView.findViewById(R.id.tv_price)
        }
    }
}