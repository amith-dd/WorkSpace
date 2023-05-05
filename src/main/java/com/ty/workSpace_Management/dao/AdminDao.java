package com.ty.workSpace_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.repo.AdminRepo;

@Repository
public class AdminDao {
	
	@Autowired
	private AdminRepo repo;
	
	
	public AdminEntity saveAdmin(AdminEntity admin) {
	   return	repo.save(admin);
	}
	
	
	public AdminEntity updateAdmin(AdminEntity admin,String adminId) {
		 Optional<AdminEntity> result = repo.findById(adminId);
         if(result.isPresent()) {
        	           
           AdminEntity a=  result.get();
           admin.setAdminId(adminId);
           if(admin.getAddress()==null) {
        	   admin.setAddress(a.getAddress());
           }
          
        	   
           if(admin.getAdminEmail()==null) {
        	   admin.setAdminEmail(a.getAdminEmail());
           }
           if(admin.getAdminPwd()==null) {
        	   admin.setAdminPwd(a.getAdminPwd());
           }
           if(admin.getAdminName()==null) {
        	   admin.setAdminName(a.getAdminName());
           }
           if(admin.getAdminPhone()==0) {
        	   admin.setAdminPhone(a.getAdminPhone());
           }
		              
		 
		 
	     return	repo.save(admin);
	    }
	    else
	    	return null;
	
	}
	public AdminEntity deleteAdmin(String adminId) {
		 Optional<AdminEntity> admin = repo.findById(adminId);
	      if(admin.isPresent()) {
	    	  repo.deleteById(adminId);
	    	  return  admin.get();
	      }
	      else
	    	  return null;
	}
	
	public AdminEntity getAdminByID(String adminId) {
		      Optional<AdminEntity> admin = repo.findById(adminId);
		      if(admin.isPresent()) {
		    	  return admin.get();
		      }
		      else
		    	  return null;
	}
	
	
	public AdminEntity getAdminByEmail(String adminEmail) {
		AdminEntity admin = repo.findAdminByEmail(adminEmail) ;
		      if(admin!=null) {
		    	  return admin;
		      }
		      else
		    	  return null;
		
	}
	
	
	

}
