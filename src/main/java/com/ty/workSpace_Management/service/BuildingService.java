package com.ty.workSpace_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.AdminDao;
import com.ty.workSpace_Management.dao.BuildingDao;
import com.ty.workSpace_Management.dao.ManagerDao;
import com.ty.workSpace_Management.dto.BuildingDto;
import com.ty.workSpace_Management.dto.DtoConfig;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.IdNotFoundByAdmin;
import com.ty.workSpace_Management.exception.IdNotFoundByBuilding;
import com.ty.workSpace_Management.exception.IdNotFoundByManager;
import com.ty.workSpace_Management.exception.NoBuilidngFoundException;
import com.ty.workSpace_Management.exception.NoBuilidngFoundbasedOnPincodeException;
import com.ty.workSpace_Management.exception.NoBuilidngFoundbasedOnRatingException;
import com.ty.workSpace_Management.exception.NoSuchElementFoundByBuildingNameException;

@Service
public class BuildingService {
	
	@Autowired
	private BuildingDao dao;
	@Autowired
	private DtoConfig dto;
	
	@Autowired
	private AdminDao admindao;
	
	@Autowired
	private ManagerDao managerDao;
	
	public ResponseEntity<ResponseStructure<BuildingDto>>saveBuilding( BuildingEntity building , String adminId){
		 AdminEntity dbadmin=admindao.getAdminByID(adminId);
		 if(dbadmin!=null) {
		ResponseStructure<BuildingDto> structure = new ResponseStructure<>();
		BuildingEntity entity=dao.saveBuildingEntity(building);
	    structure.setData(dto.getbuilding(entity));
	    List<BuildingEntity>list=new ArrayList<>();
		list.add(entity);
		list.addAll(dbadmin.getBuildings());
		   dbadmin.setBuildings(list);
	       admindao.updateAdmin(dbadmin, adminId);
		structure.setMessage("admin  found successfully to save building");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<BuildingDto>>(structure, HttpStatus.CREATED);
		 }	
		 throw new IdNotFoundByAdmin("id is not found for admin to create  the  building");
	}
	
	
	
	
	public ResponseEntity<ResponseStructure<BuildingDto>>getBuildingByID( String id){
		 BuildingEntity building=dao.getBuildingByID(id);
		 if(building!=null) {
		ResponseStructure<BuildingDto> structure = new ResponseStructure<>();
	       
	    structure.setData(dto.getbuilding(building));
		structure.setMessage("building found successfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<BuildingDto>>(structure, HttpStatus.OK);
		 }	
		 throw new IdNotFoundByBuilding("id is not found for building to display ");
	}

	
	public ResponseEntity<ResponseStructure< List<BuildingDto> >>getBuildingByName( String name){
		 List<BuildingEntity> building=dao.listOfBuildingBasedOnName(name);
		 System.out.println(building);
		 if(building!=null){
	     
			   
			  List<BuildingDto>bu=new ArrayList<>();
	          for (BuildingEntity entity : building) {
	         	BuildingDto dto2= dto.getbuilding(entity);
	         	bu.add(dto2);
				}
			 
			 
  		ResponseStructure< List<BuildingDto> > structure = new ResponseStructure<>();
	    structure.setData(bu);
		structure.setMessage("building found successfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure< List<BuildingDto> >>(structure, HttpStatus.OK);
		
		
		 }	
		  
		 throw new NoSuchElementFoundByBuildingNameException(name +"- builing name is not found for building to display ");
		 
	}

	
	public ResponseEntity<ResponseStructure< List<BuildingDto> >>getListOfBuilding( ){
		 List<BuildingEntity> building=dao.listOfBuilding();
		 if(building!=null) {
		ResponseStructure< List<BuildingDto> > structure = new ResponseStructure<>();
	        
		  List<BuildingDto>bu=new ArrayList<>();
         for (BuildingEntity entity : building) {
        	BuildingDto dto2= dto.getbuilding(entity);
        	bu.add(dto2);
			}
         
       
		
	    structure.setData(bu);
		structure.setMessage("building found successfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure< List<BuildingDto> >>(structure, HttpStatus.OK);
		 }	
		 throw new NoBuilidngFoundException(" builing list is not found  to display ");
	}
	
	
	
	
	public ResponseEntity<ResponseStructure< List<BuildingDto> >>getListOfBuildingByLocation(int pincode ){
		 List<BuildingEntity> building=dao.listOfBuildingBasedOnPincode(pincode);
		 if(building!=null) {
		ResponseStructure< List<BuildingDto> > structure = new ResponseStructure<>();
	        
		  List<BuildingDto>bu=new ArrayList<>();
         for (BuildingEntity entity : building) {
        	BuildingDto dto2= dto.getbuilding(entity);
        	bu.add(dto2);
			}
         
       
		
	    structure.setData(bu);
		structure.setMessage("building found successfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure< List<BuildingDto> >>(structure, HttpStatus.OK);
		 }	
		 throw new NoBuilidngFoundbasedOnPincodeException(" builing list is not found  to display based on  "+pincode);
	}


	public ResponseEntity<ResponseStructure< List<BuildingDto> >>getListOfBuildingBasedonRating(){
		 List<BuildingEntity> building=dao.listOfbuilingBasedOnRating();
		 if(building!=null) {
		ResponseStructure< List<BuildingDto> > structure = new ResponseStructure<>();
	        
		  List<BuildingDto>bu=new ArrayList<>();
         for (BuildingEntity entity : building) {
        	BuildingDto dto2= dto.getbuilding(entity);
        	bu.add(dto2);
			}
         
       
		
	    structure.setData(bu);
		structure.setMessage("building found successfully");
		structure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure< List<BuildingDto> >>(structure, HttpStatus.OK);
		 }	
		 throw new NoBuilidngFoundbasedOnRatingException(" builing list is not found  to display based on Rating  ");
	}
	
	public ResponseEntity<ResponseStructure<BuildingDto>>AssignBuildingtoManager( String adminId, String builidngId,String managerID){
		 AdminEntity dbadmin=admindao.getAdminByID(adminId);
		 if(dbadmin!=null) {
			ManagerEntity dbmanager= managerDao.getManagerByID(managerID);
		   if(dbmanager!=null) {
			   BuildingEntity building=dao.getBuildingByID(builidngId);
			   if(building!=null) {
			   building.setManager(dbmanager);
			   dao.updateBuilding(building, builidngId);
				ResponseStructure<BuildingDto> structure = new ResponseStructure<>();

			   structure.setData(dto.getbuilding(building));
			   structure.setMessage("admin  and manager  found successfully to assign building to manager");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<BuildingDto>>(structure, HttpStatus.OK);
			   
			   
			   }
			   throw new IdNotFoundByBuilding(builidngId+" building is not found to assign manager");
			   
			   
			   
		   }
		   throw new IdNotFoundByManager(managerID+" id is not found for manager ");
		 }	
		 throw new IdNotFoundByAdmin(adminId+ " id is not found for admin to assign manager to  the  building");
	}
	
	
	

}
