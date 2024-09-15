package com.budgetmaster.expensetracker.converter;

import com.budgetmaster.expensetracker.model.dto.IncomeDTO;
import com.budgetmaster.expensetracker.model.entity.IncomeEntity;
import org.springframework.stereotype.Component;

@Component
public class IncomeConverter {
    public IncomeDTO toIncomeDTO(IncomeEntity incomeEntity){
        IncomeDTO incomeDTO = new IncomeDTO();
        incomeDTO.setId(incomeEntity.getId());
        incomeDTO.setSource(incomeEntity.getSource());
        incomeDTO.setAmount(incomeEntity.getAmount());
        incomeDTO.setDescription(incomeEntity.getDescription());
        incomeDTO.setDate(incomeEntity.getDate());
        incomeDTO.setUserId(incomeEntity.getUserEntity().getId());
        return incomeDTO;
    }
    public IncomeEntity toIncomeEntity(IncomeDTO incomeDTO){
        IncomeEntity incomeEntity = new IncomeEntity();
        incomeEntity.setSource(incomeDTO.getSource());
        incomeEntity.setAmount(incomeDTO.getAmount());
        incomeEntity.setDescription(incomeDTO.getDescription());
        incomeEntity.setDate(incomeDTO.getDate());
        return incomeEntity;
    }
}
