package com.clean_arch_mvvm_coroutines.ui

import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.clean_arch_mvvm_coroutines.R
import com.clean_arch_mvvm_coroutines.databinding.ActivityMainBinding
import com.clean_arch_mvvm_coroutines.utils.isNetworkAvailable
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var activityPostsBinding: ActivityMainBinding
    private var mAdapter: PostsAdapter? = PostsAdapter()
    private val postViewModel: PostsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityPostsBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityPostsBinding.root)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = PostsAdapter()
        activityPostsBinding.postsRV.apply {
            layoutManager = linearLayoutManager
            adapter = mAdapter
        }

        if (isNetworkAvailable()) {
            postViewModel.getPosts()
        } else {
            Toast.makeText(
                this,
                getString(R.string.no_internet_connection),
                LENGTH_SHORT
            ).show()
        }

        with(postViewModel) {

            postViewModel.postsData.observe(this@MainActivity, {
                activityPostsBinding.postsProgressBar.hide()
                mAdapter!!.setData(it)
            })

            messageData.observe(this@MainActivity, {
                Toast.makeText(this@MainActivity, it, LENGTH_LONG).show()
            })

            showProgressbar.observe(this@MainActivity, {
                activityPostsBinding.postsProgressBar.show()
            })
        }
    }


    override fun onDestroy() {
        mAdapter = null
        super.onDestroy()
    }

    companion object {
        private val TAG = MainActivity::class.java.name
    }
}