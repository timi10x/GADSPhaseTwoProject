package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadsphasetwoproject.adapter.RecyclerViewAdapter
import com.gadsphasetwoproject.databinding.FragmentHoursBinding
import com.gadsphasetwoproject.model.UserModel


class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private val userList: List<UserModel>? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHoursBinding.inflate(inflater)
        with(binding) {

            val layoutManager = LinearLayoutManager(requireContext())
            hoursRecyclerView.layoutManager = layoutManager
            val recyclerAdapter =
                RecyclerViewAdapter(requireContext(), userList!!)
            hoursRecyclerView.adapter = recyclerAdapter

        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HoursFragment()
    }
}