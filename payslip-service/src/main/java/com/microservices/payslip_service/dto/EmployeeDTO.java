package com.microservices.payslip_service.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Long id;
    private String name;
    private String department;
    private String designation;
    private double basicSalary;
    private double hraPercent;
    private double daPercent;
    private double pfPercent;
    private String email;
}