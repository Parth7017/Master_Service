package org.nexgen.master.service;

import org.nexgen.master.repository.MonthOfYearDetailRepository;
import org.nexgen.master.module.MonthOfYearDetailResponse;
import org.nexgen.schema.entity.MonthOfYearDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonthOfYearDetailServiceImpl implements MonthOfYearDetailService {

    @Autowired
    private MonthOfYearDetailRepository monthOfYearDetailRepository;

    @Override
    public List<MonthOfYearDetailResponse> getAllMonthOfYearDetails() {
        List<MonthOfYearDetail> activeMonthOfYearDetails = monthOfYearDetailRepository.findAll();

        return activeMonthOfYearDetails.stream()
                .map(monthDetail -> new MonthOfYearDetailResponse(
                        monthDetail.getMonthName().toString(),
                        monthDetail.getMonthShortName()))
                .collect(Collectors.toList());
    }
}
