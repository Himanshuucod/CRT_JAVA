package com.microservices.payslip_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "payslips")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payslip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private String employeeName;
    private String department;
    private String designation;

    @Column(name = "pay_month")
    private int month;

    @Column(name = "pay_year")
    private int year;

    private double basicSalary;
    private int totalWorkingDays;
    private int daysAttended;
    private double perDaySalary;
    private double earnedSalary;
    private double deductions;
    private double netSalary;
}