package com.example.psychological_test.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.psychological_test.R
import kotlinx.android.synthetic.main.fragment_selection.*

class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btn_back.setOnClickListener(this)
        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.option1 -> {
                navigateWithIndex(1)
            }
            R.id.option2 -> {
                navigateWithIndex(2)
            }
            R.id.option3 -> {
                navigateWithIndex(3)
            }
            R.id.option4 -> {
                navigateWithIndex(4)
            }
            R.id.btn_back -> {
                navController.popBackStack()
            }
        }
    }

    fun navigateWithIndex(index: Int) { // 인수값을 bundle 에 넣고 최종화면으로 이동하는 메소드

        val bundle: Bundle = bundleOf("index" to index) // 인수값 Bundle에 넣기

        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)

    }

}