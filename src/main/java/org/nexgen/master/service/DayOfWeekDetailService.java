package org.nexgen.master.service;

import org.nexgen.master.module.DayOfWeekDetailResponse;
import java.util.List;

public interface DayOfWeekDetailService {
    List<DayOfWeekDetailResponse> getActiveDayOfWeekDetails();
}
