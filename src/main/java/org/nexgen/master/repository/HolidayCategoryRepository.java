package org.nexgen.master.repository;

import org.nexgen.schema.entity.HolidayCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HolidayCategoryRepository extends JpaRepository<HolidayCategory, Integer> {
    List<HolidayCategory> findAllByIsActiveTrue();
}
