package com.sz.mangosteeneg.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import androidx.databinding.ViewDataBinding;

import com.sz.mangosteeneg.R;
import com.sz.mangosteeneg.tools.RxBus;
import com.sz.mangosteeneg.widget.application.MessageEnterBack;

import java.util.List;

/**
 * @Time:2021/5/14 17:34
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description:
 */
public abstract class AppBaseActivity<V extends ViewDataBinding, VM extends BaseAppViewModel> extends BaseActivity {

    public int currentPage = 1;

    @Override
    public void initData() {
        super.initData();

    }

    //    @Override
    //    public int initContentView(Bundle savedInstanceState) {
    //        return 0;
    //    }
    //
    //    @Override
    //    public int initVariableId() {
    //        return 0;
    //    }

    protected void showSoftInputKetboard(final EditText editText) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                editText.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        }, 500);
    }

    protected void hideSoftInputKetboard(final EditText editText) {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0); //强制隐藏键盘
    }

    /**
     * 全屏显示
     */
    protected void showFullScreen(boolean full) {
        Window window = getWindow();
        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        //true 为白，false 为黑(透明)
        if(full){
            //6.0以上可以使用
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView()
                        .setSystemUiVisibility(
                                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.line_color));
            }
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        MessageEnterBack enterBack = new MessageEnterBack(false);
        RxBus.getDefault().post(enterBack);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

        if (!isAppOnForeground()) {
            //app 进入后台,停止IMService,采用push机制接收离线消息
            Log.i("im", "app enter background");
            MessageEnterBack enterBack = new MessageEnterBack(true);
            RxBus.getDefault().post(enterBack);
        }
    }

    /**
     * 程序是否在前台运行
     */
    public boolean isAppOnForeground() {
        ActivityManager activityManager =
                (ActivityManager) getApplicationContext().getSystemService(
                        Context.ACTIVITY_SERVICE);
        String packageName = getApplicationContext().getPackageName();

        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }

        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance
                    == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }

        return false;
    }

}
