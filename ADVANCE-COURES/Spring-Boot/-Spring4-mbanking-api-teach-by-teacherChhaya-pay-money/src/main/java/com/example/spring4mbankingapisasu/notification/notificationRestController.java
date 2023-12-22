package com.example.spring4mbankingapisasu.notification;

import com.example.spring4mbankingapisasu.base.BaseApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class notificationRestController {
    private final NotificationService notificationService;
    @PostMapping
    public BaseApi<?> pushNotification(@RequestBody CreateNotificationDto notificationDto){

        return null;
    }






}
