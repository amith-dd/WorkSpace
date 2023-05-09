package com.ty.workSpace_Management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.workSpace_Management.entity.AddressEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.AddressService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	private AddressService service;
	@ApiOperation(value = "Save Address", notes = "API is used to save Address")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully created"),
			@ApiResponse(code = 400, message = "Id not found for the given address ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<AddressEntity>> saveAddress(@Valid @RequestBody AddressEntity address,@RequestParam String id){
		return service.saveAddress(address, id);
	}
	@ApiOperation(value = "Update Address", notes = "API is used to update Address for given address Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given address ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<AddressEntity>> updateAddress(@Valid @RequestBody AddressEntity address,@RequestParam String addressId){
		return service.updateAddress(address, addressId);			
	}
	@ApiOperation(value = "get address", notes = "API is used to get address for address Id")
	@ApiResponses(value = { @ApiResponse(code = 302, message = "address is fetched"),
			@ApiResponse(code = 400, message = "Id not found for the given address ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<AddressEntity>> findAddress(@RequestParam String addressEntityId){
		return service.findAddress(addressEntityId);
	}
}
