package com.ty.workSpace_Management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Entity
@Data
public class WorkSpaceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workSpace_seq")
	@GenericGenerator(name = "workSpace_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "workSpace_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String workSpaceId;

	private String workSpaceType;

	private String workSpaceAvailability;
	private int workSpaceCapacity;
	private double workSpaceCost;

}
