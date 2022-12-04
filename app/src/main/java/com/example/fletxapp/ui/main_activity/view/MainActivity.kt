package com.example.fletxapp.ui.main_activity.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fletxapp.databinding.ActivityMainBinding
import com.example.fletxapp.domain.Model
import com.example.fletxapp.ui.main_activity.view.adapter.DataAdapter
import com.example.fletxapp.ui.main_activity.view.adapter.DataViewHolder
import com.example.fletxapp.ui.main_activity.viewmodel.MainViewModel
import com.example.fletxapp.ui.map_activity.MapActivity

class MainActivity : AppCompatActivity(), DataViewHolder.ViewHolderListener {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    var modelList = mutableListOf<Model>()
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val dataAdapter = DataAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.onCreate()
        viewModel.responseModel.observe(this, Observer {

            modelList = it!!.toMutableList()
            if (modelList.isNotEmpty()){
                setAdapter(modelList)
            }

        })

        viewModel.isLoading.observe(this, Observer {
            binding.loading.isVisible = it
        })
    }

    private fun setAdapter(modelList: MutableList<Model>) {
        linearLayoutManager = LinearLayoutManager(this)
        binding.rcvData.layoutManager = linearLayoutManager

        binding.rcvData.adapter = dataAdapter
        binding.rcvData.setHasFixedSize(true);
        dataAdapter.setList(modelList)
    }

    private fun goMapActivity(position: Int) {
        val item = modelList[position]
        val intent = Intent(this, MapActivity::class.java)
        intent.putExtra("model", item)
        startActivity(intent)
    }

    override fun onClickItem(position: Int) {
        goMapActivity(position)
    }

}