package com.ty.workSpace_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.repo.BuildingRepo;

@Repository
public class BuildingDao {
	@Autowired
	private BuildingRepo repo;
	
	
	
	public BuildingEntity saveBuildingEntity(BuildingEntity building) {
		 return  repo.save(building);
	}
	
	

	public BuildingEntity updateBuilding(BuildingEntity building,String buildingID) {
		 Optional<BuildingEntity> result = repo.findById(buildingID);
         if(result.isPresent()) {
        	           
           BuildingEntity a=  result.get();
           building.setBuildingId(buildingID);
           if(building.getAddress()==null) {
        	   building.setAddress(a.getAddress());
           }
           
      
           if(building.getManager()==null) {
        	   building.setManager(a.getManager());
           }
           if(building.getEmployess()==null) {
        	   building.setEmployess(a.getEmployess());
           }
           if(building.getBuildingName()==null) {
        	   building.setBuildingName(a.getBuildingName());
           }
           if(building.getFloors()==null) {
        	   building.setFloors(a.getFloors());
           }
           if(building.getService()==null) {
        	   building.setService(a.getService());
           }
          building.setRating(a.getRating());
		              
		 
		 
	     return	repo.save(building);
	    }
	    else
	    	return null;
	
	}
	public BuildingEntity deleteBuilding(String adminId) {
		 Optional<BuildingEntity> admin = repo.findById(adminId);
	      if(admin.isPresent()) {
	    	  repo.deleteById(adminId);
	    	  return  admin.get();
	      }
	      else
	    	  return null;
	}
	
	public BuildingEntity getBuildingByID(String adminId) {
		      Optional<BuildingEntity> admin = repo.findById(adminId);
		      if(admin.isPresent()) {
		    	  return admin.get();
		      }
		      else
		    	  return null;
	}
	
	
	public List<BuildingEntity> listOfbuilingBasedOnRating(){
		List<BuildingEntity>list=repo.fingByRating();
		if(list!=null) {
			return list;
		}
		else
			return null;
	}
	
	
	public List<BuildingEntity>listOfBuilding(){
		List<BuildingEntity>list=repo.findAll();
		if(list!=null) {
			return list;
		}
		else
			return null;
	}
	
	public List<BuildingEntity>listOfBuildingBasedOnPincode(int pincode){
		List<BuildingEntity>list=repo.findBuilinglistBasedOnPin(pincode);
		if(list!=null) {
			return list;
		}
		else
			return null;
	}
	
	
	
	

}
