package com.budgetmaster.expensetracker.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter MONTH_YEAR_FORMATTER = DateTimeFormatter.ofPattern("MMMM yyyy");

    private DateUtils() {
        // Private constructor to prevent instantiation
    }

    public static String getMonthNameAndYear(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        return date.format(MONTH_YEAR_FORMATTER);
    }
}
