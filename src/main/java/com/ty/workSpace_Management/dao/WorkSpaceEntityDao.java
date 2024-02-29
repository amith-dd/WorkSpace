package com.ty.workSpace_Management.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.WorkSpaceEntity;
import com.ty.workSpace_Management.repo.WorkSpaceRepo;

@Repository
public class WorkSpaceEntityDao {

	@Autowired
	private WorkSpaceRepo repo;

	public WorkSpaceEntity saveWorkSpaceEntity(WorkSpaceEntity entity) {

		return repo.save(entity);

	}

	public WorkSpaceEntity getWorkSpaceEntity(String workSpaceId) {
		Optional<WorkSpaceEntity> floor = repo.findById(workSpaceId);
		if (floor.isPresent()) {
			return floor.get();
		}
		return null;
	}

	public WorkSpaceEntity updateWorkSpaceEntity(String workSpaceId, WorkSpaceEntity workSpaceEntity) {
		WorkSpaceEntity entity = getWorkSpaceEntity(workSpaceId);
		if (entity != null) {
			workSpaceEntity.setWorkSpaceId(workSpaceId);
			WorkSpaceEntity workSpaceEntity1 = repo.save(workSpaceEntity);

			return workSpaceEntity1;
		}
		return null;

	}

	public WorkSpaceEntity deleteWorkSpaceEntity(String workSpaceId) {
		WorkSpaceEntity entity = getWorkSpaceEntity(workSpaceId);
		if (entity != null) {
			repo.delete(entity);
			return entity;

		}
		return null;

	}

	public List<WorkSpaceEntity> getByCapacity(int workSpaceCapacity) {
		String available="AVAILABLE";
		List<WorkSpaceEntity>list= repo.getByCapacity(workSpaceCapacity, available);
		if(list.isEmpty())
			return null;
		else
			return list;

		
	}

}