package com.ty.workSpace_Management.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.workSpace_Management.entity.FloorEntity;

public interface FloorRepo extends JpaRepository<FloorEntity, String> {

}
