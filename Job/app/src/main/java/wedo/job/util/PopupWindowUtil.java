package wedo.job.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * Created by Lifu on 2017/9/16.
 */

public abstract class PopupWindowUtil {
    private static View contentView;
    private static PopupWindow pop;

    //展示用户详细信息的窗口
    public static void showPopupWindowUserDetail(Context context, int resId,View parent, String user_id) {
        LayoutInflater inflater = LayoutInflater.from(context);
        contentView = inflater.inflate(resId, null);
        pop = new PopupWindow(context);
        pop.setContentView(contentView);
        pop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(null);
        pop.showAtLocation(parent, Gravity.CENTER,0,0);
    }

    //fragment的溢出菜单工具
    public static void showPopupWindowOverFlowMenu(Context context, int resId, View parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        contentView = inflater.inflate(resId, null);
        pop = new PopupWindow(context);
        pop.setContentView(contentView);
        pop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(null);
        pop.showAsDropDown(parent);
    }

    //fragment的溢出菜单工具
    public static void showPopupWindowWhenExit(Context context, int resId, View parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        contentView = inflater.inflate(resId, null);
        pop = new PopupWindow(context);
        pop.setContentView(contentView);
        pop.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(null);
        pop.showAtLocation(parent, Gravity.CENTER,0,0);
    }

    public static View getContentView(){
        if(contentView!=null)
            return contentView;
        else return null;
    }
    public static PopupWindow getPopupWindow(){
        if(pop!=null)
            return pop;
        else return null;
    }
}