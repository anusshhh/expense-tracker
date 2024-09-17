package com.budgetmaster.expensetracker.service.impl;

import com.budgetmaster.expensetracker.converter.IncomeConverter;
import com.budgetmaster.expensetracker.model.dto.IncomeDTO;
import com.budgetmaster.expensetracker.model.entity.IncomeEntity;
import com.budgetmaster.expensetracker.model.entity.UserEntity;
import com.budgetmaster.expensetracker.repository.IncomeRepository;
import com.budgetmaster.expensetracker.repository.UserRepository;
import com.budgetmaster.expensetracker.service.IIncomeService;
import com.budgetmaster.expensetracker.utils.AuthenticationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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
    public IncomeDTO updateIncome(Long id, IncomeDTO incomeDTO) {
        IncomeEntity existingIncomeRecord = incomeRepository.findById(id).orElseThrow();
        IncomeEntity updatedIncome = incomeConverter.toIncomeEntity(incomeDTO);
        updatedIncome.setId(existingIncomeRecord.getId());
        incomeRepository.save(updatedIncome);
        return incomeConverter.toIncomeDTO(updatedIncome);
    }

    @Override
    public void delete(Long id) {
        incomeRepository.deleteById(id);
    }

    @Override
    public List<IncomeDTO> getAllIncome() {
        String username = AuthenticationUtils.getAuthenticatedUsername();
        UserEntity userEntity = userRepository.findByEmail(username).orElseThrow();
        List<IncomeEntity> incomeEntities = incomeRepository.findByUserEntity(userEntity);
        return incomeEntities.stream()
                .map(incomeConverter::toIncomeDTO)
                .toList();
    }
}
