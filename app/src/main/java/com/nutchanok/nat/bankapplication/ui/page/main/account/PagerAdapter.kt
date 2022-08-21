package com.nutchanok.nat.bankapplication.ui.page.main.account

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.nutchanok.nat.bankapplication.R
import com.nutchanok.nat.bankapplication.model.BankAccountModel


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
        var textview: TextView = view.findViewById(R.id.tv_name)
        textview.text = "asdf"

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
}