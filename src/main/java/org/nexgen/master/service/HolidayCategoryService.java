package org.nexgen.master.service;

import org.nexgen.master.module.HolidayCategoryResponse;
import java.util.List;

public interface HolidayCategoryService {
    List<HolidayCategoryResponse> getActiveHolidayCategories();

}
