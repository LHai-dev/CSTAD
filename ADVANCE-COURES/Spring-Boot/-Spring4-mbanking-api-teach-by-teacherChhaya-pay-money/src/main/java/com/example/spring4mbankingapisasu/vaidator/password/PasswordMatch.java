package com.example.spring4mbankingapisasu.vaidator.password;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;




@Constraint(validatedBy = PasswordMatchConstraintValidtor.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE , ElementType.METHOD})
public @interface PasswordMatch {
    String message() default "The password is so weak.";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String password();
    String confirmedPassword();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
     @interface List {
        PasswordMatch[] value();
    }
}
