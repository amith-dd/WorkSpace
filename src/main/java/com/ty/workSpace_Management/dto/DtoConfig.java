package com.ty.workSpace_Management.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AdminEntity;

@Component
public class DtoConfig {
	
	@Autowired
	private AdminDto admin;
	
	public AdminDto getAdmin(AdminEntity admin1) {
		 admin.setAddress(admin1.getAddress());
		 admin.setAdminPhone(admin1.getAdminPhone());
		 admin.setAdminName(admin1.getAdminName());
		 admin.setAdminId(admin1.getAdminId());
		 admin.setAdminEmail(admin1.getAdminEmail());
		 return admin;
		
	}
 
	
	
	

}
