package com.example.psychological_test.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.psychological_test.R
import kotlinx.android.synthetic.main.fragment_result.*

class ResultFragment : Fragment() {

    var option = -1 //넘어온 데이터를 받을 객체

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        option = arguments?.getInt("index") ?: -1 //널값시, -1로 초기화
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        setResult(option)

        btn_origin.setOnClickListener {
            navController.navigate(R.id.action_resultFragment_to_mainFragment)
        }
    }

    private fun setResult(option: Int) {

        when (option) {
            1 -> {
                tv_main.text = "포기가 빠른사람"
                tv_sub.text = "냉정한 스타일."
            }
            2 -> {
                tv_main.text = "포기를 모르는 사람"
                tv_sub.text = "집착이 강한 스타일."
            }
            3 -> {
                tv_main.text = "수단과 방법을 \n가리지 않는 사람"
                tv_sub.text = " 위험한 스타일."
            }
            4 -> {
                tv_main.text = "성숙한 사람"
                tv_sub.text = "담담한 스타일."
            }
        }

    }


}