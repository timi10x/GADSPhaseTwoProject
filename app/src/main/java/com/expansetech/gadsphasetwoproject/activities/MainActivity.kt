package com.expansetech.gadsphasetwoproject.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.expansetech.adapter.MainActivityTablayoutAdapter
import com.expansetech.gadsphasetwoproject.R
import com.expansetech.gadsphasetwoproject.databinding.ActivityMainBinding
import com.expansetech.gadsphasetwoproject.fragments.HoursFragment
import com.expansetech.gadsphasetwoproject.fragments.SkillIQFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setup adapter for the ViewPager
        val adapter = MainActivityTablayoutAdapter(supportFragmentManager)
        adapter.addFragment(HoursFragment.newInstance(), "Learning Leaders")
        adapter.addFragment(SkillIQFragment.newInstance(), "Skill IQ Leaders")
        setSupportActionBar(findViewById(R.id.toolbar))
        with(binding){
            //connecting the viewPager to the adapter and layout
            leaderBoardViewPager.adapter = adapter
            tabLayout.setupWithViewPager(leaderBoardViewPager)
            actionBarSubmit.setOnClickListener {
                startActivity(Intent(this@MainActivity, SubmitProjectActivity::class.java))
            }
        }
    }
}