package com.ty.workSpace_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.BuildingEntity;

public interface BuildingRepo extends JpaRepository<BuildingEntity, String> {
	
	@Query("select a from  BuildingEntity a order by b.rating desc")
	public List<BuildingEntity> fingByRating();
	
	@Query("select a from  BuildingEntity a where a.AddressEntity.pincode=?1")
	public List<BuildingEntity>findBuilinglistBasedOnPin(int pin);

}
