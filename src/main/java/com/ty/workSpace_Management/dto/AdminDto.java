package com.ty.workSpace_Management.dto;

import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AddressEntity;

import lombok.Data;
@Data
@Component
public class AdminDto {
	
	private String adminId;
	private String adminName;
	private String adminEmail;
	private long adminPhone;
	
	private AddressEntity address;
	

}
