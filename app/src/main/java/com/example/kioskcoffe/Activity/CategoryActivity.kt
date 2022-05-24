package com.example.kioskcoffe.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.kioskcoffe.R

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // 부모의 onCreate : 화면에 엑티비티를 띄워달라. 생성자와 같은 역할을 한다고 이해해도 무방
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_page_order)
        initEvent()
    }

    private fun initEvent() {
        val coofe_btn = findViewById<Button>(R.id.coffe_btn)
        coofe_btn.setOnClickListener{
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("btn","coffe")
            startActivity(intent,)
        }

        val php_btn = findViewById<Button>(R.id.php_btn)
        php_btn.setOnClickListener{
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("btn","php")
            startActivity(intent,)
        }

        val r_btn = findViewById<Button>(R.id.r_btn)
        r_btn.setOnClickListener{
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("btn","r")
            startActivity(intent)
        }

        val java_btn = findViewById<Button>(R.id.java_btn)
        java_btn.setOnClickListener{
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("btn","java")
            startActivity(intent)
        }

        val cart_btn = findViewById<ImageButton>(R.id.main_button_cart)
        cart_btn.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }

}




