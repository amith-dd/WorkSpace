package com.ty.workSpace_Management.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.FloorDao;
import com.ty.workSpace_Management.dao.ManagerDao;
import com.ty.workSpace_Management.dao.WorkSpaceEntityDao;
import com.ty.workSpace_Management.entity.FloorEntity;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.WorkSpaceEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.IdNotFoundByFloor;
import com.ty.workSpace_Management.exception.IdNotFoundByManager;
import com.ty.workSpace_Management.exception.IdNotFoundByWorkSpace;
import com.ty.workSpace_Management.exception.NoSuchListBasedOnCapacity;

@Service
public class WorkSpaceService {

	@Autowired
	private WorkSpaceEntityDao dao;

	@Autowired
	private ManagerDao managerDao;

	@Autowired
	private FloorDao floorDao;

	public ResponseEntity<ResponseStructure<WorkSpaceEntity>> saveWorkspace(WorkSpaceEntity workSpaceEntity,
			String managerId, String floorId) {
		ManagerEntity manager = managerDao.getManagerByID(managerId);
		if (manager != null) {
			FloorEntity floor = floorDao.getFloor(floorId);
			if (floor != null) {

				WorkSpaceEntity work = dao.saveWorkSpaceEntity(workSpaceEntity);
				List<WorkSpaceEntity> list = new ArrayList<>();
				list.addAll(floor.getWorkSpace());
				list.add(work);
				floor.setWorkSpace(list);
				floorDao.updateFloorEntity(floorId, floor);

				ResponseStructure<WorkSpaceEntity> responseStructure = new ResponseStructure<>();
				responseStructure.setData(work);
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setMessage("successfully inserted");
				return new ResponseEntity<ResponseStructure<WorkSpaceEntity>>(responseStructure, HttpStatus.CREATED);

			}
               throw new IdNotFoundByFloor("floor id"+floorId+"is not availble to save the workspace" );
		}
throw new IdNotFoundByManager("manager id "+managerId+" is not available");
	}

	public ResponseEntity<ResponseStructure<WorkSpaceEntity>> updateWorkSpace(String workSpaceId, String managerId,
			double cost) {

		ManagerEntity manager = managerDao.getManagerByID(managerId);
		if (manager != null) {
			
                WorkSpaceEntity work = dao.getWorkSpaceEntity(workSpaceId);
                if(work!=null) {
                	work.setWorkSpaceCost(cost);
                	ResponseStructure<WorkSpaceEntity> responseStructure = new ResponseStructure<>();
            		responseStructure.setStatus(HttpStatus.OK.value());
            		responseStructure.setMessage("Successfully fetched");
            		responseStructure.setData(dao.updateWorkSpaceEntity(workSpaceId, work));
            		return new ResponseEntity<ResponseStructure<WorkSpaceEntity>>(responseStructure, HttpStatus.OK);
                }
				
				throw new IdNotFoundByWorkSpace("workspace is not available to update");
				
			
		}
		throw new IdNotFoundByManager("manager id "+managerId+" is not available");
	}

	public ResponseEntity<ResponseStructure<WorkSpaceEntity>> getWorkSpace(String workSpaceId) {
		  WorkSpaceEntity work = dao.getWorkSpaceEntity(workSpaceId);
          if(work!=null) {
		ResponseStructure<WorkSpaceEntity> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully fetched");
		responseStructure.setData(dao.getWorkSpaceEntity(workSpaceId));
		return new ResponseEntity<ResponseStructure<WorkSpaceEntity>>(responseStructure, HttpStatus.OK);
          }
			
			throw new IdNotFoundByWorkSpace("workspace is not available to retrieve");
	}

	public ResponseEntity<ResponseStructure<List<WorkSpaceEntity>>> getWorkSpaceByCapacity(
			int a) {
		 int count=0;
			//logic for range
			if(a>=0&&a<=3) {
				count=3;
			}
			else if(a>=4&&a<=10) {
				count=10;
			}
			else if(a>=11&&a<=50) {
				count=50;
			}else if(a>=51&&a<=100) {
				count=100;
			}else if(a>=101&&a<=200) {
				count=200;
			}else
				count=200;
			
		
	        List<WorkSpaceEntity>list=dao.getByCapacity(count);
		if (list != null) {
		      
			ResponseStructure<List<WorkSpaceEntity>> responseStructure = new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully fetched");
			responseStructure.setData(list);
			return new ResponseEntity<ResponseStructure<List<WorkSpaceEntity>>>(responseStructure, HttpStatus.OK);
		}
		 throw new NoSuchListBasedOnCapacity("no workspace is available based on "+a+" range");

	}

}