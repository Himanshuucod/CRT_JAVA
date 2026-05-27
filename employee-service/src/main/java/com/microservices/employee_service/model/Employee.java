package com.microservices.employee_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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