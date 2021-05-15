package com.sz.mangosteeneg.ui.activity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.sz.mangosteeneg.BR;
import com.sz.mangosteeneg.R;
import com.sz.mangosteeneg.adapter.TxtAdapter;
import com.sz.mangosteeneg.base.AppBaseActivity;
import com.sz.mangosteeneg.databinding.ActivityMainBinding;
import com.sz.mangosteeneg.ui.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppBaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    //ui
    private RecyclerView recyclerView;

    //数据源，适配器
    private List<String> list = new ArrayList<>();
    private TxtAdapter txtAdapter;

    @Override
    public void initData() {
        super.initData();
        showFullScreen(true);
        recyclerView = getBinding().mainRl;
        addRl();
        setRecyclerView();
    }

    //设置列表
    private void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        txtAdapter = new TxtAdapter(R.layout.item_txt_center,list);
        recyclerView.setAdapter(txtAdapter);
        if(recyclerView.getItemDecorationCount() == 0){
            recyclerView.addItemDecoration(new MyDecoration());
        }
        txtAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view, int position) {
                switch (position){
                    case 0:
                        //mvvm示例
                        Intent it0 = new Intent(MainActivity.this,TestMvvmActivity.class);
                        startActivity(it0);
                        break;
                }
            }
        });
    }

    //添加数据
    private void addRl(){
        list.add("MVVM示例");
    }

    public ActivityMainBinding getBinding(){
        return (ActivityMainBinding) binding;
    }

    public MainViewModel getVM(){
        return (MainViewModel)viewModel;
    }

    @Override
    public int initVariableId() {
        return BR.mainViewModel;
    }

    //recyclerview工具类
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(16,10,16,10);
        }
    }
}