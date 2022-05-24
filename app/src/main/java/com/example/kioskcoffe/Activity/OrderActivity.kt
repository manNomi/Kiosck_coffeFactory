package com.example.kioskcoffe.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.kioskcoffe.*
import com.example.kioskcoffe.Fragment.OrderCoffeeFragment
import com.example.kioskcoffe.Fragment.OrderJavaFragment
import com.example.kioskcoffe.Fragment.OrderPhpFragment
import com.example.kioskcoffe.Fragment.OrderRFragment

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_background) // 레이아웃을 지정해주는 명령어

        if (intent .getStringExtra("btn")=="coffe") {
            val fragment = OrderCoffeeFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit()
        }
        else if (intent .getStringExtra("btn")=="php") {
            val fragment = OrderPhpFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit()
        }
        else if (intent .getStringExtra("btn")=="r") {
            val fragment = OrderRFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit()
        }
        else if (intent .getStringExtra("btn")=="java") {
            val fragment = OrderJavaFragment()
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, fragment).commit()
        }

        initEvent()

    }

    private fun initEvent() {

        val cart_btn = findViewById<ImageButton>(R.id.order_button_cart)
        cart_btn.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
}

