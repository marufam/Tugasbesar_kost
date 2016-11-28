package com.pratamawijaya.androidmaterial.presentation.ui;

import android.app.Application;
import com.pratamawijaya.androidmaterial.BuildConfig;
import com.squareup.picasso.Picasso;

/**
 * Created by pratama on 9/5/16.
 */
public class BaseApplication extends Application {
  @Override public void onCreate() {
    super.onCreate();
    if (BuildConfig.DEBUG) {
      Picasso.with(this).setLoggingEnabled(true);
    }
  }
}
