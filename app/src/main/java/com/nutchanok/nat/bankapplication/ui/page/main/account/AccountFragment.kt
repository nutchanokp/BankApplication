package com.nutchanok.nat.bankapplication.ui.page.main.account

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.nutchanok.nat.bankapplication.R
import com.nutchanok.nat.bankapplication.common.adapter.SimpleRecyclerAdapter
import com.nutchanok.nat.bankapplication.common.base.BaseFragment
import com.nutchanok.nat.bankapplication.databinding.FragmentAccountBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvAccountBinding
import com.nutchanok.nat.bankapplication.databinding.ItemRvTransactionsBinding
import com.nutchanok.nat.bankapplication.common.enums.TransactionTypeEnum
import com.nutchanok.nat.bankapplication.extensions.DateFormat
import com.nutchanok.nat.bankapplication.extensions.loadImage
import com.nutchanok.nat.bankapplication.extensions.toCurrency
import com.nutchanok.nat.bankapplication.extensions.toDateFormat
import com.nutchanok.nat.bankapplication.model.BankAccountModel
import com.nutchanok.nat.bankapplication.model.TransactionModel
import com.nutchanok.nat.bankapplication.ui.page.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


@SuppressLint("SetTextI18n")
class AccountFragment : BaseFragment<FragmentAccountBinding>() {

    private val mainViewModel: MainViewModel by sharedViewModel()

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

    var adapter: PagerAdapter? = null


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

        setupViewPager()
    }

    private fun setupViewPager() {

        binding.apply {

            viewPager.pageMargin = 15
            viewPager.setPadding(50, 0, 50, 0);
            viewPager.clipToPadding = false
            viewPager.adapter = adapter
        }
//        binding.viewPager.adapter = adapter
        binding.viewPager.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                position
            }

            override fun onPageSelected(position: Int) {
                binding.tvAccountTotal.text = "${position.plus(1)}/${adapter?.getTotal()}"
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun initListener() {
        binding.swipeRefresh.apply {
            setOnRefreshListener {
                mainViewModel.getAccounts()
                mainViewModel.getTransactions()
                Handler(Looper.getMainLooper()).postDelayed({
                    this.isRefreshing = false
                }, 100)
            }
        }
    }

    override fun subscribe() {
        super.subscribe()

        mainViewModel.accountsResult().observe(this) {
            accountAdapter.addList(true, it.toMutableList())
            adapter = PagerAdapter(it, requireActivity())
            binding.viewPager.adapter = adapter
            binding.tvAccountTotal.text = "1/${adapter?.getTotal()}"
        }
        mainViewModel.transactionsResult().observe(this) {
            transactionAdapter.addList(true, it.toMutableList())
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
                        tvTitle.text = i.transferTypeEnum.desc
                        tvDateTime.text = i.dateTime?.toDateFormat(
                            DateFormat.FROM_SERVICE_TIME,
                            DateFormat.SHOW
                        )
                        tvFromTitle.text = i.fromAccountBank
                        tvFromAccountBank.text = i.fromAccountBank
                        tvFromAccountNo.text = i.fromAccountNo
                        tvFrom.text = i.fromAccountName

                        handleDetailVisibility(i.isExpanded, binding)
                        when (i.transferTypeEnum) {
                            TransactionTypeEnum.IN -> {
                                tvAmount.text = "+${i.amount.toCurrency()}"
                                tvAmount.setTextColor(
                                    ContextCompat.getColor(
                                        requireActivity(),
                                        R.color.txt_green
                                    )
                                )
                            }
                            else -> {
                                tvAmount.text = "-${i.amount.toCurrency()}"
                                tvAmount.setTextColor(
                                    ContextCompat.getColor(
                                        requireActivity(),
                                        R.color.txt_red
                                    )
                                )
                            }
                        }

                        btnDetail.setOnClickListener {
                            i.isExpanded = i.isExpanded != true
                            handleDetailVisibility(i.isExpanded, binding)
                        }
                    }
                }
            }

            fun handleDetailVisibility(isExpanded: Boolean?, binding: ItemRvTransactionsBinding) {
                binding.apply {
                    if (isExpanded == true) {
                        viewShowDetail.visibility = VISIBLE
                        btnDetail.loadImage(R.drawable.ic_arrow_up)
                    } else {
                        viewShowDetail.visibility = GONE
                        btnDetail.loadImage(R.drawable.ic_arrow_down)
                    }
                }
            }


        })

    }


}