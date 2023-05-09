package com.ty.workSpace_Management.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Component
@Entity
@Data
public class EmployeeDutyAssignEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeDuty_seq")
	@GenericGenerator(name = "employeeDuty_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Duty_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String employeeDutyAssignId;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	@NotBlank(message = "serviceType cannot be blank")
	@NotNull(message = "serviceType cannot be null")
	private String serviceType;

	@OneToMany
	private List<EmployeeEntity> employee;

}
