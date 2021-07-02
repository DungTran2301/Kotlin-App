package com.example.demoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MealAdapter(var clickListner: MealAdapter.OnMealItemClickListner): RecyclerView.Adapter<MealAdapter.ViewHolder>() {
    private var mealList: ArrayList<Meal> = ArrayList()

    fun setData(dishList: ArrayList<Meal>) {
        this.mealList = dishList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_meal_home_main, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MealAdapter.ViewHolder, position: Int) {
        holder.initialize(mealList[position], clickListner)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var mealImage: ImageView
        var mealName: TextView
        var mealNumberDish: TextView
        init {
            mealImage = itemView.findViewById(R.id.img_meal_home)
            mealName = itemView.findViewById(R.id.tv_meal_name)
            mealNumberDish = itemView.findViewById(R.id.tv_meal_dish_number)
        }

        fun initialize(item: Meal, action: OnMealItemClickListner) {
            mealImage.setImageResource(item.image)
            mealName.text = item.name
            mealNumberDish.text = item.dishNumber.toString() +" món."

            itemView.setOnClickListener{
                action.onItemMealClick(item, adapterPosition)
            }
        }
    }
    interface OnMealItemClickListner{
        fun onItemMealClick(item: Meal, position: Int)
    }

}