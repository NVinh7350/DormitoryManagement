package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.CheckInBill;
import com.example.dormitorymanagement.entity.Surcharge;

import java.util.List;

public interface CheckInBillService {
    public void saveCheckInBill(CheckInBill checkInBill);

    public CheckInBill getCheckInBillById(int id);
    public List<CheckInBill> getAllCheckInBill();
//    public List<CheckInBill> filterAllCheckInBillByName(String value);
    public void deleteCheckInBill(int id);
}
