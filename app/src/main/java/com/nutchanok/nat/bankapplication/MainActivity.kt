package com.nutchanok.nat.bankapplication

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.nat.bankapplication.adapter.SimpleRecyclerAdapter
import com.nutchanok.nat.bankapplication.base.BaseActivity
import com.nutchanok.nat.bankapplication.databinding.ActivityMainBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvAccountBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvTransactionsBinding
import com.nutchanok.nat.bankapplication.model.UIContentModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val accountAdapter by lazy {
        SimpleRecyclerAdapter<UIContentModel, ItemRvAccountBinding>(
            R.layout.item_rv_account
        )
    }

    private val transactionAdapter by lazy {
        SimpleRecyclerAdapter<UIContentModel, ItemRvTransactionsBinding>(
            R.layout.item_rv_transactions
        )
    }

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this.lifecycleOwner
//            menuItem = menu
//            menuCategoryItem = menuCategory
            activity = this@MainActivity
            rvAccount.adapter = accountAdapter
        }
        setupAccountAdapter()
        accountAdapter.setList(mutableListOf())
        val o :MutableList<UIContentModel> = mutableListOf()
        o.add(UIContentModel())
        o.add(UIContentModel())
        accountAdapter.addList(o)

    }

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun setupObserve() {
    }

    private fun setupAccountAdapter() {
        accountAdapter.setListener(object :
            SimpleRecyclerAdapter.Listener<UIContentModel, ItemRvAccountBinding> {
            override fun onBindViewHolder(
                binding: ItemRvAccountBinding,
                holder: RecyclerView.ViewHolder,
                item: UIContentModel?,
                position: Int
            ) {
                binding.item = item
                binding.executePendingBindings()
                binding.apply {

                    item?.let { itemBom ->
                        var i = itemBom
//                        i.menuId = menu?.menuId ?: 0
//                        btnDeleteItem.setOnClickListener {
//                            //itemBom.isSelect = !itemBom.isSelect
//                            deleteItem(itemBom.id)
//                        }
//
//                        btnEditItem.setOnClickListener {
//                            AddMenusBOMInventoryDialog.newInstance(i, menu?.menuId ?: 0).apply {
//                                setOnAddUpdateSuccess {
//                                    menu?.menuId?.let { inventoryViewModel.getBomByMenuId(it) }
//                                }
//                            }.show(supportFragmentManager)
//                        }
                    }
                }
            }

        })
    }

}