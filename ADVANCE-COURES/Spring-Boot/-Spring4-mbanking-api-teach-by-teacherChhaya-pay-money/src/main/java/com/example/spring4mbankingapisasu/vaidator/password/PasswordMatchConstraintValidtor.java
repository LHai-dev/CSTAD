package com.example.spring4mbankingapisasu.vaidator.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class PasswordMatchConstraintValidtor implements ConstraintValidator<PasswordMatch,Object> {

    private String message;
    private String password;
    private String confirmedPassword;
    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
        this.password=constraintAnnotation.password();
        this.confirmedPassword=constraintAnnotation.confirmedPassword();
        this.message=constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object passWordValue = new BeanWrapperImpl(value).getPropertyValue(password);
        Object confirmedPasswordValue = new BeanWrapperImpl(value).getPropertyValue(confirmedPassword);
        boolean isVaild = false;

        if(passWordValue != null){
            isVaild = passWordValue.equals(confirmedPasswordValue);
        }
        if (!isVaild){
            //send one message each time failed validation
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(password).addConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(confirmedPassword).addConstraintViolation();
        }
        return isVaild;
    }
}
