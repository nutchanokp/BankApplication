package com.nutchanok.nat.bankapplication.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.nat.bankapplication.R
import com.nutchanok.nat.bankapplication.adapter.BaseItemViewType
import com.nutchanok.nat.bankapplication.databinding.ItemLoadingViewBinding

class RecyclerViewLoadingHolder {
    companion object {
        const val TYPE_LOAD_MORE = 888
    }
}

class LoadingView {
    companion object {
        fun create() = VTLoading()
    }
}

class VTLoading : BaseItemViewType(RecyclerViewLoadingHolder.TYPE_LOAD_MORE)

class LoadingHolder(var binding: ItemLoadingViewBinding) : RecyclerView.ViewHolder(binding.root)

fun ViewGroup.createLoadingHolder(): LoadingHolder {
    val binding = DataBindingUtil.inflate<ItemLoadingViewBinding>(
        LayoutInflater.from(context),
        R.layout.item_loading_view,
        this,
        false
    )
    return LoadingHolder(binding)
}