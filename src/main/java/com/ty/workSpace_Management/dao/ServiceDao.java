package com.ty.workSpace_Management.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.ServiceEntity;
import com.ty.workSpace_Management.repo.ServiceRepo;

@Repository
public class ServiceDao {
	
	@Autowired
	private ServiceRepo repo;
	
	
	public    ServiceEntity saveService(ServiceEntity service) {
		return repo.save(service);
	}
	
	public List<ServiceEntity> listOfServicesBasedONServiceName(String serviceName){
		List<ServiceEntity>list=repo.findServiceByName(serviceName);
		if(list.isEmpty()) {
			return null;
		}
		else
			return list;
	}

}
