package com.henghai.productmanagement.api.image.web;

import com.henghai.productmanagement.api.image.ImageService;
import com.henghai.productmanagement.api.image.Images;
import com.henghai.productmanagement.api.order.Order;
import com.henghai.productmanagement.api.order.OrderService;
import com.henghai.productmanagement.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @GetMapping
    public BaseApi<?> orderGetAll(){
        List<ImageDto> image = imageService.getAll();
        return BaseApi.builder()
                .message("successfully")
                .data(image)
                .status(true)
                .timeStamp(LocalDateTime.now())
                .code(HttpStatus.OK.value())
                .build();
    }
}
