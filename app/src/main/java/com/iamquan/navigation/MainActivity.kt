package com.iamquan.navigation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager
import com.iamquan.navigation.databinding.ActivityMainBinding
import com.iamquan.navigation.databinding.NavHeaderBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var bindingnav : NavHeaderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.tvOn.setOnClickListener {
           binding.drawerlayout.openDrawer(GravityCompat.START)
       }
        val headerview = binding.navView.getHeaderView(0)
        val button : Button = headerview.findViewById(R.id.btnTest)
        button.setOnClickListener {
            Toast.makeText(this,"kha nang la dc",Toast.LENGTH_LONG).show()
            binding.drawerlayout.closeDrawer(GravityCompat.START)
        }
        val list = arrayListOf("Quan","Tien","haha","hihhjfgjygjgh554654132i")
        val llTag :LinearLayout = headerview.findViewById(R.id.llTag)
        list.forEach {
            val textView  = TextView(this)
            var layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
            textView.layoutParams = layoutParams
            layoutParams.setMargins(0,0,10,0)
            textView.text = it
            textView.setBackgroundColor(Color.BLUE)
            llTag.addView(textView)
        }
        val adapter = TagAdapter(list,this)
        val rcTag :RecyclerView = headerview.findViewById(R.id.rcTag)
        rcTag.apply {
            layoutManager = FlexboxLayoutManager(this@MainActivity).apply {
                flexWrap = FlexWrap.WRAP
                flexDirection = FlexDirection.ROW
                rcTag.adapter = adapter
            }
        }

    }
}