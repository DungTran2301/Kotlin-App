package com.example.demoapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeMainFragment : Fragment(), MealAdapter.OnMealItemClickListner, DishHomeMainAdapter.OnDishHomeMainItemClickListner {
    private var mealList: ArrayList<Meal> = ArrayList()
    private var dishList: ArrayList<DishHomeMain> = ArrayList()
    private var layoutMealManager: RecyclerView.LayoutManager? = null
    private var layoutDishManager: RecyclerView.LayoutManager? = null
    lateinit var recyclerViewMeal: RecyclerView
    lateinit var recyclerViewDish: RecyclerView
    lateinit var tvViewAllMeal: TextView
    lateinit var tvViewAllDish: TextView
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
        setUpTextView(view)
        setUpRecyclerView(view)

        mealAdapter = MealAdapter(this)
        mealAdapter.setData(mealList)
        recyclerViewMeal.adapter = mealAdapter

        dishHomeMainAdapter = DishHomeMainAdapter(this)
        dishHomeMainAdapter.setData(dishList)
        recyclerViewDish.adapter = dishHomeMainAdapter

        tvViewAllMeal.setOnClickListener {
            val homeMealFragment = HomeMealFragment()
            makeCurrentFragment(homeMealFragment)
        }

        tvViewAllDish.setOnClickListener {
            val homeDishFragment = HomeDishFragment()
            makeCurrentFragment(homeDishFragment)
        }

        return view
    }
    fun setUpTextView(view: View) {
        tvViewAllMeal = view.findViewById(R.id.tv_view_all_meal)
        tvViewAllDish = view.findViewById(R.id.tv_view_all_dish)
    }
    fun setUpRecyclerView(view: View) {
        recyclerViewMeal = view.findViewById(R.id.rcv_meal_in_main_home)
        recyclerViewMeal.layoutManager = layoutMealManager

        recyclerViewDish = view.findViewById(R.id.rcv_dish_in_main_home)
        recyclerViewDish.layoutManager = layoutDishManager
    }
    fun addData() {
        mealList.add(Meal("Bữa trưa", 4, R.drawable.meal1, resources.getString(R.string.bua_mot)))
        mealList.add(Meal("Bữa tối", 5, R.drawable.meal3, resources.getString(R.string.bua_ba)))
        mealList.add(Meal("Bữa trưa", 4, R.drawable.meal4, resources.getString(R.string.bua_bon)))
        mealList.add(Meal("Bữa chiều", 4, R.drawable.meal1, resources.getString(R.string.bua_mot)))

        dishList.add(DishHomeMain("Bún đậu mắm tôm", R.drawable.dishhome1, resources.getString(R.string.bun_dau)))
        dishList.add(DishHomeMain("Bánh giò", R.drawable.dishhome2, resources.getString(R.string.banh_do)))
        dishList.add(DishHomeMain("Cốm", R.drawable.dishhome3, resources.getString(R.string.com)))

    }
    override fun onItemMealClick(item: Meal, position: Int) {
        var intent = Intent(activity, RecipeActivity::class.java)
        intent.putExtra("TITLE", "Bữa ăn")
        intent.putExtra("NAME", item.name)
        intent.putExtra("DETAIL", item.detail)
        intent.putExtra("IMAGE", item.image)
        startActivity(intent)
    }
    override fun onItemDishClick(item: DishHomeMain, position: Int) {
        var intent = Intent(activity, RecipeActivity::class.java)
        intent.putExtra("TITLE", "Món ăn")
        intent.putExtra("NAME", item.name)
        intent.putExtra("DETAIL", item.detail)
        intent.putExtra("IMAGE", item.image)
        startActivity(intent)
    }
    private fun makeCurrentFragment(fragment: Fragment) =
        activity?.supportFragmentManager?.beginTransaction()?.apply {
            replace(R.id.nav_host_home_fragment, fragment)
            commit()
        }
}