package com.budgetmaster.expensetracker.controller;

import com.budgetmaster.expensetracker.model.dto.AnalyticsDTO;
import com.budgetmaster.expensetracker.service.IAnalyticsService;
import com.budgetmaster.expensetracker.service.impl.AnalyticsServiceImpl;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expense-tracker-api/v1/analytics")
@Validated
public class AnalyticsController {
	private final IAnalyticsService analyticsService;

	@GetMapping("/by-date")
	public ResponseEntity<AnalyticsDTO> getMonthlyReport(@RequestParam @Min(1) @Max(12) int month, @RequestParam @Min(2000) int year){
		AnalyticsDTO analyticsDTO = analyticsService.getMonthlyExpenseSummary(month,year);
		return ResponseEntity.ok(analyticsDTO);
	}


}
