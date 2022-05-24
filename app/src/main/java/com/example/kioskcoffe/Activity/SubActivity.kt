package com.example.kioskcoffe.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.kioskcoffe.R
import com.example.kioskcoffe.Fragment.SubCartFragment
import com.example.kioskcoffe.Fragment.SubReciptFragment

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sub_background) // 레이아웃을 지정해주는 명령어

        val fragment = SubCartFragment()
        supportFragmentManager.beginTransaction().replace(R.id.SubFragment, fragment).commit()
        inuitEvent()
    }

    fun inuitEvent() {
        val check_btn = findViewById<ImageButton>(R.id.button_check)
        check_btn.setOnClickListener {
            val fragment = SubReciptFragment()
            supportFragmentManager.beginTransaction().replace(R.id.SubFragment, fragment).commit()
        }
    }
}


