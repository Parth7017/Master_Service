package org.nexgen.master.service;

import org.nexgen.master.repository.HolidayCategoryRepository;
import org.nexgen.master.module.HolidayCategoryResponse;
import org.nexgen.schema.entity.HolidayCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayCategoryServiceImpl implements HolidayCategoryService {

    @Autowired
    private HolidayCategoryRepository holidayCategoryRepository;

    @Override
    public List<HolidayCategoryResponse> getActiveHolidayCategories() {

        List<HolidayCategory> activeCategories = holidayCategoryRepository.findAllByIsActiveTrue();

        return activeCategories.stream()
                .map(category -> new HolidayCategoryResponse(
                        category.getSid(),
                        category.getHolidayCategoryName()))
                .collect(Collectors.toList());
    }
}
