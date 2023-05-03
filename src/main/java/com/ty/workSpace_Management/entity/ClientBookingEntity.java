package com.ty.workSpace_Management.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Entity
@Data
public class ClientBookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientbooking_seq")
	@GenericGenerator(name = "clientbooking_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Client_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	private LocalDate startDate;
	private LocalDate endDate;
	private double cost;
	@OneToMany
	private List<WorkSpaceEntity> workspaces;
	private double rating;
	
}
