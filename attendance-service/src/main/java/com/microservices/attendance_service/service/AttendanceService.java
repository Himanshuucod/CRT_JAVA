package com.microservices.attendance_service.service;

import com.microservices.attendance_service.model.Attendance;
import com.microservices.attendance_service.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendance(Long employeeId, int month, int year) {
        return attendanceRepository.findByEmployeeIdAndMonthAndYear(
                employeeId, month, year);
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
