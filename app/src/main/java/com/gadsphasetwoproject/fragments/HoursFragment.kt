package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadsphasetwoproject.adapter.RecyclerAdapter
import com.gadsphasetwoproject.databinding.FragmentHoursBinding
import com.gadsphasetwoproject.model.viewModel.LearnerHoursViewModel

import com.gadsphasetwoproject.utils.CustomProgressDialog
import com.gadsphasetwoproject.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

import javax.inject.Inject

@AndroidEntryPoint
class HoursFragment : Fragment() {
    private var binding: FragmentHoursBinding by autoCleared()
    private val viewModel: LearnerHoursViewModel by viewModels()

    @Inject
    lateinit var progressDialog: CustomProgressDialog
    private lateinit var recyclerAdapter: RecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHoursBinding.inflate(inflater)
        progressDialog = CustomProgressDialog(requireActivity())

        with(binding) {
            recyclerAdapter = RecyclerAdapter(requireContext())
            hoursRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            hoursRecyclerView.adapter = recyclerAdapter
        }

        return binding.root
    }

    /*private fun loadData() {
        progressDialog.showDialog()
        val apiInterface = ApiInterface.create().getLearnerHours()
        apiInterface.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                if (response!!.isSuccessful) {
                    progressDialog.hideDialog()
                    if (response.body() != null) {
                        binding.hoursEmptyStateImg.visibility = View.INVISIBLE
                        binding.hoursEmptyStateText.visibility = View.INVISIBLE
                        binding.hoursRecyclerView.visibility = View.VISIBLE
                        recyclerAdapter.setUserListItems(response.body()!!)
                        binding.hoursRecyclerView.adapter!!.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                progressDialog.hideDialog()
            }
        })
    }*/


    companion object {

        @JvmStatic
        fun newInstance() =
            HoursFragment()
    }
}