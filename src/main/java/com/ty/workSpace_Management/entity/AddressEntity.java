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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Entity
@Data
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@GenericGenerator(name = "address_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Address_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String addressId;
	@Positive
	@ApiModelProperty(required = true)
	private int flatNumber;
	@NotNull(message = "street cannot be null")
	@NotBlank(message = "street cannot be blank")
	@ApiModelProperty(required = true)
	private String street;
	@NotNull(message = "state cannot be null")
	@NotBlank(message = "state cannot be blank")
	@ApiModelProperty(required = true)
	private String state;
	@Min(value= 110000, message = " pincode must be valid" )
	@Max(value= 990000, message = " pincode must be valid" )
	private int pincode;
	

}
