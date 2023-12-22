package com.resoureserver.productserver.dto;

import java.util.UUID;

public record OrderDto(
        UUID orderId,
        String orderType
)
{

}
