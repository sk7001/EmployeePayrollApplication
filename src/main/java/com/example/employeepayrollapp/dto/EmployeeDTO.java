package com.example.employeepayrollapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    @NotEmpty(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z ]{2,30}$", message = "Name must be 2-30 letters and spaces only")
    private String name;
    private double salary;
}
