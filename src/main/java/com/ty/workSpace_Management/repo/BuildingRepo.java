package com.ty.workSpace_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ty.workSpace_Management.entity.BuildingEntity;

public interface BuildingRepo extends JpaRepository<BuildingEntity, String> {
	
	@Query("select a from  BuildingEntity a order by a.rating desc")
	public List<BuildingEntity> fingByRating();
	
	@Query("select b from  BuildingEntity b JOIN b.address a where a.pincode = :pincode")
	public List<BuildingEntity>findBuilinglistBasedOnPin(@Param("pincode") int pincode);
	
	
	@Query("select a from  BuildingEntity a where a.buildingName = ?")
	public List<BuildingEntity> findbyName(String name);

}
