package com.ty.workSpace_Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.AddressDao;
import com.ty.workSpace_Management.dao.AdminDao;
import com.ty.workSpace_Management.dao.BuildingDao;
import com.ty.workSpace_Management.dao.ClientDao;
import com.ty.workSpace_Management.dao.EmployeeDao;
import com.ty.workSpace_Management.dao.ManagerDao;
import com.ty.workSpace_Management.entity.AddressEntity;
import com.ty.workSpace_Management.entity.AdminEntity;
import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.entity.ClientEntity;
import com.ty.workSpace_Management.entity.EmployeeEntity;
import com.ty.workSpace_Management.entity.ManagerEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.AddressNotFound;
import com.ty.workSpace_Management.exception.IdInvalidForEntity;

@Service
public class AddressService {
	@Autowired
	private AddressDao dao;
	@Autowired
	private ClientDao cdao;
	@Autowired
	private EmployeeDao edao;
	@Autowired
	private BuildingDao bdao;
	@Autowired
	private ManagerDao mdao;
	@Autowired
	private AdminDao adao;
	
	
	
	public AddressEntity save(AddressEntity address, String id) {
		
		
		if (id.startsWith("Client_")) {
			ClientEntity client=cdao.findClientEntity(id);
			if (client != null) {
				
				client.setAddress(address);
				return cdao.updateClientEntity(client, id).getAddress();
			}
		}
		else if (id.startsWith("Admin_")) {
			AdminEntity admin=adao.getAdminByID(id);
			if (admin != null) {
				
				admin.setAddress(address);
				return adao.updateAdmin(admin, id).getAddress();
			}
		}
		else if (id.startsWith("Build_")) {
			BuildingEntity building=bdao.getBuildingByID(id);
			if (building != null) {
				
				building.setAddress(address);
				return bdao.updateBuilding(building, id).getAddress();
			}
		}
		else if (id.startsWith("Manager_")) {
			ManagerEntity manager=mdao.getManagerByID(id);
			if (manager != null) {
				
				manager.setAddress(address);
				return mdao.updateManager(manager, id).getAddress();
			}
		}
		else if (id.startsWith("Employee_")) {
			EmployeeEntity employee=edao.findEmployee(id);
			if (employee != null) {
				
				employee.setAddress(address);
				return edao.updateEmployee(employee, id).getAddress();
			}
		}
		
		
		return null;
	}
	
	
	
	public ResponseEntity<ResponseStructure<AddressEntity>> saveAddress(AddressEntity address, String id){
		System.out.println(id);
		AddressEntity  address1=save(address, id);
		if(address1!=null) {
			ResponseStructure<AddressEntity> structure = new ResponseStructure<>();
			structure.setData(address1);
			structure.setMessage("address saved successfully");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AddressEntity>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdInvalidForEntity("id not valid for any of entities");
		}
	}
	
	public ResponseEntity<ResponseStructure<AddressEntity>> updateAddress(AddressEntity address,String addressId){
		AddressEntity address2 = dao.findAddress(addressId);
		if(address2!=null) {
			ResponseStructure<AddressEntity> structure = new ResponseStructure<>();
			structure.setData(dao.updateAddress(addressId, address));
			structure.setMessage("address updated success");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<AddressEntity>>(structure,HttpStatus.OK);
		}
		throw new AddressNotFound("address not found for given id");
	}
	
	public ResponseEntity<ResponseStructure<AddressEntity>> findAddress(String addressId){
		AddressEntity address = dao.findAddress(addressId);
		if(address!=null) {
			ResponseStructure<AddressEntity> structure = new ResponseStructure<>();
			structure.setData(address);
			structure.setMessage("address found success");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<AddressEntity>>(structure,HttpStatus.FOUND);
		}
		throw new AddressNotFound("address not found for given id");
	}
	
}
