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

import com.ty.workSpace_Management.entity.ClientBookingEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.ClientBookingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/clientbooking")
public class ClientBookingController {
	@Autowired
	private ClientBookingService service;
	
	@ApiOperation(value = "Save clientbooking", notes = "API is used to save client booking")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "succesfully saved"),
			@ApiResponse(code = 400, message = "Id not found for the given clientbooking ID") })
	@PostMapping
	public ResponseEntity<ResponseStructure<ClientBookingEntity>> saveClientBooking(@Valid @RequestBody ClientBookingEntity clientbooking,@RequestParam String clientId,@RequestParam String workSpaceId){
		return service.saveClientBooking(workSpaceId,clientId, clientbooking);
	}
	
	@ApiOperation(value = "Update clientBooking", notes = "API is used to update clientbooking for given clientbooking Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given client booking ID") })
	@PutMapping
	public ResponseEntity<ResponseStructure<ClientBookingEntity>> updateClientBooking(@Valid @RequestBody ClientBookingEntity clientBooking,@RequestParam String id){
		return service.updateClientBooking(clientBooking, id);
				
	}
	
	@ApiOperation(value = "Update clientBooking", notes = "API is used to set rating for clientbooking for given clientbooking Id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully updated"),
			@ApiResponse(code = 400, message = "Id not found for the given client booking ID") })
	@PutMapping("/rating")
	public ResponseEntity<ResponseStructure<ClientBookingEntity>> giveClientBookingRating(@RequestParam String buildingId,@RequestParam String clientBookingId,@RequestParam double rating){
		return service.giveRating(buildingId,rating,clientBookingId);
	}
	
	@ApiOperation(value = "find clientBooking", notes = "API is used to find client booking based on id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "succesfully found"),
			@ApiResponse(code = 400, message = "client booking not found for the given booking ID") })
	@GetMapping
	public ResponseEntity<ResponseStructure<ClientBookingEntity>> findClientBooking(@RequestParam String id){
		return service.findClientBooking(id);
	}
	
	
	
	
}
