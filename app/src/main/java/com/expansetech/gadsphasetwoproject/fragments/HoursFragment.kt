package com.expansetech.gadsphasetwoproject.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.expansetech.gadsphasetwoproject.R
import com.expansetech.gadsphasetwoproject.databinding.FragmentHoursBinding

class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHoursBinding.inflate(inflater)
        with(binding){

        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HoursFragment()
    }
}