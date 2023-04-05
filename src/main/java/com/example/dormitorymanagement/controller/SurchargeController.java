package com.example.dormitorymanagement.controller;

import com.example.dormitorymanagement.entity.Account;
import com.example.dormitorymanagement.entity.Employee;
import com.example.dormitorymanagement.entity.Surcharge;
import com.example.dormitorymanagement.service.SurchargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/surcharge")
public class SurchargeController {
    @Autowired
    private SurchargeService surchargeService;

    @GetMapping("/showSurchargeAddForm")
    public String showSurchargeAddForm(Model model){
        Surcharge surcharge = new Surcharge();
        model.addAttribute("surcharge", surcharge);
        model.addAttribute("title", "THÊM MỚI PHỤ PHÍ");
        return "SurchargeForm";
    }

    @PostMapping("/saveSurcharge")
    public String saveSurcharge(@ModelAttribute("surcharge") Surcharge surcharge) {
        surchargeService.saveSurcharge(surcharge);
        return "redirect:/surcharge/showSurchargeList";
    }

    @GetMapping("/showSurchargeList")
    public String showSurchargeList(Model model){
        List<Surcharge> surchargeList = surchargeService.getAllSurcharge();
        model.addAttribute("surchargeList", surchargeList);
        model.addAttribute("title", "QUẢN LÝ PHỤ PHÍ");
        return "Surcharges";
    }
    @GetMapping("/showSurchargeUpdateForm/{id}")
    public String showSurchargeUpdateForm(@PathVariable(value="id") String id, Model model){
        Surcharge surcharge = surchargeService.getSurchargeById(Integer.valueOf(id));
        model.addAttribute("surcharge", surcharge);
        model.addAttribute("title", "CẬP NHẬT PHỤ PHÍ");
        return "SurchargeForm";
    }

    @GetMapping("/deleteSurcharge/{id}")
    public String deleteSurcharge(@PathVariable(value="id") String id){
        this.surchargeService.deleteSurchargeById(Integer.valueOf(id));
        return "redirect:/surcharge/showSurchargeList";
    }

    @GetMapping("/showSurchargeFilterList")
    @ResponseBody
    public List<Surcharge> showSurchargeFilterList(Model model,@RequestParam String keyword){
        List<Surcharge> surchargeList = null;
        if(!keyword.equals("")){
            surchargeList = surchargeService.filterAllSurchargeByName(keyword);
        } else {
            surchargeList = surchargeService.getAllSurcharge();
        }
        model.addAttribute("surchargeList", surchargeList);
        model.addAttribute("title", "QUẢN LÝ PHỤ PHÍ");
        return surchargeList;
    }

}
