package com.example.dormitorymanagement.service;

import com.example.dormitorymanagement.entity.Surcharge;
import com.example.dormitorymanagement.repository.SurchargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurchargeServiceImpl implements SurchargeService {

    @Autowired
    private SurchargeRepository surchargeRepository;
    @Override
    public void saveSurcharge(Surcharge surcharge) {
        surchargeRepository.save(surcharge);
    }

    @Override
    public Surcharge getSurchargeById(int id) {
        Surcharge surcharge = this.surchargeRepository.getReferenceById(id);
        return surcharge;
    }

    @Override
    public List<Surcharge> getAllSurcharge() {
        List<Surcharge> surcharges = this.surchargeRepository.findAll();
        return surcharges;
    }

    @Override
    public List<Surcharge> filterAllSurchargeByName(String value) {
        List<Surcharge> surcharges = this.surchargeRepository.findAllBySurchargeNameIsContaining(value);
        return surcharges;
    }

    @Override
    public void deleteSurchargeById(int id) {
        this.surchargeRepository.deleteById(id);
    }
}
