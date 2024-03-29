package com.ty.workSpace_Management.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.workSpace_Management.entity.AddressEntity;
import com.ty.workSpace_Management.repo.AddressRepo;

@Repository
public class AddressDao {
	@Autowired
	private AddressRepo repo;

	public AddressEntity saveAddress(AddressEntity address) {
		return repo.save(address);
	}

	public AddressEntity updateAddress(String addressId, AddressEntity address) {
		Optional<AddressEntity> address2 = repo.findById(addressId);
		if (address2.isPresent()) {
			address.setAddressId(addressId);
			if (address.getFlatNumber() == 0) {
				address.setFlatNumber(address2.get().getFlatNumber());
			}
			if (address.getPincode() == 0) {
				address.setPincode(address2.get().getPincode());
			}
			if (address.getState() == null) {
				address.setState(address2.get().getState());

			}
			if (address.getStreet() == null) {
				address.setStreet(address2.get().getStreet());
			}

			return repo.save(address);
		} else {
			return null;
		}
	}

	public AddressEntity findAddress(String addressId) {
		Optional<AddressEntity> address = repo.findById(addressId);
		if (address.isPresent()) {
			return address.get();
		} else {
			return null;
		}

	}

}
