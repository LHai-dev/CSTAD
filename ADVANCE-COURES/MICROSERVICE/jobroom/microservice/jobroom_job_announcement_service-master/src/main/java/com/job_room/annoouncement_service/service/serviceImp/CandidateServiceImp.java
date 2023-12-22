package com.job_room.annoouncement_service.service.serviceImp;

import com.job_room.annoouncement_service.model.candidate.Candidate;
import com.job_room.annoouncement_service.model.candidate.CandidateDto;
import com.job_room.annoouncement_service.model.candidate.CandidateEmployee;
import com.job_room.annoouncement_service.repository.CandidateRepository;
import com.job_room.annoouncement_service.rest.message.BaseApiResponse;
import com.job_room.annoouncement_service.service.AnnouncementService;
import com.job_room.annoouncement_service.service.CandidateService;
import com.job_room.annoouncement_service.utils.PaginationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class CandidateServiceImp implements CandidateService {
    private CandidateRepository candidateRepository;
    private ModelMapper modelMapper = new ModelMapper();
    private RestTemplate restTemplate;
    private AnnouncementService announcementService;
    HttpHeaders headers;
    HttpEntity<String> entity;

    @Autowired
    public void setAnnouncementService(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setCandidateRepository(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    //TODO: Insert Candidate =========================================================
    @Override
    public CandidateDto insert(CandidateDto candidateDto) throws ParseException{

        candidateDto.setStatus(true);
        Candidate candidate = modelMapper.map(candidateDto, Candidate.class);
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
        String formattedDate= dateFormat.format(date);
        candidate.setAppliesDate(new Timestamp(System.currentTimeMillis()));


        if(announcementService.findById(candidateDto.getAnnouncementId()) ==null){
            return null;
        }

        if(selectEmployeeById(candidateDto.getEmployeeId()) == null){
            return null;
        }

        Candidate isInserted = candidateRepository.save(candidate);

        if (isInserted == null) {
            return null;
        } else{
            candidateDto.setAppliesDate(formattedDate);
            return candidateDto;
        }

    }

    //TODO: Delete Candidate =========================================================
    @Override
    public CandidateDto delete(int id) {
        Candidate candidate = candidateRepository.findByIdAndStatusIsTrue(id);

        if (candidate == null)
            return null;

        candidate.setStatus(false);
        candidateRepository.save(candidate);

        CandidateDto candidateDto = modelMapper.map(candidate, CandidateDto.class);

        return candidateDto;
    }

    ///TODO: Select Candidate by id =========================================================
    @Override
    public CandidateDto selectById(int id) {
        Candidate candidate = candidateRepository.findByIdAndStatusIsTrue(id);

        if (candidate == null)
            return null;

        CandidateDto candidateDto = modelMapper.map(candidate, CandidateDto.class);

        return candidateDto;
    }
    ///TODO: Select All Candidate  =========================================================
    @Override
    public Page<CandidateDto> selectAll(Pageable pageable) {

        Page<Candidate> candidates = candidateRepository.findAllByStatusIsTrue(pageable);

        PaginationUtils<CandidateDto, Page<Candidate>> paging = new PaginationUtils<>(CandidateDto.class);
        paging.setData(candidates);
        Page<CandidateDto> candidateDtos = paging;


        return candidateDtos;
    }

    ///TODO Consume Employee
    @Override
    public CandidateEmployee selectEmployeeById(int id) {
        ParameterizedTypeReference<BaseApiResponse<CandidateEmployee>> parameterizedTypeReference =
                new ParameterizedTypeReference<BaseApiResponse<CandidateEmployee>>() {
                };
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<BaseApiResponse<CandidateEmployee>> result = restTemplate.exchange("http://localhost:8082/api/v1/employees/" + id, HttpMethod.GET, entity, parameterizedTypeReference);
        if (result.getBody().getData() != null) {
            return result.getBody().getData();
        } else {
            return null;
        }
    }

    @Override
    public int countCandidatesByAnnouncement(int id) {
        return candidateRepository.countCandidateByAnnouncementId(id);
    }
    ///TODO Search By Employee Name (Consume)
    @Override
    public List<CandidateEmployee> searchByEmployeeName(String employeeName) {
        return null;
    }

    ///TODO Filter Candidate By AnnouncementId
    @Override
    public Page<CandidateDto> filterCandidateByAnnouncementId(int announcementId,Pageable pageable) {
        Page<Candidate> candidates=candidateRepository.findAllByAnnouncementIdAndStatusIsTrue(announcementId,pageable);

        PaginationUtils<CandidateDto, Page<Candidate>> paging = new PaginationUtils<>(CandidateDto.class);
        paging.setData(candidates);
        Page<CandidateDto> candidateDtos = paging;


        return candidateDtos;
    }

    ///TODO Filter By Date
    @Override
    public Page<CandidateDto> findAllByAppliesDateBetween(Date startDate, Date endDate,Pageable pageable) {

        Page<Candidate> candidates=candidateRepository.findAllByAppliesDateBetween(startDate,endDate,pageable);
        PaginationUtils<CandidateDto, Page<Candidate>> paging = new PaginationUtils<>(CandidateDto.class);
        paging.setData(candidates);
        Page<CandidateDto> candidateDtos = paging;
        return candidateDtos;

    }
}
