package com.nutchanok.nat.bankapplication.ui.page.main.account

import androidx.recyclerview.widget.RecyclerView
import com.nutchanok.nat.bankapplication.R
import com.nutchanok.nat.bankapplication.adapter.SimpleRecyclerAdapter
import com.nutchanok.nat.bankapplication.base.BaseFragment
import com.nutchanok.nat.bankapplication.databinding.FragmentAccountBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvAccountBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvTransactionsBinding
import com.nutchanok.nat.bankapplication.extensions.toCurrency
import com.nutchanok.nat.bankapplication.model.BankAccountModel
import com.nutchanok.nat.bankapplication.model.TransactionModel
import com.nutchanok.nat.bankapplication.ui.page.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AccountFragment : BaseFragment<FragmentAccountBinding>() {

        private val mainViewModel: MainViewModel by sharedViewModel()
//    private val mainViewModel: MainViewModel by viewModel()
//    private var adapterPager: OrderPagerAdapter? = null


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

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragment()
    }


    override fun getLayoutId(): Int {
        return R.layout.fragment_account
    }

    override fun setUp() {
        super.setUp()

        binding.apply {
            fragment = this@AccountFragment
            lifecycleOwner = viewLifecycleOwner
        }
        initView()
        initListener()

        setupAccountAdapter()
        setupTransferAdapter()


    }

    private fun initView() {

        binding.apply {
            rvAccount.adapter = accountAdapter
            rvTransactions.adapter = transactionAdapter
        }
        mainViewModel.getAccounts()
        mainViewModel.getTransactions()
    }

    private fun initListener() {
    }

    override fun subscribe() {
        super.subscribe()

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
                        this.tvCurrentBalance.text = i.currentBalance.toCurrency()
                        this.tvAvailableBalance.text = i.availableBalance.toCurrency()

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
                        tvAmount.text = i.amount.toCurrency()
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