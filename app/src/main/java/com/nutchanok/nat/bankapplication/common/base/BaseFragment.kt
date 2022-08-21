package com.nutchanok.nat.bankapplication.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.nutchanok.nat.bankapplication.extensions.overrideUIText

abstract class BaseFragment<B : ViewDataBinding> : Fragment() {

    protected lateinit var binding: B

    //    protected val progressDialog: ProgressDialogssDialog by lazy { ProgressDialog.newInstance() }
    protected var isVisit = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getExtra(arguments)
        overrideUIText(binding.root)
        setUp()
        subscribe()
        if (!isVisit) {
            onFirstVisit()
        }
    }

    override fun onResume() {
        super.onResume()
        if (!isVisit) {
            isVisit = true
        }
    }

    open fun onFirstVisit() {}

    abstract fun getLayoutId(): Int

    open fun getExtra(bundle: Bundle?) {}

    open fun setUp() {}

    open fun subscribe() {}

}