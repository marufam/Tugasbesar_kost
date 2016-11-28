package com.pratamawijaya.androidmaterial.presentation.ui.home.presenter;

import com.pratamawijaya.androidmaterial.data.repository.SpeciesDataRespository;
import com.pratamawijaya.androidmaterial.presentation.ui.home.view.HomeContract;

/**
 * Created by pratama on 8/30/16.
 */
public class HomePresenter implements HomeContract.Presenter {

  private SpeciesDataRespository speciesDataRespository;
  private HomeContract.View view;

  public HomePresenter(SpeciesDataRespository speciesDataRespository, HomeContract.View view) {
    this.speciesDataRespository = speciesDataRespository;
    this.view = view;
  }

  @Override public void getListSpecies() {
    view.showLoading();
    view.setSpecies(speciesDataRespository.speciesList());
    view.hideLoading();
  }
}
