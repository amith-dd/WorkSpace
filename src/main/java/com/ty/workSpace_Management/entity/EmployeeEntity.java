package com.ty.workSpace_Management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Entity
@Data
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@GenericGenerator(name = "employee_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Employee_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String employeeId;
	@NotNull(message = "employee name cannot be null")
	@NotBlank(message = "employee name cannot be blank")
	private String employeeName;
	@Column(unique = true)
	@Email(message = "email must be valid")
	private String employeeEmail;
	@Min(value= 6000000000l, message = " phone number must be valid" )
	@Max(value= 9999999999l, message = " phone number must be valid" )
	private long employeePhone;
	@NotBlank(message = "Password is required")
	@Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
	@Pattern(regexp ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "must contain at least one letter, one number, one special character")
	private String employeePassword;
	@NotNull(message = "employee role cannot be null")
	@NotBlank(message = "employee role cannot be blank")
	private String employeeRole;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressEntity address;
}
