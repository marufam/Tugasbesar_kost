package com.pratamawijaya.androidmaterial.presentation.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratamawijaya.androidmaterial.R;
import com.pratamawijaya.androidmaterial.data.repository.SpeciesDataRespository;
import com.pratamawijaya.androidmaterial.domain.model.Species;
import com.pratamawijaya.androidmaterial.presentation.ui.home.adapter.HomeAdapter;
import com.pratamawijaya.androidmaterial.presentation.ui.home.presenter.HomePresenter;
import com.pratamawijaya.androidmaterial.presentation.ui.home.view.HomeContract;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeViewFragment extends Fragment
    implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener,
    HomeAdapter.HomeAdapterListener {

  @BindView(R.id.content_view) SwipeRefreshLayout contentView;
  @BindView(R.id.recycler_view) RecyclerView recyclerView;
  @BindView(R.id.loading_view) ProgressBar loadingView;
  @BindView(R.id.error_view) TextView errorView;

  private HomePresenter presenter;
  private HomeAdapter adapter;
  private List<Species> species;

  public HomeViewFragment() {
    // Required empty public constructor
  }

  public static HomeViewFragment newInstance(String data) {
    Bundle args = new Bundle();
    args.putString("data", data);
    HomeViewFragment fragment = new HomeViewFragment();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    presenter = new HomePresenter(new SpeciesDataRespository(), this);
    setHasOptionsMenu(true);
    String text = getArguments().getString("data");
  }

  @Override public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.menu_option, menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.action_about) {
      Toast.makeText(getContext(), "about", Toast.LENGTH_SHORT).show();
    }
    return true;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
    setupRecyclerView();
    presenter.getListSpecies();
  }

  private void setupRecyclerView() {
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    species = new ArrayList<>();
    adapter = new HomeAdapter(getActivity(), species, this);
    recyclerView.setAdapter(adapter);
    contentView.setOnRefreshListener(this);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_main_view, container, false);
  }

  @Override public void showLoading() {
    loadingView.setVisibility(View.VISIBLE);
    contentView.setVisibility(View.GONE);
  }

  @Override public void hideLoading() {
    loadingView.setVisibility(View.GONE);
    contentView.setVisibility(View.VISIBLE);
  }

  @Override public void showError() {
    contentView.setVisibility(View.GONE);
    errorView.setVisibility(View.VISIBLE);
  }

  @Override public void setSpecies(List<Species> species) {
    this.species.addAll(species);
    adapter.notifyDataSetChanged();
  }

  @Override public void onRefresh() {
    contentView.setRefreshing(true);
    this.species.clear();
    presenter.getListSpecies();
    contentView.setRefreshing(false);
  }

  @Override public void onItemClick(Species species) {
    Toast.makeText(getActivity(), species.name, Toast.LENGTH_SHORT).show();
  }
}
