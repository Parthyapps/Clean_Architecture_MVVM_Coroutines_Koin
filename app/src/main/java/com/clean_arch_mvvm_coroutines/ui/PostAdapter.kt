package com.clean_arch_mvvm_coroutines.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.clean_arch_mvvm_coroutines.data.remote.model.Post
import com.clean_arch_mvvm_coroutines.databinding.PostItemHolderBinding

class PostsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mData = listOf<Post>()

    fun setData(data: List<Post>?) {
        mData = data!!
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PostViewHolder(
            PostItemHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )

    }

    override fun getItemCount(): Int = if (mData.isNullOrEmpty()) 0 else mData.size

    private fun getItem(position: Int): Post = mData[position]

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as PostViewHolder
        viewHolder.setBind(mData[position])

    }



    inner class PostViewHolder(private val viewDataBinding: PostItemHolderBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        fun setBind(post: Post) {
            viewDataBinding.postTitleTextView.text = post.title
            viewDataBinding.postBodyTextView.text = post.body

        }
    }
}