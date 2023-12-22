package com.example.spring4mbankingapisasu.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.*;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
@RequiredArgsConstructor
public class MailUtil {
    private  final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    @Builder
    @Setter
    @Getter
    @AllArgsConstructor
    public static class Meta<T>{
        private String to;
        private String from;
        private String subject;
        private String templateUrl;
        private T data;

    }
    public void sendMail(Meta<?> meta)throws MessagingException {
        //  MimeMessage mimeMessage = j

        MimeMessage mimeMessage= javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        // 1. Prepare template
        Context context = new Context();
        context.setVariable("meta",meta.data);
        String html = templateEngine.process(meta.templateUrl,context);
        helper.setText(html,true);
        // 2. Prepare email information
        helper.setTo(meta.to);
        helper.setFrom(meta.from);
        helper.setSubject(meta.subject);

        // 3. Send mail
        javaMailSender.send(mimeMessage);
    }

}
