package com.resoureserver.productserver.controller;

import com.resoureserver.productserver.dto.OrderDto;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class HomeController {

    @GetMapping("/status-home")
//    @PreAuthorize("hasAuthority('SCOPE_OPENID')")
    public String home(){
        return "https://beebom.com/wp-content/uploads/2022/11/gojo-and-geto-friendship.jpg?w=750&quality=75";
    }
    @GetMapping("/order")
//    @PreAuthorize("hasAnyAuthority('SCOPE_user.read')")
    public List<OrderDto> getOrder(){
        return List.of(
             new  OrderDto(
                        UUID.randomUUID(),
                        "Iphone XS MAX"
                )
        );
    }

    @PostMapping("/order")
//    @PreAuthorize("hasAuthority('_user.read')")
    public UUID createOrder(@RequestBody String orderType){
        return UUID.randomUUID();
    }

}
