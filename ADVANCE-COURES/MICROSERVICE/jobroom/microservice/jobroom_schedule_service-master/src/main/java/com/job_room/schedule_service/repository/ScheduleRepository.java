package com.job_room.schedule_service.repository;

import com.job_room.schedule_service.model.schedule.Schedule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    Page<Schedule> findAllByHrIdAndStatus(int id,boolean status, Pageable pageable);
    Optional<Schedule> findByIdAndStatus(int id, boolean status);
}
