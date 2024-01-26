package com.ty.workSpace_Management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

	@NotBlank(message = "name cannot be blank")
	@NotNull(message = "name cannot be null")
	private String workSpaceType;

	@NotBlank(message = "name cannot be blank")
	@NotNull(message = "name cannot be null")
	private String workSpaceAvailability;
	@Min(value= 1, message = " workSpaceCapacity number must be valid" )
	@Max(value= 200, message = " workSpaceCapacity number must be valid" )
	private int workSpaceCapacity;
	@Positive
	private double workSpaceCost;

}
