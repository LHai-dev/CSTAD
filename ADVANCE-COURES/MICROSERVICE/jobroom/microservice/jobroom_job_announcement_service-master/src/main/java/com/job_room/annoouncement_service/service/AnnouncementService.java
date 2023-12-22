package com.job_room.annoouncement_service.service;

import com.job_room.annoouncement_service.model.announcement.AnnouncementDto;
import com.job_room.annoouncement_service.model.consume_model.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Date;
import java.util.List;


public interface AnnouncementService {

    //For admin

    //TODO: Select announcements by company =========================================================
    Page<AnnouncementDto> selectAnnouncementsByCompany(int companyId,String caption, Pageable pageable);

    //TODO: Ban announcement =========================================================
    AnnouncementDto ban(int id);

    //TODO: Unban announcement =========================================================
    AnnouncementDto unban(int id);


    //For Job seeker

    //TODO: Select all announcements by position and range of dates =========================================================
    Page<AnnouncementDto> selectAllByPositionAndDates(String position, Date startDate, Date endDate, Pageable pageable);

    //For HR

    //TODO: Select  announcement =========================================================
    Page<AnnouncementDto> findAllByPosition(String position, Pageable pageable);

    //TODO: Select draft announcement by Company =========================================================
    Page<AnnouncementDto> selectDraft(int id,String caption,Pageable pageable);

    //TODO Select Draft announcement By companyId and Position
    Page<AnnouncementDto> selectDraftByCompanyAndPosition(int id,String position,Pageable pageable);

    ///TODO: Select announcement by id =========================================================
    AnnouncementDto selectById(int id);

    //TODO: Insert announcement =========================================================
    AnnouncementDto insert(AnnouncementDto announcementDto) throws ParseException;

    //TODO: Delete announcement =========================================================
    AnnouncementDto delete(int id);

    //TODO: Update announcement =========================================================
    AnnouncementDto update(AnnouncementDto announcementDto) throws ParseException;

    //TODO: Share announcement =========================================================
    AnnouncementDto share(int id);

    //TODO: Unshare announcement =========================================================
    AnnouncementDto unshare(int id);

    //TODO: Draft announcement =========================================================
    AnnouncementDto draft(int id);

    //TODO: Unshare announcement =========================================================
    AnnouncementDto undraft(int id);

    // TODO select Announcement with close date(Close Announcement)
    Page<AnnouncementDto> findAllByCompanyIdAndClosedDate(int id,String caption,Date currentDate,Pageable pageable);

    //TODO select all position
    List<String> selectAllPosition(int id);

    //TODO filter active Announcement By Company and Position
    Page<AnnouncementDto> filterActiveAnnouncementByCompanyIdAndPosition(int id,String position,Date currentDate,Pageable pageable);

    ///TODO select Active Announcement
    Page<AnnouncementDto> selectActiveAnnouncementByCompanyId(int id,String caption,Date currentDate,Pageable pageable);

    //TODO filter close announcement by company and position
    Page<AnnouncementDto> filterCloseAnnouncementByCompanyIdAndPosition(int id,String position,Date currentDate,Pageable pageable);

    //TODO find announcements by id
    AnnouncementDto findById(int id);

    //TODO consume company
    Company companyById(int id);
}
