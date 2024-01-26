package com.ty.workSpace_Management.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AddressEntity;
import com.ty.workSpace_Management.entity.ClientBookingEntity;
import com.ty.workSpace_Management.entity.EmployeeDutyAssignEntity;

import lombok.Data;

@Data
@Component
public class ClientDto {
	
	private String clientId;
	private String clientName;
	private String clientEmail;

	private long clientPhone;
	private AddressEntity address;
	private List<ClientBookingEntity> booking;
	private List<EmployeeDutyAssignEntity> employeeDuty;
	 
	
}
