package com.microservices.payslip_service.service;

import com.microservices.payslip_service.dto.AttendanceDTO;
import com.microservices.payslip_service.dto.EmployeeDTO;
import com.microservices.payslip_service.model.Payslip;
import com.microservices.payslip_service.repository.PayslipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PayslipService {

    @Autowired
    private PayslipRepository payslipRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String EMPLOYEE_URL = "http://localhost:8081/api/employees/";
    private static final String ATTENDANCE_URL = "http://localhost:8082/api/attendance/employee/";

    public Payslip generatePayslip(Long employeeId, int month, int year) {

        // Fetch employee details
        EmployeeDTO employee = restTemplate.getForObject(
                EMPLOYEE_URL + employeeId, EmployeeDTO.class);

        // Fetch attendance details
        AttendanceDTO attendance = restTemplate.getForObject(
                ATTENDANCE_URL + employeeId + "/month/" + month + "/year/" + year,
                AttendanceDTO.class);

        // Calculate salary
        int totalWorkingDays = 26;
        int daysAttended = attendance.getDaysAttended();
        double basicSalary = employee.getBasicSalary();
        double perDaySalary = basicSalary / totalWorkingDays;
        double earnedSalary = perDaySalary * daysAttended;
        double deductions = basicSalary - earnedSalary;
        double netSalary = earnedSalary;

        Payslip payslip = Payslip.builder()
                .employeeId(employeeId)
                .employeeName(employee.getName())
                .department(employee.getDepartment())
                .designation(employee.getDesignation())
                .basicSalary(basicSalary)
                .month(month)
                .year(year)
                .totalWorkingDays(totalWorkingDays)
                .daysAttended(daysAttended)
                .perDaySalary(perDaySalary)
                .earnedSalary(earnedSalary)
                .deductions(deductions)
                .netSalary(netSalary)
                .build();

        return payslipRepository.save(payslip);
    }

    public List<Payslip> getPayslipsByEmployee(Long employeeId) {
        return payslipRepository.findByEmployeeId(employeeId);
    }

    public List<Payslip> getAllPayslips() {
        return payslipRepository.findAll();
    }
}