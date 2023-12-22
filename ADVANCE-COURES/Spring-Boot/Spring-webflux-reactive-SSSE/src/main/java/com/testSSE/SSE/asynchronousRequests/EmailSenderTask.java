package com.testSSE.SSE.asynchronousRequests;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailSenderTask {
    @Async
    void sendEmail(List<String> emailList){
        emailList.forEach(email ->
                {
                    try {
                        Thread.sleep(2000);
                        System.out.println("Sending email to - "+email+" \n by thread"+Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                );
    }
}
