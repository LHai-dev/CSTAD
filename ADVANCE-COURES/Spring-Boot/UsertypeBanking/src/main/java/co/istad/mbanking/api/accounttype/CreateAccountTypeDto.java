package co.istad.mbanking.api.accounttype;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


public record CreateAccountTypeDto(@NotBlank String name) {

}
