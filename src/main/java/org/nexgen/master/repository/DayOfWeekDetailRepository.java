package org.nexgen.master.repository;

import org.nexgen.schema.entity.DayOfWeekDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DayOfWeekDetailRepository extends JpaRepository<DayOfWeekDetail, Integer> {

}
