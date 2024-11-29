package org.nexgen.master.service;

import org.nexgen.master.module.DayOfWeekDetailResponse;
import org.nexgen.master.repository.DayOfWeekDetailRepository;
import org.nexgen.schema.entity.DayOfWeekDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DayOfWeekDetailServiceImpl implements DayOfWeekDetailService {

    @Autowired
    private DayOfWeekDetailRepository dayOfWeekDetailRepository;

    @Override
    public List<DayOfWeekDetailResponse> getActiveDayOfWeekDetails() {

        List<DayOfWeekDetail> activeDetails = dayOfWeekDetailRepository.findAll();

        return activeDetails.stream()
                .map(detail -> new DayOfWeekDetailResponse(detail.getDayName().name(), detail.getDayShortName()))
                .collect(Collectors.toList());
    }
}
