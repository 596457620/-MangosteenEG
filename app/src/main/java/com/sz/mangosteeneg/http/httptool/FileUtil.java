package com.sz.mangosteeneg.http.httptool;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import androidx.core.content.FileProvider;

import com.sz.mangosteeneg.base.BaseFragment;
import com.sz.mangosteeneg.widget.application.Constants;

import java.io.File;

/**
 * @Time:2021/5/14 16:15
 * @Author:sz
 * @email: 15090708443@163.com
 * @Description: 文件，图片截取，等
 */
public class FileUtil {
    public static final String FILE_DIR = "mvvm_base";
    public static final String SD_CARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String SD_ROOT_PATH = SD_CARD + File.separator + FILE_DIR;


    public static final String CACHE_FILE = SD_ROOT_PATH + File.separator + "cache/";//sd卡缓存目录

    public static final String PRINT_SCREEN_PATH = SD_ROOT_PATH + File.separator + "printscreen/";


    public static final String FILE_CLIP_PATH = Environment.getExternalStorageDirectory() +
            File.separator + Constants.PROJECT_NAME + File.separator + "crop";

    public static final String CAMERA_IMAGE_PATH = Environment.getExternalStorageDirectory() +
            File.separator + "DCIM" + File.separator;

    public static final String UPLOAD_PATH = SD_ROOT_PATH + File.separator + "upload";


    public static String getAppCachePath(){
        String appCachePath = Utils.getContext().getCacheDir().getAbsolutePath() + File.separator + FILE_DIR;

        return appCachePath;
    }

    public static void initDir(){
        File cropDir = new File(FILE_CLIP_PATH);
        if (!cropDir.exists()) {
            cropDir.mkdirs();
        }

        File cameraDir = new File(CAMERA_IMAGE_PATH);
        if (!cameraDir.exists()) {
            cameraDir.mkdirs();
        }

        File printScreen = new File(PRINT_SCREEN_PATH);
        if (!printScreen.exists()) {
            printScreen.mkdirs();
        }
    }

    /**
     * 私有目录，缓存文件(图片)
     */
    public static String initPrivateFile(Context context) {
        String imgCachePath = context.getCacheDir().getAbsolutePath() + File.separator + "cache/";
        return imgCachePath;
    }

    /**
     * 在SD卡上创建目录
     *
     * @param dirName
     * @return
     */
    public static File createSDDir(String dirName) {
        File file = new File(dirName);
        if (!file.exists())
            file.mkdirs();
        return file;
    }

    public static void createDir(String... dirPath) {
        File dir = null;
        for (int i = 0; i < dirPath.length; i++) {
            dir = new File(dirPath[i]);
            if (!dir.exists() && !dir.isDirectory()) {
                dir.mkdirs();
            }
        }
    }

    public static File getCacheDirFile(String filePahth) {
        createDir(filePahth);
        return new File(filePahth);
    }


    /**
     * 打开相机
     *
     * @param fragment    可以为空，如果是在fragment页面打开相机不能为空，否者回调onactivityResult不能成功
     * @param activity
     * @param file        拍照后文件对象
     * @param requestCode
     */
    public static void startActionCapture(BaseFragment fragment, Activity activity, File file, int requestCode) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, getUriForFile(activity, file));
        if (fragment != null)
            fragment.startActivityForResult(intent, requestCode);
        else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

    private static Uri getUriForFile(Context context, File file) {
        if (context == null || file == null) {
            throw new NullPointerException();
        }
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            uri = FileProvider.getUriForFile(context.getApplicationContext(), BuildConfig.APPLICATION_ID + ".fileProvider", file);
            uri = FileProvider.getUriForFile(context.getApplicationContext(), RuntimeData.getInstance().getApplicationId() + ".fileProvider", file);

        } else {
            uri = Uri.fromFile(file);
        }
        return uri;
    }

    /**
     * 调用系统工具截取图片
     *
     * @param fragment    可以为空，如果是在fragment页面打开相机不能为空，否者回调onactivityResult不能成功
     * @param activity
     * @param source      输入源文件
     * @param output      输入裁剪文件
     * @param requestCode 回调code
     */
    public static void startActionCrop(BaseFragment fragment, Activity activity, File source, Uri output, int requestCode) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(getUriForFile(activity, source), "image/*");
        intent.putExtra("output", output);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);// 裁剪框比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 400);// 输出图片大小
        intent.putExtra("outputY", 400);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//        intent.putExtra("return-data", true);//如果需要到处bitmap对象可以打开
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }

}