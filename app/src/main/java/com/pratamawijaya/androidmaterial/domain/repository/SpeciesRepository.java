package com.pratamawijaya.androidmaterial.domain.repository;

import com.pratamawijaya.androidmaterial.domain.model.Species;
import java.util.List;

/**
 * Created by pratama on 8/30/16.
 */
public interface SpeciesRepository {
  Species species(int id);

  List<Species> speciesList();
}
