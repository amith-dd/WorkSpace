package com.ty.workSpace_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.FloorEntity;
import com.ty.workSpace_Management.repo.FloorRepo;

@Repository
public class FloorDao {

	@Autowired
	private FloorRepo repo;

	public FloorEntity saveFloorEntity(FloorEntity floorEntity) {

		return repo.save(floorEntity);

	}

	public FloorEntity getFloor(String FloorId) {
		Optional<FloorEntity> floor = repo.findById(FloorId);
		if (floor.isPresent()) {
			return floor.get();
		}
		return null;
	}

	public FloorEntity updateFloorEntity(String floorId, FloorEntity floorEntity) {
		FloorEntity floor = getFloor(floorId);
		if (floor != null) {
			floorEntity.setFloorId(floorId);
			FloorEntity floor1 = repo.save(floorEntity);
			return floor1;
		}
		return null;

	}

	public FloorEntity deleteFloorEntity(String floorId) {
		FloorEntity floor = getFloor(floorId);
		if (floor != null) {
			repo.delete(floor);
			return floor;

		}
		return null;

	}

}
