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

import com.ty.workSpace_Management.entity.FloorEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.FloorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/floor")
public class FloorController {

	@Autowired
	private FloorService floorService;

	@PostMapping
	@ApiOperation(value = "save  Floor", notes = "Api is used to save Floor ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  Floor is saved") ,
		@ApiResponse(code = 400, message = "provide proper id")})
	public ResponseEntity<ResponseStructure<FloorEntity>> signupFloor(@Valid @RequestBody FloorEntity floor,
			@RequestParam String adminId, @RequestParam String buildingID) {
		return floorService.saveFloor(floor, adminId,buildingID);
	}

	

	@GetMapping
	@ApiOperation(value = "get Floor", notes = "Api is used to fetch floor ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully  floor is fetched"),
		@ApiResponse(code = 400, message = "provide proper id") })
	public ResponseEntity<ResponseStructure<FloorEntity>> getFloorByID( @RequestParam String floorId) {
		return floorService.getFloor(floorId);
	}

}
