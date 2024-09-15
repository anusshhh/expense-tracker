package com.budgetmaster.expensetracker.model.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class IncomeDTO {
	private Long id;
    private String source;
    private Double amount;
    private String description;
    private LocalDateTime date;
    private Long userId;
}
