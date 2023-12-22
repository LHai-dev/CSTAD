package com.example.spring4mbankingapisasu.notification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Value;
@Builder
public record NotificationDto(@JsonProperty("included_segments")
                              String[] includedSegments ,
                              ContentDto content
                              ,@JsonProperty("app_id")
                              @Value("${onesignal.app-id}")
                              String appId) {
}
