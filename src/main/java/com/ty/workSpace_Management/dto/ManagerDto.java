package com.ty.workSpace_Management.dto;


import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AddressEntity;

import lombok.Data;

@Data
@Component
public class ManagerDto {
	
	 private String managerId;
		private String managerName;
		private String managerEmail;
		private long managerPhone;
		private AddressEntity address;

}
