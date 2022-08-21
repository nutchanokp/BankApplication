package com.nutchanok.nat.bankapplication.ui.page.main.account

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.nutchanok.nat.bankapplication.R
import com.nutchanok.nat.bankapplication.extensions.toCurrency
import com.nutchanok.nat.bankapplication.model.BankAccountModel

@SuppressLint("SetTextI18n")
class PagerAdapter(models: List<BankAccountModel>, context: Context) : PagerAdapter() {
    private val models: List<BankAccountModel>

    private var layoutInflater: LayoutInflater? = null
    private val context: Context
    override fun getCount(): Int {
        return models.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater!!.inflate(R.layout.item_rv_account, container, false)
        val tvName: TextView = view.findViewById(R.id.tv_name)
        val tvAccountType: TextView = view.findViewById(R.id.tv_account_type)
        val tvAccountMain: TextView = view.findViewById(R.id.tv_account_main)
        val tvAccountId: TextView = view.findViewById(R.id.tv_account_id)
        val tvCurrentBalance: TextView = view.findViewById(R.id.tv_current_balance)
        val tvAvailableBalance: TextView = view.findViewById(R.id.tv_available_balance)

        val i = models[position]
        tvName.text = "${i.userName} ${i.userLastname}"
        tvAccountId.text = i.accountNo
        tvAccountType.text = i.accountType
        tvAccountMain.text = i.accountType
        tvCurrentBalance.text = i.currentBalance.toCurrency()
        tvAvailableBalance.text = i.availableBalance.toCurrency()



        container.addView(view, position)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    init {
        this.models = models
        this.context = context
    }

    fun getTotal(): Int {
        return models.size
    }
}