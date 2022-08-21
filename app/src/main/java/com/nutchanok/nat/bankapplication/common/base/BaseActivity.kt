package com.nutchanok.nat.bankapplication.common.base

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: B

//    private val disposable: CompositeDisposable by lazy { CompositeDisposable() }
//    private val dialogLoading: DialogLoading by lazy { DialogLoading.newInstance() }
    private var isShowDialogUnAuthorized = false
    private var isShowEventAppDialog = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER
        binding = DataBindingUtil.setContentView(this, getLayoutId())
//        bindUiLanguage(binding.root)
        intent.extras?.let {
            getExtra(it)
        }

        initView()
        initListener()
        setupObserve()
//        subscribe()
    }

    abstract fun getLayoutId(): Int
    abstract fun initView()
    abstract fun initListener()
    abstract fun setupObserve()

//    abstract fun subscribe()

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.extras?.let {
            getExtra(it)
        }
    }

    protected open fun getExtra(bundle: Bundle) {
        //bundle.clear()
    }

    override fun onResume() {
        super.onResume()
        handleAppEvent()
    }

    override fun onStop() {
        super.onStop()
//        disposable.clear()

    }

    override fun onBackPressed() {
        super.onBackPressed()
//        hideKeyboard()
    }

    protected open fun isCheckWhenKeyboardOpen(): Boolean {
        return false
    }

    protected open fun getViewCheckWhenKeyboardOpen(): View? {
        return this.findViewById<ViewGroup>(android.R.id.content)
    }

    private fun handleAppEvent() {
//        disposable.add(RxBus.listen(RxEvent.EventAppUpdate::class.java).subscribe { it ->
//            when (it.event) {
//                EventAppEnums.MAINTENANCE -> showDialogMaintenance()
//                EventAppEnums.SOFT_UPDATE -> showDialogSoftUpdate(it.message)
//                EventAppEnums.FORCE_UPDATE -> showDialogForceUpdate()
//                EventAppEnums.UNAUTHORIZED -> showDialogUnAuthorized(it.message)
//                else -> {
//
//                }
//            }
//        })
    }

//    fun showLoading() {
//        runOnUiThread {
//            if (!dialogLoading.isShowing) {
//                dialogLoading.show(supportFragmentManager)
//            }
//        }
//    }
//
//    fun hideLoading() {
//        runOnUiThread {
//            if (dialogLoading.isShowing) {
//                dialogLoading.dismiss()
//            }
//        }
//    }

//    fun showAlertDialog(message: String?) {
//        hideLoading()
//        message?.let {
//            if (it.isEmpty()) return
//            runOnUiThread {
//                val dialog = DialogAlertMessage.newInstance(it)
//                dialog.show(supportFragmentManager)
//            }
//        }
//    }
//
//
//    private fun showDialogForceUpdate() {
//        if (!isShowEventAppDialog) {
//            isShowEventAppDialog = true
//            val message = getUiText("101007", "New version  available")
//            val dialog = DialogAlertMessage.newInstance(message)
//            dialog.setOnButtonLeftClick {
//                goToGoogleStore(this)
//                finishAffinity()
//            }
//            dialog.show(supportFragmentManager)
//        }
//    }
//
//    private fun showDialogSoftUpdate(version: String?) {
//        if (!isShowEventAppDialog) {
//            isShowEventAppDialog = true
//            val format = getUiText("101006", "New version available")
//            val message = String.format(format, version)
//            val left = getUiText("115001", "Cancel")
//            val right = getUiText("115002", "Update")
//            val dialog = DialogAlertMessage.newInstance(message, left, right)
//            dialog.setOnButtonLeftClick {
//                RxBus.publish(RxEvent.EventContinueFlow(Unit))
//            }
//            dialog.setOnButtonRightClick {
//                goToGoogleStore(this)
//                RxBus.publish(RxEvent.EventContinueFlow(Unit))
//            }
//            dialog.show(supportFragmentManager)
//            dialog.focusRight = true
//        }
//    }
//
//    private fun showDialogMaintenance() {
//        val message = ""
//        val dialog = DialogAlertMessage.newInstance(message)
//        dialog.setOnButtonLeftClick {
//            finishAffinity()
//        }
//        dialog.show(supportFragmentManager)
//    }


}