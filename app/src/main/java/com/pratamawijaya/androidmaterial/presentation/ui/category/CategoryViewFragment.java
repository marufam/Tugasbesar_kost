package com.pratamawijaya.androidmaterial.presentation.ui.category;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.pratamawijaya.androidmaterial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryViewFragment extends Fragment {

  public CategoryViewFragment() {
    // Required empty public constructor
  }

  public static CategoryViewFragment newInstance() {
    Bundle args = new Bundle();
    CategoryViewFragment fragment = new CategoryViewFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_category, container, false);
  }
}
