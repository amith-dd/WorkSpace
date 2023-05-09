package com.ty.workSpace_Management.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.ty.workSpace_Management.entity.util.CustomIdGenerator;

import lombok.Data;

@Entity
@Data
public class AdminEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
	@GenericGenerator(name = "admin_seq", strategy = "com.ty.workSpace_Management.entity.util.CustomIdGenerator", parameters = {
			@Parameter(name = CustomIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomIdGenerator.VALUE_PREFIX_PARAMETER, value = "Admin_"),
			@Parameter(name = CustomIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String adminId;
	private String adminName;
	@Column(unique = true)
	private String adminEmail;
	private long adminPhone;
	private String adminPwd;
	@OneToOne(cascade = CascadeType.ALL)
	private AddressEntity address;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<BuildingEntity>buildings;
	
	
	

}
