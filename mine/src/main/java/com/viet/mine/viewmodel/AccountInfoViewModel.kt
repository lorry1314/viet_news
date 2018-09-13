package com.viet.mine.viewmodel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import com.luck.picture.lib.entity.LocalMedia
import com.safframework.ext.then
import com.viet.mine.R
import com.viet.mine.repository.MineRepository
import com.viet.news.core.ext.toast
import com.viet.news.core.ui.App
import com.viet.news.core.viewmodel.BaseViewModel

class AccountInfoViewModel(var repository: MineRepository = MineRepository()) : BaseViewModel() {
    var selectList = ArrayList<LocalMedia>()


    var nickName: MutableLiveData<String> = MutableLiveData()    //提交昵称

    var submitEnable: MutableLiveData<Boolean> = MutableLiveData()   //提交按钮是否可用

    fun checkNickNameSubmitBtnEnable() {
        submitEnable.value = nickName.value != null && nickName.value!!.isNotEmpty()
    }

    fun nickNameSubmitEnable(): Boolean = when {
        nickName.value == null || nickName.value.isNullOrBlank() -> {
            false
        }
        else -> true
    }


    //修改昵称
    fun updateNickName(owner: LifecycleOwner, nickname: String, finish: (isSuccess: Boolean) -> Unit) {
        return repository.updateNickName(nickname).observe(owner, Observer {
            it?.data?.isOkStatus?.then({
                finish(true)
            }, {
                finish(false)
                toast(App.instance.resources.getString(R.string.error_msg)).show()
            })
        })
    }


    fun uploadFile(owner: LifecycleOwner, finish: (isSuccess: Boolean) -> Unit) {
        return repository.uploadFile(selectList[0].compressPath).observe(owner, Observer {
            it?.data?.isOkStatus?.then({
                finish(true)
            }, {
                finish(false)
                toast(App.instance.resources.getString(R.string.error_msg)).show()
            })
        })
    }
}