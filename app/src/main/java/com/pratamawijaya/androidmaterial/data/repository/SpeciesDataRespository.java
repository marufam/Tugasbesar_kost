package com.pratamawijaya.androidmaterial.data.repository;

import com.pratamawijaya.androidmaterial.domain.model.Species;
import com.pratamawijaya.androidmaterial.domain.repository.SpeciesRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pratama on 8/30/16.
 */
public class SpeciesDataRespository implements SpeciesRepository {

  @Override public Species species(int id) {
    return null;
  }

  @Override public List<Species> speciesList() {
    List<Species> data = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      if (i % 2 == 0) {
        data.add(new Species(i, "Data " + i, "http://lorempixel.com/200/200/animals/"));
      } else {
        data.add(new Species(i, "Data " + i, "http://lorempixel.com/300/300/animals/"));
      }
    }
    return data;
  }
}
