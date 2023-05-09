package com.ty.workSpace_Management.dao;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.repo.ManagerRepo;

@Repository
public class ManagerDao {
	
	private ManagerRepo repo;
	
	
	public ManagerEntity saveManager(ManagerEntity manager) {
	   return	repo.save(manager);
	}
	
	
	public ManagerEntity updateManager(ManagerEntity manager,String managerId) {
		 Optional<ManagerEntity> result = repo.findById(managerId);
         if(result.isPresent()) {
        	           
        	 ManagerEntity a=  result.get();
        	 manager.setManagerId(managerId);
           if(manager.getAddress()==null) {
        	   manager.setAddress(a.getAddress());
           }
           if(manager.getManagerEmail()==null) {
        	   manager.setManagerEmail(a.getManagerEmail());
           }
           if(manager.getManagerPwd()==null) {
        	   manager.setManagerPwd(a.getManagerPwd());
           }
           if(manager.getManagerName()==null) {
        	   manager.setManagerName(a.getManagerName());
           }
		              
		 
		 
	     return	repo.save(manager);
	    }
	    else
	    	return null;
	
	}
	public ManagerEntity deleteManager(String managerId) {
		 Optional<ManagerEntity> admin = repo.findById(managerId);
	      if(admin.isPresent()) {
	    	  repo.deleteById(managerId);
	    	  return  admin.get();
	      }
	      else
	    	  return null;
	}
	
	public ManagerEntity getManagerByID(String managerId) {
		      Optional<ManagerEntity> admin = repo.findById(managerId);
		      if(admin.isPresent()) {
		    	  return admin.get();
		      }
		      else
		    	  return null;
	}
	
	
	public ManagerEntity getManagerByEmail(String managerEmail) {
		ManagerEntity manager = repo.findManagerByEmail(managerEmail) ;
		      if(manager!=null) {
		    	  return manager;
		      }
		      else
		    	  return null;
		
	}
	
	
	

}
