package com.pratamawijaya.androidmaterial.presentation.ui.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratamawijaya.androidmaterial.R;
import com.pratamawijaya.androidmaterial.presentation.ui.BaseToolbarActivity;
import com.pratamawijaya.androidmaterial.presentation.ui.account.AccountViewFragment;
import com.pratamawijaya.androidmaterial.presentation.ui.category.CategoryViewFragment;
import com.pratamawijaya.androidmaterial.presentation.ui.settings.SettingsViewFragment;

public class HomeViewActivity extends BaseToolbarActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @BindView(R.id.drawer_layout) DrawerLayout drawerLayout;
  @BindView(R.id.navigation_view) NavigationView navigationView;

  private HomeFragmentOrganizer fragmentOrganizer;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    setupActionBar();
    setupNavigationView();
    setupFragmentOrganizer();

    navigationView.getMenu().getItem(0).setChecked(true);
  }

  private void setupActionBar() {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    switch (id) {
      case android.R.id.home:
        drawerLayout.openDrawer(GravityCompat.START);
        break;
    }
    return true;
  }

  /**
   * handle navigationview, setup header
   */
  private void setupNavigationView() {
    if (navigationView != null) {
      // inflating headerview
      View headerView = navigationView.inflateHeaderView(R.layout.layout_header_navigationview);

      TextView txtUser = (TextView) headerView.findViewById(R.id.txt_username);

      txtUser.setText("Pratama Nur Wijaya");

      navigationView.setNavigationItemSelectedListener(this);
    }
  }

  private void setupFragmentOrganizer() {
    fragmentOrganizer =
        new HomeFragmentOrganizer(getSupportFragmentManager(), R.id.container_fragment);
  }

  @Override public void onBackPressed() {
    if (!fragmentOrganizer.handleBackNavigation()) finish();
  }

  @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.menu_home:
        navigationView.getMenu().getItem(0).setChecked(true);
        fragmentOrganizer.openFragment(HomeViewFragment.newInstance(""));
        break;
      case R.id.menu_categories:
        fragmentOrganizer.openFragment(CategoryViewFragment.newInstance());
        break;
      case R.id.menu_account:
        fragmentOrganizer.openFragment(AccountViewFragment.newInstance());
        break;
      case R.id.menu_setting:
        fragmentOrganizer.openFragment(SettingsViewFragment.newInstance());
        break;
    }
    drawerLayout.closeDrawer(GravityCompat.START);
    return true;
  }
}
