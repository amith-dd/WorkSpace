package com.ty.workSpace_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.WorkSpaceEntity;

public interface WorkSpaceRepo extends JpaRepository<WorkSpaceEntity, String> {

	@Query("Select w From WorkSpaceEntity w where w.workSpaceCapacity=?1")
	public WorkSpaceEntity getByCapacity(int workSpaceCapacity);

}
