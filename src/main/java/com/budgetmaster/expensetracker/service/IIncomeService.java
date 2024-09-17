package com.budgetmaster.expensetracker.service;

import com.budgetmaster.expensetracker.model.dto.IncomeDTO;

import java.util.List;

public interface IIncomeService {

    public IncomeDTO addIncome(IncomeDTO incomeDTO);

    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO);

    public void delete(Long id);

    List<IncomeDTO> getAllIncome();

}
