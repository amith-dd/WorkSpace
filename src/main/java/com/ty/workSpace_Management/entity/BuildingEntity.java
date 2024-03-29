package com.ty.workSpace_Management.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Entity
@Data
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "building_seq")
	@GenericGenerator(name = "building_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Build_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
   private String buildingId;
	@NotBlank(message = "name cannot be blank")
	@NotNull(message = "name cannot be null")
	private String buildingName;
	private double rating;
	@OneToOne
	private ManagerEntity manager;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressEntity address;
	@OneToMany
	private List<ServiceEntity>service;
	@OneToMany
	private List<EmployeeEntity>employess;
	@OneToMany(cascade = CascadeType.ALL)
	private List<FloorEntity>floors;
	
}
