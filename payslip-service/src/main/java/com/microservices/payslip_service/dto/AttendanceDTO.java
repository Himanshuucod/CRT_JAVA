package com.microservices.payslip_service.dto;

import lombok.Data;

@Data
public class AttendanceDTO {
    private Long id;
    private Long employeeId;
    private int month;
    private int year;
    private int daysAttended;
}
