package com.job_room.annoouncement_service.service;

import com.job_room.annoouncement_service.model.candidate.CandidateDto;
import com.job_room.annoouncement_service.model.candidate.CandidateEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface CandidateService {

    //TODO: Insert Candidate =========================================================
    CandidateDto insert(CandidateDto candidateDto) throws ParseException;

    //TODO: Delete Candidate =========================================================
    CandidateDto delete(int id);

    ///TODO: Select Candidate by id ==================================================
    CandidateDto selectById(int id);

    ///TODO: Select All ==============================================================
    Page<CandidateDto> selectAll(Pageable pageable);

    ///TODO Consume Employee ==========================================================
    CandidateEmployee selectEmployeeById(int id);

    ///TODO Filter Candidate By AnnouncementId
    Page<CandidateDto> filterCandidateByAnnouncementId(int announcementId,Pageable pageable);

    ///TODO Filter By Date
    Page<CandidateDto> findAllByAppliesDateBetween(Date startDate, Date endDate, Pageable pageable);

    ///TODO Count Candidates By Announcement ==========================================
    int countCandidatesByAnnouncement(int id);

    ///TODO Search By Employee Name (Consume) ==========================================
    List<CandidateEmployee> searchByEmployeeName(String employeeName);

}
