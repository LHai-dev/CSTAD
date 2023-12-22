package com.example.spring4mbankingapisasu.vaidator.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy =  PasswordConstraintValidtor.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD , ElementType.METHOD})
public @interface Password {
    String message() default "The password is so weak.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
