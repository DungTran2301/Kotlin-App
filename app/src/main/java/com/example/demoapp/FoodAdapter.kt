package com.example.demoapp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val dishDataList: ArrayList<Dish>, var clickListner: OnDishItemClickListner): RecyclerView.Adapter<FoodAdapter.ViewHolder>(){

    val initDishDataList = ArrayList<Dish>().apply {
        dishDataList.let { addAll(it) }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: FoodAdapter.ViewHolder, position: Int) {
        holder.initialize(dishDataList[position], clickListner)
    }


    override fun getItemCount(): Int {
        return dishDataList.size
    }

    fun getFilter(): Filter {
        return dataFilter
    }
    private val dataFilter = object: Filter(){
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filterList = mutableListOf<Dish>()
            if (constraint == null || constraint.isEmpty()){
                initDishDataList.let {
                    filterList.addAll(it)
                }
            }
            else {
                val query = constraint.toString().trim().toLowerCase()
                initDishDataList.forEach {
                    if (it.name.toLowerCase().contains(query) ){
                        filterList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filterList
            return results

        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is List<*>){
                dishDataList.clear()
                dishDataList.addAll(results.values as ArrayList<Dish>)
                notifyDataSetChanged()
            }
        }
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPrice: TextView
        init {
            itemImage = itemView.findViewById(R.id.food_image)
            itemTitle = itemView.findViewById(R.id.tv_title)
            itemPrice = itemView.findViewById(R.id.tv_price)
        }

        fun initialize(item: Dish, action: OnDishItemClickListner) {
            itemImage.setImageResource(item.image)
            itemTitle.text = item.name
            itemPrice.text = String.format("%,d", item.price * 1000) + " Đ"

            itemView.setOnClickListener{
                action.onItemClick(item, adapterPosition)
            }
        }
    }
    interface OnDishItemClickListner{
        fun onItemClick(item: Dish, position: Int)
    }
}