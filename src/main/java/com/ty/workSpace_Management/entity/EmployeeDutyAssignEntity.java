package com.ty.workSpace_Management.entity;

import java.sql.Date;

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
public class EmployeeDutyAssignEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employeeDuty_seq")
	@GenericGenerator(name = "employeeDuty_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Duty_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String employeeDutyAssignId;
	private String employeeId;
	private Date startDate;
	private Date endDate;
	private String serviceType;

}
