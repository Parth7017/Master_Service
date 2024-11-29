package org.nexgen.master.repository;

import org.nexgen.schema.entity.MonthOfYearDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MonthOfYearDetailRepository extends JpaRepository<MonthOfYearDetail, Integer> {

   // List<MonthOfYearDetail> findAll();
}
