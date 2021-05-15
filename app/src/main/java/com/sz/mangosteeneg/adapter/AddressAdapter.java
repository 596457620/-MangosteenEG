package com.sz.mangosteeneg.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.sz.mangosteeneg.R;
import com.sz.mangosteeneg.entity.CityAreasBean;
import com.sz.mangosteeneg.tools.StringUtil;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @Time:2021/5/11 19:50
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:
 */
public class AddressAdapter extends BaseQuickAdapter<CityAreasBean.DataBean.ListBean.ProvinceWithCityModelsBean, BaseViewHolder> {
    public AddressAdapter(int layoutResId, @Nullable List<CityAreasBean.DataBean.ListBean.ProvinceWithCityModelsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, CityAreasBean.DataBean.ListBean.ProvinceWithCityModelsBean item) {
        if(StringUtil.isNotEmpty(item.getName())){
            holder.setText(R.id.tv_str,item.getName());
        }
    }
}