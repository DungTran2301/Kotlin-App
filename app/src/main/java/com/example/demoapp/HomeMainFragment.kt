package com.example.demoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeMainFragment : Fragment(), MealAdapter.OnMealItemClickListner {
    private var mealList: ArrayList<Meal> = ArrayList()
    private var dishList: ArrayList<DishHomeMain> = ArrayList()
    private var layoutMealManager: RecyclerView.LayoutManager? = null
    private var layoutDishManager: RecyclerView.LayoutManager? = null
    lateinit var recyclerViewMeal: RecyclerView
    lateinit var recyclerViewDish: RecyclerView

    lateinit var mealAdapter: MealAdapter
    lateinit var dishHomeMainAdapter: DishHomeMainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home_main, container, false)
        layoutMealManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        layoutDishManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        addData()

        recyclerViewMeal = view.findViewById(R.id.rcv_meal_in_main_home)
        recyclerViewMeal.layoutManager = layoutMealManager

        recyclerViewDish = view.findViewById(R.id.rcv_dish_in_main_home)
        recyclerViewDish.layoutManager = layoutDishManager

        mealAdapter = MealAdapter(this)
        mealAdapter.setData(mealList)
        recyclerViewMeal.adapter = mealAdapter

        dishHomeMainAdapter = DishHomeMainAdapter(this)
        dishHomeMainAdapter.setData(dishList)
        recyclerViewDish.adapter = dishHomeMainAdapter

        return view
    }
    fun addData() {
        mealList.add(Meal("Bữa trưa", 4, R.drawable.meal1, "No detail"))
        mealList.add(Meal("Bữa tối", 5, R.drawable.meal3, "No detail"))
        mealList.add(Meal("Bữa trưa", 4, R.drawable.meal4, "No detail"))
        mealList.add(Meal("Bữa chiều", 4, R.drawable.meal1, "No detail"))

        dishList.add(DishHomeMain("Bún đậu", R.drawable.dishhome1, ""))
        dishList.add(DishHomeMain("Bánh giò", R.drawable.dishhome2, ""))
        dishList.add(DishHomeMain("Cốm", R.drawable.dishhome3, ""))

    }
    override fun onItemClick(item: Meal, position: Int) {
        TODO("Not yet implemented")
    }
}