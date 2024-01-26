package com.ty.workSpace_Management.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Entity
@Data
public class ServiceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "service_seq")
	@GenericGenerator(name = "service_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Service_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String serviceId;
	@NotBlank(message = "name cannot be blank")
	@NotNull(message = "name cannot be null")
	private String serviceName;

}
