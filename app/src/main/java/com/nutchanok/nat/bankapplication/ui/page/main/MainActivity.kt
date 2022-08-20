package com.nutchanok.nat.bankapplication.ui.page.main

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.nat.bankapplication.R
import com.nutchanok.nat.bankapplication.adapter.SimpleRecyclerAdapter
import com.nutchanok.nat.bankapplication.base.BaseActivity
import com.nutchanok.nat.bankapplication.databinding.ActivityMainBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvAccountBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvTransactionsBinding
import com.nutchanok.nat.bankapplication.model.BankAccountModel
import com.nutchanok.nat.bankapplication.model.TransactionModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModel()

    private val accountAdapter by lazy {
        SimpleRecyclerAdapter<BankAccountModel, ItemRvAccountBinding>(
            R.layout.item_rv_account
        )
    }

    private val transactionAdapter by lazy {
        SimpleRecyclerAdapter<TransactionModel, ItemRvTransactionsBinding>(
            R.layout.item_rv_transactions
        )
    }

    override fun getLayoutId(): Int = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this.lifecycleOwner
            activity = this@MainActivity
            rvAccount.adapter = accountAdapter
            rvTransactions.adapter = transactionAdapter
        }
        setupAccountAdapter()
        setupTransferAdapter()


    }

    override fun initView() {
        mainViewModel.getAccounts()
        mainViewModel.getTransactions()
    }

    override fun initListener() {
    }

    override fun setupObserve() {
        mainViewModel.accountsResult().observe(this) {
            accountAdapter.addList(it.toMutableList())
        }
        mainViewModel.transactionsResult().observe(this) {
            transactionAdapter.addList(it.toMutableList())
        }
    }

    private fun setupAccountAdapter() {
        accountAdapter.setListener(object :
            SimpleRecyclerAdapter.Listener<BankAccountModel, ItemRvAccountBinding> {
            override fun onBindViewHolder(
                binding: ItemRvAccountBinding,
                holder: RecyclerView.ViewHolder,
                item: BankAccountModel?,
                position: Int
            ) {
                binding.item = item
                binding.executePendingBindings()
                binding.apply {
                    item?.let { i ->
                        this.tvName.text = "${i.userName} ${i.userLastname}"
                        this.tvAccountType.text = i.accountType
                        this.tvAccountMain.text = i.accountType
                        this.tvAccountMain.text = i.accountType
                        this.tvCurrentBalance.text = i.currentBalance.toString()
                        this.tvAvailableBalance.text = i.availableBalance.toString()

                    }
                }
            }
        })
    }

    private fun setupTransferAdapter() {
        transactionAdapter.setListener(object :
            SimpleRecyclerAdapter.Listener<TransactionModel, ItemRvTransactionsBinding> {
            override fun onBindViewHolder(
                binding: ItemRvTransactionsBinding,
                holder: RecyclerView.ViewHolder,
                item: TransactionModel?,
                position: Int
            ) {
                binding.item = item
                binding.executePendingBindings()
                binding.apply {

                    item?.let { i ->
                        tvTitle.text = i.transfer_type
                        tvDateTime.text = i.date_time
                        tvAmount.text = i.amount.toString()
                        tvFromTitle.text = i.from_account_bank
                        tvFromAccountBank.text = i.from_account_bank
                        tvFromAccountNo.text = i.from_account_no
                        tvFrom.text = i.from_account_name
                        btnDetail.setOnClickListener {

                        }
                    }
                }
            }

        })
    }

}