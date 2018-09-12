package com.viet.follow.adapter

import com.viet.follow.R
import com.viet.news.core.domain.response.ImageEntity
import com.viet.news.core.ext.load
import com.viet.news.core.ui.BaseAdapter
import kotlinx.android.synthetic.main.cell_news_picture.view.*

/**
 * @Description
 * @Author sean
 * @Email xiao.lu@magicwindow.cn
 * @Date 05/09/2018 11:49 AM
 * @Version
 */
class NewsCellAdapter : BaseAdapter<ImageEntity>() {
    override fun getLayoutId(viewType: Int): Int = R.layout.cell_news_picture

    override fun onBindViewHolderImpl(holder: BaseViewHolder, position: Int, t: ImageEntity) {
        holder.itemView.iv_pic.load(t.cover)
    }
}