package com.wd.health.healthys.MVP.app;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

/**
 * Created by Android Studio.
 * User: 王斌
 * Date: 2020/5/18
 * Time: 19:33
 */
public class MyApps extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //初始化Fresco
        InFresco();
    }

    private void InFresco() {
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(context)
                .setBaseDirectoryPath(new File(Environment.getDataDirectory().getPath() + "Fresco"))
                .setMaxCacheSize(1080 * 1080 * 500)
                .build();
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(context)
                .setMainDiskCacheConfig(diskCacheConfig)
                .build();
        Fresco.initialize(context, imagePipelineConfig);
    }
}
