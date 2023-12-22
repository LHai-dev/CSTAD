package com.testSSE.SSE.asynchronousRequests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class NotificationController {

    @Autowired
    private EmailSenderTask emailSenderTask;

    @GetMapping({"asyncTask/", "asyncTask/{count}"})
    public String testAsync(@PathVariable("count")Optional<Integer> count){
        System.out.println("Start test Async - " +Thread.currentThread().getName());
        emailSenderTask.sendEmail(prepareEmailList(count.isPresent() ? count.get() : 1));
        System.out.println("End Test Async - "+Thread.currentThread().getName());
        return "Test Async";
    }
    private List<String> prepareEmailList(int n){
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < n ;i++){
            emails.add("test"+i+"@gmail.com");
        }
        return emails;
    }


}
