package com.ty.workSpace_Management.service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ty.workSpace_Management.dao.BuildingDao;
import com.ty.workSpace_Management.dao.ClientBookingDao;
import com.ty.workSpace_Management.dao.ClientDao;
import com.ty.workSpace_Management.dao.WorkSpaceEntityDao;
import com.ty.workSpace_Management.entity.BuildingEntity;
import com.ty.workSpace_Management.entity.ClientBookingEntity;
import com.ty.workSpace_Management.entity.ClientEntity;
import com.ty.workSpace_Management.entity.WorkSpaceEntity;
import com.ty.workSpace_Management.entity.util.ResponseStructure;
import com.ty.workSpace_Management.exception.ClientBookingNotFound;
import com.ty.workSpace_Management.exception.ClientNotFound;
import com.ty.workSpace_Management.exception.IdNotFoundByWorkSpace;

@Service
public class ClientBookingService {
	@Autowired
	private ClientBookingDao dao;
	@Autowired
	private ClientDao cdao;
	@Autowired
	private BuildingDao bdao;
  
	
	
	@Autowired
	private WorkSpaceEntityDao wdao;

	public ResponseEntity<ResponseStructure<ClientBookingEntity>> saveClientBooking(String workSpaceId, String clientId,
			ClientBookingEntity entity) {
		ClientEntity client = cdao.findClientEntity(clientId);
		if (client != null) {

			WorkSpaceEntity space = wdao.getWorkSpaceEntity(workSpaceId);
			if (space != null) {

				double cost = 0;

				LocalDate start = entity.getStartDate();
				LocalDate end = entity.getEndDate();

				Duration duration = Duration.between(end.atStartOfDay(), start.atStartOfDay());

				long daysElapsed = duration.toDays();
				cost = daysElapsed * space.getWorkSpaceCost();
				entity.setWorkspaces(space);
				entity.setCost(cost);

				ClientBookingEntity clientBookin = dao.saveClientBooking(entity);
				List<ClientBookingEntity> clientBookings = new ArrayList<>();
				clientBookings.add(clientBookin);
				clientBookings.addAll(client.getBookings());
				client.setBookings(clientBookings);
				cdao.updateClientEntity(client, clientId);
				
				space.setWorkSpaceAvailability("Booked");
				wdao.updateWorkSpaceEntity(workSpaceId, space);
				ResponseStructure<ClientBookingEntity> structure = new ResponseStructure<>();
				structure.setData(clientBookin);
				structure.setMessage("client booking saved success");
				structure.setStatus(HttpStatus.CREATED.value());
				return new ResponseEntity<ResponseStructure<ClientBookingEntity>>(structure, HttpStatus.CREATED);

			}
			throw new IdNotFoundByWorkSpace(workSpaceId+" id is not found to book ");
			

		}
		throw new ClientNotFound(clientId+" id is not found to book ");

	}

	public ResponseEntity<ResponseStructure<ClientBookingEntity>> updateClientBooking(ClientBookingEntity clientBooking,
			String id) {
		ClientBookingEntity clientBooking2 = dao.findClientBooking(id);
		if (clientBooking2 != null) {

			double cost = 0;

			LocalDate start = clientBooking2.getStartDate();
			LocalDate end = clientBooking.getEndDate();

			Duration duration = Duration.between(end.atStartOfDay(), start.atStartOfDay());

			long daysElapsed = duration.toDays();
			cost = daysElapsed * clientBooking2.getWorkspaces().getWorkSpaceCost();
			clientBooking2.setEndDate(end);
			clientBooking2.setCost(cost);

			ResponseStructure<ClientBookingEntity> structure = new ResponseStructure<>();
			structure.setData(dao.updateClientBooking(clientBooking2, id));
			structure.setMessage("client booking updated");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ClientBookingEntity>>(structure, HttpStatus.OK);
		}
		throw new ClientBookingNotFound("client booking not found");

	}

	
	
	public ResponseEntity<ResponseStructure<ClientBookingEntity>> giveRating(String buildingId, double rating , String clientBookingId) {
		   ClientBookingEntity clientbooking = dao.findClientBooking(clientBookingId);
			if(clientbooking!=null) {
				
				
				BuildingEntity building=bdao.getBuildingByID(buildingId);
				if (building != null) {
					
					    
				        double previousRating = building.getRating();

				      
				        double newRating = rating;

				        // Calculate the average rating
				        double averageRating = (previousRating + newRating) / 2.0;

				        // Scale the average rating to a range of 0 to 5
				        double maxRating = 5.0;
				        double scaledRating = (averageRating / maxRating) * 5.0;
					     
					     
					   building.setRating(scaledRating);
					   
					
					bdao.updateBuilding(building, buildingId);
					
					
					clientbooking.setRating(rating);
					ResponseStructure<ClientBookingEntity> structure = new ResponseStructure<>();
					structure.setData(dao.updateClientBooking(clientbooking, clientBookingId));
					structure.setMessage("client booking updated");
					structure.setStatus(HttpStatus.OK.value());

					return new ResponseEntity<ResponseStructure<ClientBookingEntity>>(structure, HttpStatus.OK);
				}
			// change to building id not found
			return null;
		}
			throw new ClientBookingNotFound("client booking not found");

			
		}

	public ResponseEntity<ResponseStructure<ClientBookingEntity>> findClientBooking(String id) {
		ClientBookingEntity clientBooking = dao.findClientBooking(id);
		if (clientBooking != null) {


			ResponseStructure<ClientBookingEntity> structure = new ResponseStructure<>();
			structure.setData(dao.findClientBooking(id));
			structure.setMessage("client booking found");
			structure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<ClientBookingEntity>>(structure, HttpStatus.OK);
		}
		throw new ClientBookingNotFound("client booking not found");

	}
	
    @Scheduled(fixedDelay = 5000)
	public void checkEndBooking() {
		List<ClientBookingEntity>list=dao.listofClientBookings();
		if (list != null) {
			 
	        LocalDate currentDate = LocalDate.now();

              for (ClientBookingEntity clientBookingEntity : list) {
				       if(clientBookingEntity.getEndDate().equals(currentDate)) {
				    	   clientBookingEntity.getWorkspaces().setWorkSpaceAvailability("AVAILABLE");
						      dao.updateClientBooking(clientBookingEntity, clientBookingEntity.getId());
				       }
			}

			
		}
		

	}
	
	
	
	

}
