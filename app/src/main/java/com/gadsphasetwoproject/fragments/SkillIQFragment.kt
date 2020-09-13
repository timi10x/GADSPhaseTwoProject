package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadsphasetwoproject.adapter.RecyclerAdapter
import com.gadsphasetwoproject.databinding.FragmentSkillIQBinding
import com.gadsphasetwoproject.model.User
import com.gadsphasetwoproject.networkCalls.ApiInterface
import com.gadsphasetwoproject.utils.CustomProgressDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
            recyclerAdapter = RecyclerAdapter(requireContext())
            skillRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            skillRecyclerView.adapter = recyclerAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    private fun loadData() {
        progressDialog.showDialog()
        val apiInterface = ApiInterface.create().getLearnerHours()
        apiInterface.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                if (response!!.isSuccessful) {
                    progressDialog.hideDialog()
                    if (response.body() != null) {
                        binding.skillEmptyStateImg.visibility = View.INVISIBLE
                        binding.skillEmptyStateText.visibility = View.INVISIBLE
                        binding.skillRecyclerView.visibility = View.VISIBLE
                        recyclerAdapter.setUserListItems(response.body()!!)
                        binding.skillRecyclerView.adapter!!.notifyDataSetChanged()
                    }
                }


            }

            override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                progressDialog.hideDialog()
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillIQFragment()
    }
}