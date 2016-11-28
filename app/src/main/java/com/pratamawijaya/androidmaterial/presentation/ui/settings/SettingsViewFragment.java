package com.pratamawijaya.androidmaterial.presentation.ui.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pratamawijaya.androidmaterial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsViewFragment extends Fragment {

  public static SettingsViewFragment newInstance() {
    Bundle args = new Bundle();
    SettingsViewFragment fragment = new SettingsViewFragment();
    fragment.setArguments(args);
    return fragment;
  }

  public SettingsViewFragment() {
    // Required empty public constructor
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_settings_view, container, false);
  }
}
