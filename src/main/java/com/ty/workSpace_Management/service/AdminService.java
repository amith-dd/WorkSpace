package com.ty.workSpace_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.AdminDao;
import com.ty.workSpace_Management.dto.AdminDto;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;

@Service
public class AdminService {
	@Autowired
	private AdminDao dao;
	
	public ResponseEntity<ResponseStructure<AdminDto>>saveAdmin(AdminEntity  admin){
		
		ResponseStructure<AdminDto> structure = new ResponseStructure<>();

        
		structure.setMessage("customer signup successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.CREATED);
		
		
	}

}
