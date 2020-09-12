package com.gadsphasetwoproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gadsphasetwoproject.databinding.FragmentHoursBinding
import com.gadsphasetwoproject.model.User
import com.gadsphasetwoproject.networkCalls.ApiInterface
import com.gadsphasetwoproject.utils.CustomProgressDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException


class HoursFragment : Fragment() {
    private lateinit var binding: FragmentHoursBinding
    private var userList: ArrayList<User>? = null

    private lateinit var progressDialog: CustomProgressDialog


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHoursBinding.inflate(inflater)
        progressDialog = CustomProgressDialog(requireActivity())

        loadData()
        return binding.root
    }


    private fun loadData() {
        progressDialog.showDialog()
        GlobalScope.launch {
            try {
                val apiService: ApiInterface = ApiInterface.CreateUserClient.apiInterface
                val response = apiService.getLearnerHours()
                Timber.d("passed the API call")
                if (response.isSuccessful || response.code() == 200) {
                    Timber.d(response.code().toString())
                    progressDialog.hideDialog()
                    val user = User()
                    val name = response.body()?.name
                    user.name = name
                    val hours = response.body()?.hours
                    user.hours = hours
                    val country = response.body()?.country
                    user.country = country
                    val badgeUrl = response.body()?.badgeUrl
                    user.badgeUrl = badgeUrl
                    Timber.d("$name, $hours, $country, $badgeUrl")
                } else {
                    progressDialog.hideDialog()
                    Timber.d("this is the error")
                }

            } catch (e: IOException) {
                progressDialog.hideDialog()
                Timber.d("this is the catch error")
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            HoursFragment()
    }
}