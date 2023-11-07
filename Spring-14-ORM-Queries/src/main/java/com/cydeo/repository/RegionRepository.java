package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    // Display all regions in Canada
    List<Region> findByCountry(String country);  // select * from region where country is ...

    // Display all regions in Canada, without duplicates
    List<Region> findDistinctByCountry(String country);

    // Display all regions where country name includes 'United'
    List<Region> findByCountryContaining(String country);

    // Display all regions where country name includes "Asia" in order
    List<Region> findByCountryContainingOrderByCountry(String country);

    // Display top 2 regions in Canada
    List<Region> findTop2ByCountry(String country);
}
