package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gadsphasetwoproject.adapter.RecyclerAdapter
import com.gadsphasetwoproject.databinding.FragmentSkillIQBinding
import com.gadsphasetwoproject.utils.CustomProgressDialog

class SkillIQFragment : Fragment() {

    private lateinit var binding: FragmentSkillIQBinding
    private lateinit var progressDialog: CustomProgressDialog
    private lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillIQBinding.inflate(inflater)
        progressDialog = CustomProgressDialog(requireActivity())
        with(binding) {
            /*recyclerAdapter = RecyclerAdapter(requireContext())
            hoursRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            hoursRecyclerView.adapter = recyclerAdapter*/
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillIQFragment()
    }
}