package com.sz.mangosteeneg.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.sz.mangosteeneg.BR;
import com.sz.mangosteeneg.R;
import com.sz.mangosteeneg.adapter.AddressAdapter;
import com.sz.mangosteeneg.base.AppBaseActivity;
import com.sz.mangosteeneg.databinding.ActivityTestBinding;
import com.sz.mangosteeneg.entity.CityAreasBean;
import com.sz.mangosteeneg.ui.viewmodel.TestMvvmViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time:2021/5/14 18:53
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: mvvm示例
 */
public class TestMvvmActivity extends AppBaseActivity<ActivityTestBinding, TestMvvmViewModel> {
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_test;
    }

    //数据源，适配器
    private AddressAdapter addressAdapter;
    private List<String> list = new ArrayList<>();

    @Override
    public void initData() {
        super.initData();
        showFullScreen(true);
        //初始化
        first();
        //监听
        monitor();
        //请求网络
//        getVM().reqAddress();
        getVM().reqJiade();
    }

    private void first(){
        getBinding().rl.setLayoutManager(new LinearLayoutManager(this));
        addressAdapter = new AddressAdapter(R.layout.item_txt_center,list);
        getBinding().rl.setAdapter(addressAdapter);
        //空布局
        View view = View.inflate(this,R.layout.no_layout,null);
        addressAdapter.setEmptyView(view);
    }

    private void monitor(){
        //监听网络请求的结果(接口地址我删了，请求不出来)
        getVM().liveAddress.observe(this,res -> {
//            setRecyclerView(res);
        });
        //假装的网络请求
        getVM().liveString.observe(this,list1 -> {
            setRecyclerView(list1);
        });
    }

    //设置列表
    private void setRecyclerView(List<String> list){
        addressAdapter.setNewData(list);
    }

    //获取databinding和viewmodel的两个方法
    public ActivityTestBinding getBinding(){
        return (ActivityTestBinding) binding;
    }
    public TestMvvmViewModel getVM(){
        return (TestMvvmViewModel)viewModel;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}