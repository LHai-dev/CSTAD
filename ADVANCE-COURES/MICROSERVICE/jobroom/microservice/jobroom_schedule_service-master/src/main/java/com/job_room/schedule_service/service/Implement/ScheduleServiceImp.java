package com.job_room.schedule_service.service.Implement;

import com.job_room.schedule_service.model.Dto.ScheduleDto;
import com.job_room.schedule_service.model.schedule.Schedule;
import com.job_room.schedule_service.model.reponse.ScheduleCandidate;
import com.job_room.schedule_service.repository.ScheduleRepository;
import com.job_room.schedule_service.rest.message.BaseApiResponse;
import com.job_room.schedule_service.service.ScheduleService;
import com.job_room.schedule_service.util.PaginationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

@Service
public class ScheduleServiceImp implements ScheduleService {
    private ScheduleRepository scheduleRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private RestTemplate restTemplate;
        HttpHeaders headers;
        HttpEntity<String> entity;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    //TODO: Insert Schedule =========================================================
    @Override
    public ScheduleDto insert(ScheduleDto scheduleDto) {

        Schedule schedule = modelMapper.map(scheduleDto, Schedule.class);
        schedule.setStatus(true);
        schedule.setUuid(UUID.randomUUID().toString());

        ScheduleDto scheduleDto1 = modelMapper.map(scheduleRepository.save(schedule), ScheduleDto.class);

        return scheduleDto1;
    }

    //TODO: Select all Schedule By Status =========================================================
    @Override
    public Page<ScheduleDto> selectAllByStatus(int id,int page, int pageSize) {

        Pageable pageable = PageRequest.of(page, pageSize);

        Page<Schedule> schedules = scheduleRepository.findAllByHrIdAndStatus(id,true,pageable);

        PaginationUtils<ScheduleDto, Page<Schedule>> paging = new PaginationUtils<>(ScheduleDto.class);
        paging.setData(schedules);

        Page<ScheduleDto> scheduleDtos = paging;

        return scheduleDtos;

    }

    //TODO: Delete Schedule =========================================================
    @Override
    public ScheduleDto delete(int id) {

        ScheduleDto scheduleDto = selectByIdAndStatus(id);

        if (scheduleDto != null) {

            Schedule schedule = modelMapper.map(scheduleDto, Schedule.class);
            schedule.setStatus(false);
            scheduleRepository.save(schedule);

            return scheduleDto;
        } else {
            return null;
        }
    }

    //TODO: Select Schedule By Id and Status =========================================================
    @Override
    public ScheduleDto selectByIdAndStatus(int id) {

        Optional<Schedule> schedule = scheduleRepository.findByIdAndStatus(id, true);
        ScheduleDto scheduleDto;

        if (schedule.isEmpty()) {
            return null;

        } else {
            scheduleDto = modelMapper.map(schedule.get(), ScheduleDto.class);
            return scheduleDto;
        }
    }

    //TODO: Update Schedule =========================================================
    @Override
    public ScheduleDto update(int id, ScheduleDto scheduleDto) {

        ScheduleDto scheduleDto1 = selectByIdAndStatus(id);

        if (scheduleDto1 != null) {

            scheduleDto1.setCandidateId(scheduleDto.getCandidateId());
            scheduleDto1.setHrId(scheduleDto.getHrId());
            scheduleDto1.setMeetingDate(scheduleDto.getMeetingDate());
            scheduleDto1.setPosition(scheduleDto.getPosition());
            scheduleDto1.setRemark(scheduleDto.getRemark());
            Schedule schedule = modelMapper.map(scheduleDto1, Schedule.class);
            scheduleRepository.save(schedule);

            return scheduleDto1;
        } else {
            return null;
        }

    }

    @Override
    public ScheduleCandidate selectCandidateById(int id) {

        ParameterizedTypeReference<BaseApiResponse<ScheduleCandidate>> scheduleCandidate =
                new ParameterizedTypeReference<BaseApiResponse<ScheduleCandidate>>() {
                };

        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<BaseApiResponse<ScheduleCandidate>> result = restTemplate.exchange("http://localhost:8082/api/v1/candidates/" + id, HttpMethod.GET, entity, scheduleCandidate);
        if(result.getBody().getData()==null)
            return null;
        return result.getBody().getData();
    }

    JavaMailSenderImpl mailSender;
    Properties properties;

    @Override
    public boolean notifyCandidate(String candidateEmail,String email,String password,String emailContent) throws MessagingException {

        setEmailProperties(email,password);

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        //helper.setSubject(subject);
        helper.setFrom(email);
        helper.setTo(candidateEmail);
        helper.setText(emailContent,true);


        mailSender.send(message);

        return true;
    }

    public void setEmailProperties(String email,String password){

        mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername(email);
        mailSender.setPassword(password);
        properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        mailSender.setJavaMailProperties(properties);
    }
}
