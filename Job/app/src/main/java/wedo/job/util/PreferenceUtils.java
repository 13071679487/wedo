package wedo.job.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Preference文件的工具类
 * Created by Lifu on 2017/9/15.
 */
public class PreferenceUtils {
    /**
     * 写入数据(int类型)
     */
    public static void write(Context context, String fileName, String k, int v) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(k, v);
        editor.commit();
        Log.d("写入数据----->", "成功");
    }


    /**
     * 写入数据（boolean数据类型）
     */
    public static void write(Context context, String fileName, String k, boolean v) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(k, v);
        editor.commit();
        Log.d("写入boolean值----->", "成功");
    }


    /**
     * 写入数据(String数据类型)
     *
     */
    public static void write(Context context, String fileName, String k, String v) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(k, v);
        editor.commit();
        Log.d("写入String值----->", "成功");
    }


    /**
     * 阅读Int数据
     */
    public static int readInt(Context context, String fileName, String k, int defV) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Log.d("读取Int数据----->", "成功");
        return preferences.getInt(k, defV);
    }


    /**
     * 阅读Int数据(默认为0)
     */
    public static int readInt(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Log.d("读取Int数据----->", "成功");
        return preferences.getInt(k, 0);
    }


    /**
     * 阅读String数据
     *
     */
    public static String readString(Context context, String fileName, String k, String defV) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Log.d("读取String数据----->", "成功");
        return preferences.getString(k, defV);
    }

    /**
     * 阅读String数据(默认为null)
     *
     */
    public static String readString(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Log.d("读取String数据----->", "成功");
        return preferences.getString(k, null);
    }


    /**
     * 阅读Boolean数据
     *
     */
    public static boolean readBoolean(Context context, String fileName, String k, boolean defV) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Log.d("读取Boolean数据----->", "成功");
        return preferences.getBoolean(k, defV);
    }


    /**
     * 阅读Boolean数据(默认为false)
     *
     */
    public static boolean readBoolean(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        Log.d("读取Boolean数据----->", "成功");
        return preferences.getBoolean(k, false);
    }


    /**
     * 删除文件
     *
     */
    public static void remove(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(k);
        editor.commit();
        Log.d("删除文件----->", "成功");
    }


    /**
     * 清除sharedPreferences
     *
     */
    public static void clear(Context context, String fileName) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
        Log.d("清除", "SharedPreferences文件----->成功");
    }
}
