package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import java.sql.DatabaseMetaData

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val recipeNavigation = findViewById<androidx.appcompat.widget.Toolbar>(R.id.recipe_toolbar)
        val itemImage: ImageView = findViewById(R.id.img_recipe_image)
        val itemTitle: TextView = findViewById(R.id.tv_recipe_title)
        val itemDetail: TextView = findViewById(R.id.tv_recipe_detail)
        val itemPrice: TextView = findViewById(R.id.tv_recipe_price)
        itemTitle.text = intent.getStringExtra("TITLE")
        itemDetail.text = intent.getStringExtra("DETAIL")
        itemPrice.text = intent.getIntExtra("PRICE", 1).toString()
        itemImage.setImageResource(intent.getIntExtra("IMAGE", 1))

        recipeNavigation.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}


