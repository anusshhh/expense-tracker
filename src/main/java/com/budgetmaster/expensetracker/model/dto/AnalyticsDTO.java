package com.budgetmaster.expensetracker.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsDTO {
    private String period;
    private Double netBalance;
    private Double totalIncome;
    private Double totalExpenses;
}
