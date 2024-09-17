package com.budgetmaster.expensetracker.service.impl;

import com.budgetmaster.expensetracker.model.dto.AnalyticsDTO;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;
import com.budgetmaster.expensetracker.model.entity.IncomeEntity;
import com.budgetmaster.expensetracker.repository.ExpenseRepository;
import com.budgetmaster.expensetracker.repository.IncomeRepository;
import com.budgetmaster.expensetracker.service.IAnalyticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsServiceImpl implements IAnalyticsService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    @Override
    public AnalyticsDTO getMonthlyExpenseSummary(int month, int year) {
        LocalDate startDate = LocalDate.of(year,month,1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        List<IncomeEntity> monthlyIncome = incomeRepository.findByDateBetween(startDate,endDate);
        List<ExpenseEntity> monthlyExpense = expenseRepository.findByDateBetween(startDate,endDate);

        System.out.println(monthlyExpense + " " +monthlyIncome);
        return null;
    }
}
