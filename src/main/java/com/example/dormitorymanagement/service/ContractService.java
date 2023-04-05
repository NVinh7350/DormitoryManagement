package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.CheckInBill;
import com.example.dormitorymanagement.entity.Contract;

import java.util.Date;
import java.util.List;

public interface ContractService {

    public void saveContract(Contract contract);

    public List<Contract> getAll();

    public Contract getContractId(Integer id);

}
