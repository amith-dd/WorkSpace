package com.ty.workSpace_Management.controller;

import java.util.List;

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

import com.ty.workSpace_Management.entity.WorkSpaceEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.service.WorkSpaceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@RestController
@RequestMapping("/space")
public class WorkSpaceController {

	@Autowired
	private WorkSpaceService workSpaceService;

	@PostMapping
	@ApiOperation(value = "save  workSpace", notes = "Api is used to save workSpace ")
	@ApiResponses({ @ApiResponse(code = 201, message = "Sucessfully  workSpace is saved") })
	public ResponseEntity<ResponseStructure<WorkSpaceEntity>> saveWorkSpace(@Valid @RequestBody WorkSpaceEntity space,
			@RequestParam String managerId, @RequestParam String floorId) {
		return workSpaceService.saveWorkspace(space, managerId, floorId);
	}

	@PutMapping
	@ApiOperation(value = "update  workSpace", notes = "Api is used to update workSpace ")
	@ApiResponses({ @ApiResponse(code = 200, message = "Sucessfully  workSpace is updated"),
			@ApiResponse(code = 404, message = "  workSpace id and manager id is not found to update") })
	public ResponseEntity<ResponseStructure<WorkSpaceEntity>> updateWorkSpace(@RequestParam String workSpaceId,
			@RequestParam String managerId, @RequestParam double cost) {
		return workSpaceService.updateWorkSpace(workSpaceId, managerId, cost);
	}

	@GetMapping
	@ApiOperation(value = "get workSpace", notes = "Api is used to fetch employeeDutyAssign ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully  workSpace id is fetched"),
			@ApiResponse(code = 404, message = "  workSpace id is not found to retrieve") })
	public ResponseEntity<ResponseStructure<WorkSpaceEntity>> getWorkSpace(@RequestParam String workSpaceId) {
		return workSpaceService.getWorkSpace(workSpaceId);
	}

	@GetMapping("/list")
	@ApiOperation(value = "get workSpace list ", notes = "Api is used to fetch workSpace list based on capacity ")
	@ApiResponses({ @ApiResponse(code = 302, message = "Sucessfully  workSpace list is fetched"),
			@ApiResponse(code = 404, message = " count  is not found to retrieve") })
	public ResponseEntity<ResponseStructure<List<WorkSpaceEntity>>> getWorkSpaceByCapacity(@RequestParam int capacity) {
		return workSpaceService.getWorkSpaceByCapacity(capacity);
	}

}
