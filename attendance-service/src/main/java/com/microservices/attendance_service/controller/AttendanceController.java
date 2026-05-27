package com.microservices.attendance_service.controller;

import com.microservices.attendance_service.model.Attendance;
import com.microservices.attendance_service.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Save attendance
    @PostMapping
    public ResponseEntity<Attendance> saveAttendance(@RequestBody Attendance attendance) {
        return ResponseEntity.ok(attendanceService.saveAttendance(attendance));
    }

    // Get all attendance records
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }

    // Get attendance by employeeId, month, year
    @GetMapping("/employee/{employeeId}/month/{month}/year/{year}")
    public ResponseEntity<Attendance> getAttendance(
            @PathVariable Long employeeId,
            @PathVariable int month,
            @PathVariable int year) {

        return attendanceService.getAttendance(employeeId, month, year)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get attendance by id
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete attendance
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }
}