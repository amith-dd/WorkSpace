package com.ty.workSpace_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.ManagerDao;
import com.ty.workSpace_Management.dto.DtoConfig;
import com.ty.workSpace_Management.dto.ManagerDto;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.IdNotFoundByManager;
import com.ty.workSpace_Management.exception.LoginByManagerException;
import com.ty.workSpace_Management.exception.NoSuchElementFoundByManagerException;
@Service
public class ManagerService {
	@Autowired
	private ManagerDao dao;
	
	@Autowired
	private DtoConfig dto;
	
public ResponseEntity<ResponseStructure<ManagerDto>>saveManager(ManagerEntity  manager){
		
		ResponseStructure<ManagerDto> structure = new ResponseStructure<>();

        structure.setData(dto.getManager(dao.saveManager(manager)));
		structure.setMessage("manager signup successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<ManagerDto>>(structure, HttpStatus.CREATED);
			
	}
	
	
public ResponseEntity<ResponseStructure<ManagerDto>>updateManager(ManagerEntity  manager, String id){
	ManagerEntity db=dao.getManagerByID(id);
		 if(db!=null) {
		ResponseStructure<ManagerDto> structure = new ResponseStructure<>();
           
        
        structure.setData(dto.getManager( dao.updateManager(manager, id)));
		structure.setMessage("manager update successfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<ManagerDto>>(structure, HttpStatus.OK);
		 }	
		 throw new IdNotFoundByManager("id is not found for manager to update your profile");
	}
	
	
	







public ResponseEntity<ResponseStructure<ManagerDto>>getManagerByID( String id){
	ManagerEntity db=dao.getManagerByID(id);
	 if(db!=null) {
	ResponseStructure<ManagerDto> structure = new ResponseStructure<>();
       
    structure.setData(dto.getManager(db));
	structure.setMessage("manager found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<ManagerDto>>(structure, HttpStatus.OK);
	 }	
	 throw new IdNotFoundByManager("id is not found for manager to display the profile");
}



public ResponseEntity<ResponseStructure<ManagerDto>>getManagerByEmail( String email){
	ManagerEntity db=dao.getManagerByEmail(email);
	 if(db!=null) {
	ResponseStructure<ManagerDto> structure = new ResponseStructure<>();
       
    structure.setData(dto.getManager(db));
	structure.setMessage("manager found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<ManagerDto>>(structure, HttpStatus.OK);
	 }	
	 throw new NoSuchElementFoundByManagerException(email+" email is not found for manager to display the profile");
}



public ResponseEntity<ResponseStructure<ManagerDto>>loginManager( String email,String pwd){
	ManagerEntity db=dao.getManagerByEmail(email);
	 if(db!=null) {
	ResponseStructure<ManagerDto> structure = new ResponseStructure<>();
      if(db.getManagerPwd().equals(pwd)) {
    	  structure.setData(dto.getManager(db));
    		structure.setMessage("manager found successfully");
    		structure.setStatus(HttpStatus.OK.value());
    		return new ResponseEntity<ResponseStructure<ManagerDto>>(structure, HttpStatus.OK);
    	  
      }
    	 throw new LoginByManagerException("pls provide proper password "+pwd +" is incorrect"); 
 
	 }	
	 throw new NoSuchElementFoundByManagerException(email+" email is not found for manager to display the profile");
}


public ResponseEntity<ResponseStructure<ManagerEntity>>getManagerPwdByEmail( String email){
	ManagerEntity db=dao.getManagerByEmail(email);
	 if(db!=null) {
	ResponseStructure<ManagerEntity> structure = new ResponseStructure<>();
      
   structure.setData(db);
	structure.setMessage("manager found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<ManagerEntity>>(structure, HttpStatus.OK);
	 }	
	 throw new NoSuchElementFoundByManagerException(email+" email is not found for admin to display the profile");
}





}
