package com.job_room.annoouncement_service.repository;

import com.job_room.annoouncement_service.model.announcement.Announcement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {

    //For admin

    //TODO: Find all by company id and caption =========================================================
    Page<Announcement> findAllByCompanyIdAndCaptionContainingIgnoreCaseAndStatusIsTrue(int companyId,String caption, Pageable pageable);

    //For Job seekers

    //TODO: Find all by position and dates =========================================================
    Page<Announcement> findAllByPositionContainingAndClosedDateBetweenAndStatusIsTrueAndIsDraftIsFalseAndIsBannedIsFalse(String position, Date startDate, Date endDate, Pageable pageable);

    //For HR

    //TODO: Find all by position =========================================================
    Page<Announcement> findAllByPositionContainingAndStatusIsTrueAndIsDraftIsFalseAndIsBannedIsFalse(String position, Pageable pageable);

    //TODO: Find all draft =========================================================
    Page<Announcement> findAllByCompanyIdAndCaptionContainingIgnoreCaseAndStatusIsTrueAndIsDraftIsTrueAndIsBannedIsFalse(int id,String caption,Pageable pageable);

    //TODO: Find draft by position =========================================================
    Page<Announcement> findAllByCompanyIdAndPositionEqualsAndStatusIsTrueAndIsDraftIsTrueAndIsBannedIsFalse(int id,String position,Pageable pageable);

    //TODO: Find by id =========================================================
    Announcement findByIdAndStatusIsTrue(int id);

    //TODO: Find by caption and dates =========================================================
    Page<Announcement> findAllByCompanyIdAndCaptionContainingIgnoreCaseAndClosedDateIsLessThanEqualAndStatusIsTrue(int id,String caption,Date currentDate,Pageable pageable);

    //TODO: Find by position and dates =========================================================
    Page<Announcement> findAllByCompanyIdAndPositionEqualsAndClosedDateIsLessThanEqualAndStatusIsTrue(int id,String position,Date currentDate,Pageable pageable);

    //TODO: Find all positions =========================================================
    @Query(value = "SELECT a.position FROM Announcement as a WHERE a.companyId=:id AND a.status=true GROUP BY a.position")
    List<String> selectAllPosition(@Param("id")int id);

    //TODO: Find active announcement by position and date =========================================================
    Page<Announcement> findAllByCompanyIdAndPositionEqualsAndClosedDateGreaterThanAndStatusIsTrue(int id,String position,Date currentDate,Pageable pageable);

    //TODO: Find active announcement by caption and date =========================================================
    Page<Announcement> findAllByCompanyIdAndCaptionContainingIgnoreCaseAndClosedDateGreaterThanAndStatusIsTrue(int id,String caption,Date currentDate,Pageable pageable);

}
