package com.ty.workSpace_Management.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AddressEntity;
import com.ty.workSpace_Management.entity.EmployeeEntity;
import com.ty.workSpace_Management.entity.FloorEntity;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.ServiceEntity;

import lombok.Data;

@Component
@Data
public class BuildingDto {
	
	    private String buildingId;
		private String buildingName;
		private double rating;
		private ManagerEntity manager;
		private AddressEntity address;
		private List<ServiceEntity>service;
		private List<FloorEntity>floors;
		

}
