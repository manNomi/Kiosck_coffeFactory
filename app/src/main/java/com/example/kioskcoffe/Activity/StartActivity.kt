package com.example.kioskcoffe.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kioskcoffe.R
import kotlin.concurrent.timer

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.other_page_start) // 레이아웃을 지정해주는 명령어
        var second : Int = 0
        timer(period = 1000 , initialDelay=1000)
        {
            second++
            if(second==5)
            {
                cancel()
            }
        }
        val intent = Intent(this, CategoryActivity::class.java)
        startActivity(intent)
        }
    }
//splash 로 구현