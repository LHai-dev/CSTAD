package com.job_room.schedule_service.components;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CommonUtils {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public Date getCurrentDate()  {
        try{
            Date date = new Date();
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            String strCurrentDate=formatter.format(date);
            System.out.println(strCurrentDate);
            Date currentDate=formatter.parse(strCurrentDate);
            return currentDate;
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return null;
        }

    }
    public String convertDateToString(Date date){
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        String strCurrentDate=formatter.format(date);
        return strCurrentDate;
    }
    public Date covertStringToDate(String strDate){
        try{
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            String strCurrentDate=formatter.format(strDate);
            Date date=formatter.parse(strDate);
            return date;
        }catch (ParseException e){
            System.out.println(e.getMessage());
            return  null;
        }

    }
}
