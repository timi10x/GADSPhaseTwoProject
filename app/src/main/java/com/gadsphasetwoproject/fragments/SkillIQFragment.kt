package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gadsphasetwoproject.adapter.SkillIQAdapter
import com.gadsphasetwoproject.databinding.FragmentSkillIQBinding
import com.gadsphasetwoproject.model.viewModel.SkillIqViewModel
import com.gadsphasetwoproject.utils.CustomProgressDialog
import com.gadsphasetwoproject.utils.Resource
import com.gadsphasetwoproject.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint
import es.dmoral.toasty.Toasty
import javax.inject.Inject

@AndroidEntryPoint
class SkillIQFragment : Fragment() {

    private var binding: FragmentSkillIQBinding by autoCleared()
    private val viewModel: SkillIqViewModel by viewModels()

    @Inject
    lateinit var progressDialog: CustomProgressDialog
    private lateinit var recyclerAdapter: SkillIQAdapter

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
        setUpRecyclerView()
        setupObservers()
    }

    private fun setUpRecyclerView() {
        recyclerAdapter = SkillIQAdapter(requireContext())
        binding.skillRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.skillRecyclerView.adapter = recyclerAdapter
    }

    private fun setupObservers() {
        viewModel.skillIq.observe(viewLifecycleOwner, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    progressDialog.hideDialog()
                    if (!it.data.isNullOrEmpty()) {
                        binding.skillEmptyStateText.visibility = View.INVISIBLE
                        binding.skillEmptyStateImg.visibility = View.INVISIBLE
                        binding.skillRecyclerView.visibility = View.VISIBLE

                        recyclerAdapter.setUserIqIqListItems(ArrayList(it.data))
                    }
                }
                Resource.Status.ERROR -> {
                    progressDialog.hideDialog()
                    Toasty.error(requireContext(), "error loading", Toasty.LENGTH_SHORT, true)
                        .show()
                }

                Resource.Status.LOADING ->
                    progressDialog.showDialog()
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillIQFragment()
    }
}