package com.example.spring4mbankingapisasu.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationServiceImpl implements NotificationService{

    @Value("${onesignal.rest-api-key}")
        private String restApiKey;

    @Value("${onesignal.app-id}")
    private String appId;

private RestTemplate restTemplate;
@Autowired
public void setRestTemplate(RestTemplate restTemplate){
    this.restTemplate = restTemplate;
}
    @Override
    public Boolean pushNotification(CreateNotificationDto notificationDto) {
//        OkHttpClient client = new OkHttpClient();

//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{\"included_segments\":[\"Subscribed Users\"],\"contents\":{\"en\":\"English or Any Language Message\",\"es\":\"Spanish Message\"},\"name\":\"INTERNAL_CAMPAIGN_NAME\"}");
//        Request request = new Request.Builder()
//                .url("https://onesignal.com/api/v1/notifications")
//                .post(body)
//                .addHeader("accept", "application/json")
//                .addHeader("Authorization", "Basic YOUR_REST_API_KEY")
//                .addHeader("content-type", "application/json")
//                .build();
//
//        Response response = client.newCall(request).execute();
//    }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("accept", "application/json");
        httpHeaders.set("Authorization", "Basic "+restApiKey);
        httpHeaders.set("content-type", "application/json");
        NotificationDto body = NotificationDto.builder()
                .appId(appId)
                .includedSegments(NotificationDto.builder().build().includedSegments())
                .content(NotificationDto.builder().build().content())
                .build();
        HttpEntity<NotificationDto> requestBoday = new HttpEntity<>(body,httpHeaders);



 ResponseEntity<?> response =  restTemplate.postForEntity("https://onesignal.com/api/v1/notifications",requestBoday , NotificationDto.class);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        return false;
}}
