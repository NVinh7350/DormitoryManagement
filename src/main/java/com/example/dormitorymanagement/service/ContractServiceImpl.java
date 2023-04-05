package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.CheckInBill;
import com.example.dormitorymanagement.entity.Contract;
import com.example.dormitorymanagement.entity.Student;
import com.example.dormitorymanagement.repository.ContractRepository;
import com.example.dormitorymanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    private ContractRepository contractRepository;


    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract getContractId(Integer id) {
        Optional<Contract> optional = contractRepository.findById(id);
        Contract contract = null;
        if(optional.isPresent()){
            contract = optional.get();
        } else {
            throw  new RuntimeException("Employee not found for id ::"+id);
        }
        return contract;
    }
}
