package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gadsphasetwoproject.databinding.FragmentSkillIQBinding
import com.gadsphasetwoproject.networkCalls.ApiInterface
import com.gadsphasetwoproject.utils.CustomProgressDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okio.IOException
import timber.log.Timber

class SkillIQFragment : Fragment() {

    private lateinit var binding: FragmentSkillIQBinding
    private lateinit var progressDialog: CustomProgressDialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSkillIQBinding.inflate(inflater)
        progressDialog = CustomProgressDialog(requireActivity())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressDialog.showDialog()
        GlobalScope.launch {
            try {
                val apiInterface = ApiInterface.CreateUserClient.apiInterface
                val response = apiInterface.getLearnersIq()

                Timber.d("Passed API point")
                Timber.d(response.code().toString())
                if (response.isSuccessful || response.code() == 200) {
                    progressDialog.hideDialog()
                    Timber.d("Successful")

                }

            } catch (e: IOException) {
                progressDialog.hideDialog()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillIQFragment()
    }
}