package com.ty.workSpace_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.WorkSpaceEntity;

public interface WorkSpaceRepo extends JpaRepository<WorkSpaceEntity, String> {

	@Query("Select w From WorkSpaceEntity w where w.workSpaceCapacity=?1 and w.workSpaceAvailability=?2")
	public  List<WorkSpaceEntity> getByCapacity(int workSpaceCapacity,String available);

}