package com.ty.workSpace_Management.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Entity
@Data

public class ClientBookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientbooking_seq")
	@GenericGenerator(name = "clientbooking_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "BOOKING_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	private double cost;
	@OneToOne
	private WorkSpaceEntity workspaces;

	private double rating;
	
}
