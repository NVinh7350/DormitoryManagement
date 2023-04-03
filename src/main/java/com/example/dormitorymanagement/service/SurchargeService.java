package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Surcharge;

import java.util.List;

public interface SurchargeService {
    public void saveSurcharge(Surcharge surcharge);

    public Surcharge getSurchargeById(int id);
    public List<Surcharge> getAllSurcharge();
    public List<Surcharge> filterAllSurchargeByName(String value);
    public void deleteSurchargeById(int id);
}
