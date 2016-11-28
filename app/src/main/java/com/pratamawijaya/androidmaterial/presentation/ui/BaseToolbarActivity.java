package com.pratamawijaya.androidmaterial.presentation.ui;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import com.pratamawijaya.androidmaterial.R;

/**
 * Created by pratama on 8/30/16.
 */
public class BaseToolbarActivity extends BaseActivity {

  private Toolbar toolbar;

  @Override public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
    getToolbar();
  }

  protected Toolbar getToolbar() {
    if (toolbar == null) {
      toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
    }
    return toolbar;
  }
}
