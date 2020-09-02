package com.gadsphasetwoproject.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gadsphasetwoproject.R
import com.gadsphasetwoproject.databinding.ActivitySubmitProjectBinding

class SubmitProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubmitProjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_submit_project)
        setSupportActionBar(findViewById(R.id.submit_toolbar))
        with(binding){
            backButton.setOnClickListener {
                onBackPressed()
            }
        }
    }
}