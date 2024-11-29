package org.nexgen.master.repository;

import org.nexgen.schema.entity.GeoCountries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoCountriesRepository extends JpaRepository<GeoCountries, Integer> {
    List<GeoCountries> findAllByIsActiveTrue();
}
