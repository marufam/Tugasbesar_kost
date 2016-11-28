package com.pratamawijaya.androidmaterial.presentation.ui.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.pratamawijaya.androidmaterial.presentation.ui.utils.FragmentOrganizer;

/**
 * Created by pratama on 8/30/16.
 */
public class HomeFragmentOrganizer extends FragmentOrganizer {
  public HomeFragmentOrganizer(FragmentManager fragmentManager, int containerResourceId) {
    super(fragmentManager, containerResourceId);
  }

  @Override protected Fragment getInitialFragment() {
    return HomeViewFragment.newInstance("");
  }

  @Override public boolean handleBackNavigation() {
    Fragment fragment = getOpenFragment();
    if (fragment instanceof HomeViewFragment) {
      return false;
    } else {
      fragmentManager.popBackStack();
      return true;
    }
  }
}
