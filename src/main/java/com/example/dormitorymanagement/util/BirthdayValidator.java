package com.example.dormitorymanagement.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class BirthdayValidator implements ConstraintValidator<BirthdayContraint, Date> {
    int minAge;
    int maxAge;
    int age;
    int currentYear;
    int startYear;
    @Override
    public void initialize(BirthdayContraint constraintAnnotation) {
        this.minAge = constraintAnnotation.minAge();
        this.maxAge = constraintAnnotation.maxAge();
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext context) {
        LocalDate now = LocalDate.now();
        currentYear = now.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int age  = currentYear - calendar.get(calendar.YEAR);
        if(age > 18 && age < 120){
            return true;
        }
        return false;
    }
}
