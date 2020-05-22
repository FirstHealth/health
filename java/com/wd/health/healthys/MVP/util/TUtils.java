package com.wd.health.healthys.MVP.util;

import android.util.Log;
import android.widget.Toast;
import com.wd.health.healthys.MVP.app.MyApps;

/**
 * author : Eaves
 * desc   : 功能描述
 */
public class TUtils {

    public static void toastInfo(String str){

        Toast.makeText(MyApps.context, str, Toast.LENGTH_SHORT).show();
    }

    public static void logInfo(String str){

        Log.e("MyMessage",str);
    }
}
