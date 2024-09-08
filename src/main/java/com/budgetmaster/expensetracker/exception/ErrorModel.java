package com.budgetmaster.expensetracker.exception;

import lombok.Data;

@Data
public class ErrorModel {
	String message;
	String code;
}
