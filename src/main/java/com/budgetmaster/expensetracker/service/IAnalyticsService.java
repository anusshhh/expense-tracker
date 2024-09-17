package com.budgetmaster.expensetracker.service;

import com.budgetmaster.expensetracker.model.dto.AnalyticsDTO;

public interface IAnalyticsService {
    public AnalyticsDTO findReportByMonth(int month, int year);
}
