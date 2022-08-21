package com.nutchanok.nat.bankapplication.extensions

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.nat.bankapplication.common.adapter.BaseItemViewType
import com.nutchanok.nat.bankapplication.common.adapter.SimpleRecyclerAdapter
import com.nutchanok.nat.bankapplication.common.adapter.recyclerview.LoadingView
import com.nutchanok.nat.bankapplication.common.adapter.recyclerview.VTLoading


fun <Item, Binding : ViewDataBinding> Any.createRecyclerViewAdapter(
    layoutId: Int
): SimpleRecyclerAdapter<Item, Binding> {
    return SimpleRecyclerAdapter(layoutId)
}

fun RecyclerView.simepleAdapter(): SimpleRecyclerAdapter<*, *>? {
    if (this.adapter is SimpleRecyclerAdapter<*, *>) {
        return this.adapter as SimpleRecyclerAdapter<*, *>
    }
    return null
}

fun <Item, Binding : ViewDataBinding> RecyclerView.createList(
    layoutResId: Int,
    callback: ((Binding, Item?, Int) -> Unit)
) {
    val adapter = createRecyclerViewAdapter<Item, Binding>(layoutResId)
    this.adapter = adapter
    adapter.setListener(object : SimpleRecyclerAdapter.Listener<Item, Binding> {
        override fun onBindViewHolder(
            binding: Binding,
            holder: RecyclerView.ViewHolder,
            item: Item?,
            position: Int
        ) {
            callback.invoke(binding, item, position)
        }
    })
}

fun RecyclerView.setOnLoadMoreListener(isLoading: ((Unit) -> Boolean), loadMore: ((Unit) -> Unit)) {
    this.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val mLayoutManager = recyclerView.layoutManager as LinearLayoutManager
            val visibleItemCount = mLayoutManager.childCount
            val totalItemCount = mLayoutManager.itemCount
            val pastVisibleItems = mLayoutManager.findFirstVisibleItemPosition()
            if (!isLoading(Unit)) {
                if (visibleItemCount + pastVisibleItems >= totalItemCount) {
                    this@setOnLoadMoreListener.post {
                        loadMore.invoke(Unit)
                    }
                }
            }
        }
    })
}

fun <T : BaseItemViewType> MutableList<BaseItemViewType>.update(
    adapter: RecyclerView.Adapter<*>,
    update: T,
    condition: ((T) -> Boolean),
    onUpdate: ((T) -> Unit),
    onRemove: ((T) -> Unit)
) {
    this.find { it.type == update.type }?.let {
        val current = it as T
        current.isShowSkeleton = update.isShowSkeleton
        val position = this.indexOf(current)
        if (condition(current)) {
            onUpdate.invoke(current)
            adapter.notifyItemChanged(position)
        } else {
            onRemove.invoke(current)
            this.remove(current)
            adapter.notifyItemRemoved(position)
        }
    } ?: run {
        val position = update.type
        this.add(position, update)
        onUpdate.invoke(update)
        adapter.notifyItemInserted(position)
    }
}


inline fun <T : BaseItemViewType> MutableList<BaseItemViewType>.addNewList(
    adapter: RecyclerView.Adapter<*>,
    newList: MutableList<T>,
    viewType: Int,
    conditionRemoveSkeleton: ((T: BaseItemViewType) -> Boolean),
    crossinline onViewTypeEmpty: ((Unit) -> Unit)
) {

    val isShowSkeleton =
        this.filter { conditionRemoveSkeleton(it) && it.isShowSkeleton }
            .let { list ->
                list.forEach {
                    val index = this.indexOf(it)
                    it.isShowSkeleton = false
                    this.removeAt(index)
                    adapter.notifyItemRemoved(index)
                }
                list.isNotEmpty()
            }
    val endPosition = this.size
    this.addAll(endPosition, newList)
    adapter.notifyItemRangeInserted(endPosition, newList.size)

    val viewTypes = this.find { it.type == viewType }
    if (viewTypes == null) {
        onViewTypeEmpty.invoke(Unit)
    }
}

fun MutableList<BaseItemViewType>.isEmptyViewType(viewType: Int): Boolean {
    return this.find { it.type == viewType }?.let {
        false
    } ?: run {
        true
    }
}

fun MutableList<BaseItemViewType>.removeByViewType(
    adapter: RecyclerView.Adapter<*>,
    viewType: Int
) {
    this.find { it.type == viewType }
        ?.let {
            val position = this.indexOf(it)
            this.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
}

fun MutableList<BaseItemViewType>.removeByViewType(
    adapter: RecyclerView.Adapter<*>,
    viewType: Int,
    groupId: Int
) {
    this.find { it.type == viewType && it.groupId == groupId }
        ?.let {
            val position = this.indexOf(it)
            this.removeAt(position)
            adapter.notifyItemRemoved(position)
        }
}

fun RecyclerView.Adapter<*>.handleStateLoading(
    items: MutableList<BaseItemViewType>,
    isLoading: Boolean
): Boolean {
    if (isLoading) {
        val loadMore = items.find { it is VTLoading }
        if (loadMore == null) {
            items.add(LoadingView.create())
            notifyItemInserted(itemCount)
        }
    } else {
        val loadMore = items.find { it is VTLoading }
        loadMore?.let {
            val index = items.indexOf(loadMore)
            items.removeAt(index)
            notifyItemRemoved(index)
        }
    }
    return isLoading
}

