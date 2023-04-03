package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.CheckInBill;
import com.example.dormitorymanagement.repository.CheckInBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInBillServiceImpl implements CheckInBillService{
    @Autowired
    private CheckInBillRepository checkInBillRepository;
    @Override
    public void saveCheckInBill(CheckInBill checkInBill) {
        checkInBillRepository.save(checkInBill);
    }

    @Override
    public CheckInBill getCheckInBillById(int id) {
        CheckInBill checkInBill = checkInBillRepository.getReferenceById(id);
        return checkInBill;
    }

    @Override
    public List<CheckInBill> getAllCheckInBill() {
        List<CheckInBill> checkInBillList = checkInBillRepository.findAll();
        return checkInBillList;
    }

//    @Override
//    public List<CheckInBill> filterAllCheckInBillByName(String value) {
//        List<CheckInBill> checkInBillList = checkInBillRepository.
//        return null;
//    }

    @Override
    public void deleteCheckInBill(int id) {
        checkInBillRepository.deleteById(id);
    }
}
