package com.ty.workSpace_Management.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.entity.ManagerEntity;

@Component
public class DtoConfig {
	
	@Autowired
	private AdminDto admin;
	
	@Autowired
	private ManagerDto manager;
	@Autowired
	private BuildingDto building;
	
	public AdminDto getAdmin(AdminEntity admin1) {
		 admin.setAddress(admin1.getAddress());
		 admin.setAdminPhone(admin1.getAdminPhone());
		 admin.setAdminName(admin1.getAdminName());
		 admin.setAdminId(admin1.getAdminId());
		 admin.setAdminEmail(admin1.getAdminEmail());
		 return admin;
		
	}
	
	
	public ManagerDto getManager(ManagerEntity manager1) {
		manager.setAddress(manager1.getAddress());
		manager.setManagerEmail(manager1.getManagerEmail());
		manager.setManagerId(manager1.getManagerId());
		manager.setManagerPhone(manager1.getManagerPhone());
		manager.setManagerName(manager1.getManagerName());
		return manager;
	}
	
	public BuildingDto getbuilding(BuildingEntity building1) {
		
		building.setBuildingId(building1.getBuildingId());
		building.setAddress(building1.getAddress());
		building.setBuildingName(building1.getBuildingName());
		building.setFloors(building1.getFloors());
		building.setManager(building1.getManager());
		building.setRating(building1.getRating());
		building.setService(building1.getService());
		return building;
	}
	
 
	
	
	

}
