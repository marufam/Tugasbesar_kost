package com.pratamawijaya.androidmaterial.presentation.ui.home.view;

import com.pratamawijaya.androidmaterial.domain.model.Species;
import java.util.List;

/**
 * Created by pratama on 8/30/16.
 */
public class HomeContract {
  public interface View {
    void showLoading();

    void hideLoading();

    void showError();

    void setSpecies(List<Species> species);
  }

  public interface Presenter {
    void getListSpecies();
  }
}
