package com.microservices.payslip_service.controller;

import com.microservices.payslip_service.model.Payslip;
import com.microservices.payslip_service.service.PayslipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payslip")
@CrossOrigin(origins = "*")
public class PayslipController {

    @Autowired
    private PayslipService payslipService;

    @PostMapping("/generate/{employeeId}/month/{month}/year/{year}")
    public ResponseEntity<Payslip> generatePayslip(
            @PathVariable Long employeeId,
            @PathVariable int month,
            @PathVariable int year) {
        return ResponseEntity.ok(
                payslipService.generatePayslip(employeeId, month, year));
    }

    @GetMapping
    public ResponseEntity<List<Payslip>> getAllPayslips() {
        return ResponseEntity.ok(payslipService.getAllPayslips());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Payslip>> getPayslipsByEmployee(
            @PathVariable Long employeeId) {
        return ResponseEntity.ok(
                payslipService.getPayslipsByEmployee(employeeId));
    }
}