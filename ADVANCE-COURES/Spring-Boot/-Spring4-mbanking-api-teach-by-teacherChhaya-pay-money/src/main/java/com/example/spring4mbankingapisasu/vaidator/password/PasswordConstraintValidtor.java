package com.example.spring4mbankingapisasu.vaidator.password;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.passay.*;

import java.util.Arrays;

public class PasswordConstraintValidtor implements ConstraintValidator<Password, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator passwordValidator = new PasswordValidator(
                Arrays.asList(
                        new LengthRule(6,15),
                        new CharacterRule(EnglishCharacterData.UpperCase,1),
                        new CharacterRule(EnglishCharacterData.LowerCase, 1),

                        //At least one number
                        new CharacterRule(EnglishCharacterData.Digit, 1),

                        //At least one special characters
                        new CharacterRule(EnglishCharacterData.Special, 1),

                        new WhitespaceRule()

                )
        );
        // អនុវត្ដ validation follow password pattern
        RuleResult result = passwordValidator.validate(new PasswordData(password));

        if (result.isValid())
            return true;

        // Sending one message each time failed validation.
        context.buildConstraintViolationWithTemplate(passwordValidator.getMessages(result).stream().findFirst().get())
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
