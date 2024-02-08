package com.papei.movie_ticket_reservations.service;

import com.papei.movie_ticket_reservations.model.DateRange;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DateRangeService {
    public List<DateRange> getAllDateRanges();
}
