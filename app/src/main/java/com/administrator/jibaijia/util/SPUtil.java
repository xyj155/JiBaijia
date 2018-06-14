package com.administrator.jibaijia.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/6/14.
 */

public class SPUtil {
    public static void clear(Context context,String name) {
        SharedPreferences preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();

        editor.commit();
    }
}
