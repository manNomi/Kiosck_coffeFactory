package com.example.kioskcoffe.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kioskcoffe.R


class SubReciptFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.sub_page_recipt, container, false) // 컨테이너는 그냥 넣어도 됨.

        return view
    }
}