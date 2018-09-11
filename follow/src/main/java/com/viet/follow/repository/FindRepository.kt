package com.viet.follow.repository

import android.arch.lifecycle.LiveData
import com.viet.news.core.api.ApiRepository
import com.viet.news.core.api.ApiResponse
import com.viet.news.core.domain.request.ChannelParams
import com.viet.news.core.domain.response.ChannelAllListResponse
import com.viet.news.core.domain.response.ChannelListResponse
import com.viet.news.core.repository.NetworkOnlyResource
import com.viet.news.core.vo.Resource

/**
 * @Description
 * @Author sean
 * @Email xiao.lu@magicwindow.cn
 * @Date 2018/9/10 上午10:56
 * @Version
 */
class FindRepository : ApiRepository() {

    fun getChannelAllList(): LiveData<Resource<ChannelAllListResponse>> {
        return object : NetworkOnlyResource<ChannelAllListResponse>() {
            override fun createCall(): LiveData<ApiResponse<ChannelAllListResponse>> {
                return apiInterface.getChannelAllList()
            }
        }.asLiveData()
    }

    fun getChannelList(): LiveData<Resource<ChannelListResponse>> {
        return object : NetworkOnlyResource<ChannelListResponse>() {
            override fun createCall(): LiveData<ApiResponse<ChannelListResponse>> {
                return apiInterface.getChannelList()
            }
        }.asLiveData()
    }

    fun channelAdd(id: String?): LiveData<Resource<Any>> {
        return object : NetworkOnlyResource<Any>() {
            override fun createCall(): LiveData<ApiResponse<Any>> {
                return apiInterface.channelAdd(ChannelParams(id))
            }
        }.asLiveData()
    }

    fun channelRemove(id: String?): LiveData<Resource<Any>> {
        return object : NetworkOnlyResource<Any>() {
            override fun createCall(): LiveData<ApiResponse<Any>> {
                return apiInterface.channelRemove(ChannelParams(id))
            }
        }.asLiveData()
    }

}