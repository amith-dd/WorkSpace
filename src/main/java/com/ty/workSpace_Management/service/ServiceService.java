package com.ty.workSpace_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.BuildingDao;
import com.ty.workSpace_Management.dao.ServiceDao;
import com.ty.workSpace_Management.dto.AdminDto;
import com.ty.workSpace_Management.dto.BuildingDto;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.entity.ServiceEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.IdNotFoundByBuilding;
import com.ty.workSpace_Management.exception.NoBuilidngFoundbasedOnRatingException;
import com.ty.workSpace_Management.exception.NoSuchElementFoundByServiceNameException;

@Service
public class ServiceService {
	
	@Autowired
	private ServiceDao dao;
	
	@Autowired
	private BuildingDao dao2;
	
	
public ResponseEntity<ResponseStructure<ServiceEntity>>saveService(ServiceEntity  service, String buildingId){
		BuildingEntity entity=dao2.getBuildingByID(buildingId);
		if(entity!=null) {
			ServiceEntity  ser=dao.saveService(service);
		ResponseStructure<ServiceEntity> structure = new ResponseStructure<>();
		List<ServiceEntity>list=new ArrayList<>();
		list.add(service);
		list.addAll(entity.getService());
        entity.setService(list);
        dao2.updateBuilding(entity, buildingId);
        structure.setData(ser);
		structure.setMessage("Serice saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<ServiceEntity>>(structure, HttpStatus.CREATED);
		}
		throw new IdNotFoundByBuilding(buildingId+" id is not found to add service");
			
	}





public ResponseEntity<ResponseStructure< List<ServiceEntity> >>listOfServicesBasedONServiceName(String name){
	 List<ServiceEntity> service=dao.listOfServicesBasedONServiceName(name);
	 if(service!=null) {
	ResponseStructure< List<ServiceEntity> > structure = new ResponseStructure<>();
        
	 
    structure.setData(service);
	structure.setMessage("Service is found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure< List<ServiceEntity> >>(structure, HttpStatus.OK);
	 }	
	 throw new NoSuchElementFoundByServiceNameException(" service list is not found  to display based on name  ");
}

public ResponseEntity<ResponseStructure< List<ServiceEntity> >>listOfServicesBasedONBuildingService(String buildingId){
	 BuildingEntity entity=dao2.getBuildingByID(buildingId);
	 if(entity!=null) {
	ResponseStructure< List<ServiceEntity> > structure = new ResponseStructure<>();
	
	 
   structure.setData(entity.getService());
	structure.setMessage("building  is found successfully");
	structure.setStatus(HttpStatus.OK.value());
	return new ResponseEntity<ResponseStructure< List<ServiceEntity> >>(structure, HttpStatus.OK);
	 }	
	 throw new IdNotFoundByBuilding(buildingId+"  id is not found to display service list ");
}






	

}
