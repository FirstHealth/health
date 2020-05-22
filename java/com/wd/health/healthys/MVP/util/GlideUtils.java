package com.wd.health.healthys.MVP.util;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.wd.health.healthys.MVP.app.MyApps;

/**
 * author : Eaves
 * desc   : 功能描述
 */
public class GlideUtils {

    public static void loadRoundImg(String uri, ImageView imageView){

        Glide.with(MyApps.context).load(uri)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                .into(imageView);
    }

    public static void loadCircleImg(String uri, ImageView imageView){
        Glide.with(MyApps.context).load(uri)
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(imageView);
    }



}
