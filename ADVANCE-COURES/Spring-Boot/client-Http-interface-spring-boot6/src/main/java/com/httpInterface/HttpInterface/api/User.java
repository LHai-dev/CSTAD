package com.httpInterface.HttpInterface.api;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public record User (

                         String name,
                         String email,
                         String address){


}
