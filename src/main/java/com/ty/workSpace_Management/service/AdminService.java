package com.ty.workSpace_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.AdminDao;
import com.ty.workSpace_Management.dto.AdminDto;
import com.ty.workSpace_Management.dto.DtoConfig;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.IdNotFoundByAdmin;
import com.ty.workSpace_Management.exception.LoginByAdminException;
import com.ty.workSpace_Management.exception.NoSuchElementFoundByAdminException;

@Service
public class AdminService {
	@Autowired
	private AdminDao dao;
	
	@Autowired
	private DtoConfig dto;
	
	public ResponseEntity<ResponseStructure<AdminDto>>saveAdmin(AdminEntity  admin){
		
		ResponseStructure<AdminDto> structure = new ResponseStructure<>();

        structure.setData(dto.getAdmin(dao.saveAdmin(admin)));
		structure.setMessage("Admin signup successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.CREATED);
			
	}
	
	
public ResponseEntity<ResponseStructure<AdminDto>>updateAdmin(AdminEntity  admin, String id){
		 AdminEntity dbadmin=dao.getAdminByID(id);
		 if(dbadmin!=null) {
		ResponseStructure<AdminDto> structure = new ResponseStructure<>();
            if(admin.getBuildings()!=null) {
            	admin.setBuildings(dbadmin.getBuildings());
            }
        
        structure.setData(dto.getAdmin( dao.updateAdmin(admin, id)));
		structure.setMessage("Admin update successfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
		 }	
		 throw new IdNotFoundByAdmin("id is not found for admin to update your profile");
	}
	
	
	

public ResponseEntity<ResponseStructure<AdminDto>>deleteAdmin( String id){
	 AdminEntity dbadmin=dao.getAdminByID(id);
	 if(dbadmin!=null) {
	ResponseStructure<AdminDto> structure = new ResponseStructure<>();
        
    
    structure.setData(dto.getAdmin( dao.deleteAdmin(id)));
	structure.setMessage("Admin delete successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
	 }	
	 throw new IdNotFoundByAdmin("id is not found for admin to delete your profile");
}





public ResponseEntity<ResponseStructure<AdminDto>>getAdminByID( String id){
	 AdminEntity dbadmin=dao.getAdminByID(id);
	 if(dbadmin!=null) {
	ResponseStructure<AdminDto> structure = new ResponseStructure<>();
       
    structure.setData(dto.getAdmin( dbadmin));
	structure.setMessage("Admin found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
	 }	
	 throw new IdNotFoundByAdmin("id is not found for admin to display the profile");
}



public ResponseEntity<ResponseStructure<AdminDto>>getAdminByEmail( String email){
	 AdminEntity dbadmin=dao.getAdminByEmail(email);
	 if(dbadmin!=null) {
	ResponseStructure<AdminDto> structure = new ResponseStructure<>();
       
    structure.setData(dto.getAdmin( dbadmin));
	structure.setMessage("Admin found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
	 }	
	 throw new NoSuchElementFoundByAdminException(email+" email is not found for admin to display the profile");
}



public ResponseEntity<ResponseStructure<AdminDto>>login( String email,String pwd){
	 AdminEntity dbadmin=dao.getAdminByEmail(email);
	 if(dbadmin!=null) {
	ResponseStructure<AdminDto> structure = new ResponseStructure<>();
      if(dbadmin.getAdminPwd().equals(pwd)) {
    	  structure.setData(dto.getAdmin( dbadmin));
    		structure.setMessage("Admin found successfully");
    		structure.setStatus(HttpStatus.OK.value());
    		return new ResponseEntity<ResponseStructure<AdminDto>>(structure, HttpStatus.OK);
    	  
      }
    	 throw new LoginByAdminException("pls provide proper password "+pwd +" is incorrect"); 
 
	 }	
	 throw new NoSuchElementFoundByAdminException(email+" email is not found for admin to display the profile");
}


public ResponseEntity<ResponseStructure<AdminEntity>>getAdminPwdByEmail( String email){
	 AdminEntity dbadmin=dao.getAdminByEmail(email);
	 if(dbadmin!=null) {
	ResponseStructure<AdminEntity> structure = new ResponseStructure<>();
      
   structure.setData(dbadmin);
	structure.setMessage("Admin found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure<AdminEntity>>(structure, HttpStatus.OK);
	 }	
	 throw new NoSuchElementFoundByAdminException(email+" email is not found for admin to display the profile");
}
























	

}
