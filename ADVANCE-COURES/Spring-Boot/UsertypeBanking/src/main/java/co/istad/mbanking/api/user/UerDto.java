package co.istad.mbanking.api.user;

import lombok.Builder;

@Builder
public record UerDto(String name , String gender, String studentCard,boolean isStudent) {
}
