package com.sz.mangosteeneg.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sz.mangosteeneg.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @Time:2021/5/14 19:17
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: String 文本适配器
 */
public class TxtAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public TxtAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, String s) {
        holder.setText(R.id.tv_str,s);
    }
}