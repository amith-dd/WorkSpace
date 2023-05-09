package com.ty.workSpace_Management.dto;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.ClientEntity;
import com.ty.workSpace_Management.entity.EmployeeEntity;

@Component
public class DtoConfig {
	
	@Autowired
	private AdminDto admin;
	@Autowired
	private ClientDto client;
	@Autowired
	private EmployeeDto employee;
	
	public AdminDto getAdmin(AdminEntity admin1) {
		 admin.setAddress(admin1.getAddress());
		 admin.setAdminPhone(admin1.getAdminPhone());
		 admin.setAdminName(admin1.getAdminName());
		 admin.setAdminId(admin1.getAdminId());
		 admin.setAdminEmail(admin1.getAdminEmail());
		 return admin;
		
	}
	
	public ClientDto clientEntityToDto(ClientEntity client1) {
		client.setAddress(client1.getAddress());
		client.setBooking(client1.getBookings());
		client.setClientId(client1.getClientId());
		client.setClientName(client1.getClientName());
		client.setClientPhone(client1.getClientPhone());
		client.setEmployeeDuty(client1.getEmployeeDuty());
		return client;
	}
	
	public EmployeeDto employeeEntityToDto(EmployeeEntity employee1) {
		employee.setAddress(employee1.getAddress());
		employee.setEmployeeEmail(employee1.getEmployeeEmail());
		employee.setEmployeeId(employee1.getEmployeeId());
		employee.setEmployeeName(employee1.getEmployeeName());
		employee.setEmployeeRole(employee1.getEmployeeRole());
		return employee;
	}
	
	
	

}
