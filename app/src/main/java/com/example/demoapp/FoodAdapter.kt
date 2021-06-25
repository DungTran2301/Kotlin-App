package com.example.demoapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(var clickListner: OnDishItemClickListner): RecyclerView.Adapter<FoodAdapter.ViewHolder>(){

   private var dishList: ArrayList<Dish> = ArrayList()

    fun setData(dishList: ArrayList<Dish>) {
        this.dishList = dishList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
//        holder.itemTitle.text = dishList[position].name
//        holder.itemImage.setImageResource(dishList[position].image)
//        holder.itemPrice.text = String.format("%,d", dishList[position].price * 1000) + " Đ"
//        holder.itemDetail.text = dishList[position].detail
        holder.initialize(dishList.get(position), clickListner)
    }

    override fun getItemCount(): Int {
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

        fun initialize(item: Dish, action: OnDishItemClickListner) {
            itemImage.setImageResource(item.image)
            itemTitle.text = item.name
            itemPrice.text = String.format("%,d", item.price * 1000) + " Đ"
            itemDetail.text = item.detail

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
            }
        }
    }
    interface OnDishItemClickListner{
        fun onItemClick(item: Dish, position: Int)
    }
}