package com.papei.movie_ticket_reservations.service.impl;

import com.papei.movie_ticket_reservations.model.DateRange;
import com.papei.movie_ticket_reservations.repository.DateRangeRepository;
import com.papei.movie_ticket_reservations.service.DateRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DateRangeServiceImpl implements DateRangeService {

    @Autowired
    private DateRangeRepository dateRangeRepository;

    public List<DateRange> getAllDateRanges() {
        return dateRangeRepository.findAll();
    }
}
