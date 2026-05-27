package com.microservices.attendance_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    @Column(name = "attend_month")
    private int month;

    @Column(name = "attend_year")
    private int year;

    private int daysAttended;
}