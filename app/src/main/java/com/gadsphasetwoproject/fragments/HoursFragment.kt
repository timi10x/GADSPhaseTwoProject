package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadsphasetwoproject.adapter.RecyclerAdapter
import com.gadsphasetwoproject.databinding.FragmentHoursBinding
import com.gadsphasetwoproject.model.viewModel.LearnerHoursViewModel
import com.gadsphasetwoproject.utils.CustomProgressDialog
import com.gadsphasetwoproject.utils.Resource
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        recyclerAdapter = RecyclerAdapter(requireContext())
        binding.hoursRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.hoursRecyclerView.adapter = recyclerAdapter
    }

    private fun setupObservers() {
        viewModel.learnerHours.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    progressDialog.hideDialog()
                    if (!it.data.isNullOrEmpty()) {
                        binding.hoursEmptyStateImg.visibility = View.INVISIBLE
                        binding.hoursEmptyStateText.visibility = View.INVISIBLE
                        binding.hoursRecyclerView.visibility = View.VISIBLE
                        recyclerAdapter.setUserListItems(ArrayList(it.data))
                    }

                }
                Resource.Status.ERROR -> {
                    progressDialog.hideDialog()
                    /*Toasty.error(requireContext(), "error loading", Toasty.LENGTH_SHORT, true)
                            .show()*/
                }
                Resource.Status.LOADING ->
                    progressDialog.showDialog()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HoursFragment()
    }
}