package com.microservices.attendance_service.repository;

import com.microservices.attendance_service.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Optional<Attendance> findByEmployeeIdAndMonthAndYear(
            Long employeeId, int month, int year);
}