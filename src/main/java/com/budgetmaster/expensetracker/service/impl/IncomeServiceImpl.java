package com.budgetmaster.expensetracker.service.impl;

import com.budgetmaster.expensetracker.converter.IncomeConverter;
import com.budgetmaster.expensetracker.model.dto.IncomeDTO;
import com.budgetmaster.expensetracker.model.entity.CategoryEntity;
import com.budgetmaster.expensetracker.model.entity.ExpenseEntity;
import com.budgetmaster.expensetracker.model.entity.IncomeEntity;
import com.budgetmaster.expensetracker.model.entity.UserEntity;
import com.budgetmaster.expensetracker.repository.IncomeRepository;
import com.budgetmaster.expensetracker.repository.UserRepository;
import com.budgetmaster.expensetracker.service.IIncomeService;
import com.budgetmaster.expensetracker.utils.AuthenticationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IncomeServiceImpl implements IIncomeService {

    private final IncomeRepository incomeRepository;
    private final IncomeConverter incomeConverter;
    private final UserRepository userRepository;


    @Override
    public IncomeDTO addIncome(IncomeDTO incomeDTO) {
        String username = AuthenticationUtils.getAuthenticatedUsername();
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow();
        IncomeEntity incomeEntity = incomeConverter.toIncomeEntity(incomeDTO);
        incomeEntity.setUserEntity(userEntity);
        IncomeDTO savedIncomeDTO = incomeConverter.toIncomeDTO(incomeRepository.save(incomeEntity));
        return savedIncomeDTO;
    }

    @Override
    public IncomeDTO editIncome(Long id, IncomeDTO incomeDTO) {
        IncomeEntity existingIncomeRecord = incomeRepository.findById(id).orElseThrow();
        IncomeEntity updatedIncome = incomeConverter.toIncomeEntity(incomeDTO);
        updatedIncome.setId(existingIncomeRecord.getId());
        incomeRepository.save(updatedIncome);
        return incomeConverter.toIncomeDTO(updatedIncome);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<IncomeDTO> getAllIncome() {
        return List.of();
    }
}
