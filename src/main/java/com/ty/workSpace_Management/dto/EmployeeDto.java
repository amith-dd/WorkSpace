package com.ty.workSpace_Management.dto;

import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AddressEntity;

import lombok.Data;

@Data
@Component
public class EmployeeDto {
	
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeeRole;
	private long employeePhone;
	private AddressEntity address;
}
