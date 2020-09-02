package com.expansetech.gadsphasetwoproject.fragments
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.expansetech.gadsphasetwoproject.R
import com.expansetech.gadsphasetwoproject.databinding.FragmentSkillIQBinding

class SkillIQFragment : Fragment() {

    private lateinit var binding: FragmentSkillIQBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillIQBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillIQFragment()
    }
}