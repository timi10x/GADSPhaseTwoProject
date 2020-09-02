package com.expansetech.gadsphasetwoproject.activities

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.expansetech.gadsphasetwoproject.R
import com.expansetech.gadsphasetwoproject.databinding.ActivitySubmitProjectBinding

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