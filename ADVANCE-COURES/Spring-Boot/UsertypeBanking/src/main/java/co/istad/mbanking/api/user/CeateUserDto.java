package co.istad.mbanking.api.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CeateUserDto(@NotBlank String name , String one_signal,@NotBlank String gender, String studentCard, @NotNull Boolean isStudent) {
}
