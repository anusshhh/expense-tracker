package com.budgetmaster.expensetracker.service;

import com.budgetmaster.expensetracker.model.dto.AnalyticsDTO;

import java.time.YearMonth;

public interface IAnalyticsService {
    public AnalyticsDTO getMonthlyExpenseSummary(int month,int year);
}
