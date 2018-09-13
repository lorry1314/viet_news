package com.viet.follow.repository

import android.arch.lifecycle.LiveData
import com.viet.news.core.api.ApiRepository
import com.viet.news.core.api.ApiResponse
import com.viet.news.core.api.HttpResponse
import com.viet.news.core.config.Config
import com.viet.news.core.domain.request.ListParams
import com.viet.news.core.domain.response.UserInfoListResponse
import com.viet.news.core.repository.NetworkOnlyResource
import com.viet.news.core.vo.Resource

/**
 * @Description
 * @Author sean
 * @Email xiao.lu@magicwindow.cn
 * @Date 13/09/2018 10:57 AM
 * @Version
 */
class FansAndFollowRepository : ApiRepository() {

    fun followList(page_number: Int, id: String?): LiveData<Resource<HttpResponse<UserInfoListResponse>>> {
        val params = ListParams()
        params.page_number = page_number
        params.page_size = Config.page_size
        params.user_id = id
        return object : NetworkOnlyResource<HttpResponse<UserInfoListResponse>>() {
            override fun createCall(): LiveData<ApiResponse<HttpResponse<UserInfoListResponse>>> {
                return apiInterface.followList(params)
            }
        }.asLiveData()
    }

    fun fansList(page_number: Int, id: String?): LiveData<Resource<HttpResponse<UserInfoListResponse>>> {
        val params = ListParams()
        params.page_number = page_number
        params.page_size = Config.page_size
        params.user_id = id
        return object : NetworkOnlyResource<HttpResponse<UserInfoListResponse>>() {
            override fun createCall(): LiveData<ApiResponse<HttpResponse<UserInfoListResponse>>> {
                return apiInterface.fansList(params)
            }
        }.asLiveData()
    }

    fun follow(followUserId: String?): LiveData<Resource<HttpResponse<Any>>> {
        return object : NetworkOnlyResource<HttpResponse<Any>>() {
            override fun createCall(): LiveData<ApiResponse<HttpResponse<Any>>> {
                return apiInterface.follow(followUserId)
            }
        }.asLiveData()
    }
}