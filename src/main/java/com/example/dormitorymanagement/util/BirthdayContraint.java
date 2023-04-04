package com.example.dormitorymanagement.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BirthdayValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface BirthdayContraint {
    String message() default "Vui lòng chọn lại ngày sinh!";
    int minAge() default 18;
    int maxAge() default 120;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
