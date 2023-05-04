package com.ty.workSpace_Management.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.workSpace_Management.entity.ServiceEntity;

public interface ServiceRepo extends JpaRepository<ServiceEntity, String> {
	@Query("select a from ServiceEntity a where a.serviceName=?1")
	public List<ServiceEntity> findServiceByName(String name);

}
