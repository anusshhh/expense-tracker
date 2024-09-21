package com.budgetmaster.expensetracker.service.impl;

import com.budgetmaster.expensetracker.model.dto.AnalyticsDTO;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;
import com.budgetmaster.expensetracker.model.entity.IncomeEntity;
import com.budgetmaster.expensetracker.model.entity.UserEntity;
import com.budgetmaster.expensetracker.repository.ExpenseRepository;
import com.budgetmaster.expensetracker.repository.IncomeRepository;
import com.budgetmaster.expensetracker.repository.UserRepository;
import com.budgetmaster.expensetracker.service.IAnalyticsService;
import com.budgetmaster.expensetracker.utils.AuthenticationUtils;
import com.budgetmaster.expensetracker.utils.DateUtils;
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
    private final UserRepository userRepository;

    @Override
    public AnalyticsDTO findReportByMonth(int month, int year) {
        String username = AuthenticationUtils.getAuthenticatedUsername();
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow();

        LocalDate startDate = LocalDate.of(year,month,1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());

        List<IncomeEntity> monthlyIncome = incomeRepository.findByDateBetweenAndUserEntity(startDate,endDate,userEntity);
        List<ExpenseEntity> monthlyExpense = expenseRepository.findByDateBetweenAndUserEntity(startDate,endDate,userEntity);

        String period = DateUtils.getMonthNameAndYear(startDate);
        Double totalIncome = monthlyIncome.stream()
                .map(IncomeEntity::getAmount)
                .reduce(0.0,Double::sum);
        Double totalExpense = monthlyExpense.stream()
                .map(ExpenseEntity::getAmount)
                .reduce(0.0,Double::sum);
        Double netBalance = totalIncome - totalExpense;
        return new AnalyticsDTO(period,netBalance,totalIncome,totalExpense);
    }
}
