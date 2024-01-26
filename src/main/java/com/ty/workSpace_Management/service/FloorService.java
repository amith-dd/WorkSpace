package com.ty.workSpace_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.AdminDao;
import com.ty.workSpace_Management.dao.BuildingDao;
import com.ty.workSpace_Management.dao.FloorDao;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.entity.FloorEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.IdNotFoundByAdmin;
import com.ty.workSpace_Management.exception.IdNotFoundByBuilding;
import com.ty.workSpace_Management.exception.IdNotFoundByFloor;

@Service
public class FloorService {

	@Autowired
	private FloorDao dao;

	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private BuildingDao buildingDao;

	public ResponseEntity<ResponseStructure<FloorEntity>> saveFloor(FloorEntity floor, String adminId, String buildingId) {

		AdminEntity admin = adminDao.getAdminByID(adminId);
		if (admin != null) {
		  BuildingEntity building=buildingDao.getBuildingByID(buildingId);
		  if(building!=null) {
			  
				ResponseStructure<FloorEntity> responseStructure = new ResponseStructure<>();
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setData(dao.saveFloorEntity(floor));
				responseStructure.setMessage("successfully save the floor");

				return new ResponseEntity<ResponseStructure<FloorEntity>>(responseStructure, HttpStatus.CREATED);
			  
			  
			  
		  }
            throw new IdNotFoundByBuilding(buildingId+" building id is not found to set the floors");
		}
		throw new IdNotFoundByAdmin(adminId+" admin is not found to save the floors into building ");
	}



	public ResponseEntity<ResponseStructure<FloorEntity>> getFloor(String floorId) {
		FloorEntity floorEntity=dao.getFloor(floorId);
		if(floorEntity!=null) {
			ResponseStructure<FloorEntity> responseStructure = new ResponseStructure<>();
			responseStructure.setMessage("Successfully fetched");
			responseStructure.setData(dao.getFloor(floorId));
			responseStructure.setStatus(HttpStatus.OK.value());

			return new ResponseEntity<ResponseStructure<FloorEntity>>(responseStructure, HttpStatus.OK);
		}
		throw new  IdNotFoundByFloor("floor id "+floorId+"is not available to display");
	}

}
