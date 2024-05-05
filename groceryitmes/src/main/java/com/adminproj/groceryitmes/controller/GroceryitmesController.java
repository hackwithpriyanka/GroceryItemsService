package com.adminproj.groceryitmes.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminproj.groceryitmes.common.Constants.ERROR_CODE;
import com.adminproj.groceryitmes.model.GroceryitmesModel;
import com.adminproj.groceryitmes.model.ResponseMessageStr;
import com.adminproj.groceryitmes.service.GroceryitmesService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/groceryServiceApi")
public class GroceryitmesController {
	private static final Logger log = LoggerFactory.getLogger("GroceryitmesController");
	
	@Autowired
	GroceryitmesService groceryItemsSrvc;
	
	@PostMapping("/adminSrvc/addNewGoceryItems")
	public ResponseEntity<ResponseMessageStr> addNewGoceryItems(@RequestBody List<GroceryitmesModel> groceryItemsList) 
	{

		long errorcode=ERROR_CODE.NO_ERROR;
		ResponseMessageStr responseMsgStr= new ResponseMessageStr();
		String userId="GroceryItemsService";
		int countOfInsertion=0;
		try
		{
		
		log.info("GroceryitmesController->addNewGoceryItems()-->Method Started");
		log.info("GroceryitmesController->addNewGoceryItems()--> Request received::"+groceryItemsList.toString());
		log.info("GroceryitmesController->addNewGoceryItems()--> Requests JSON received::"+new ObjectMapper().writeValueAsString(groceryItemsList));
		int size=groceryItemsList.size();
		countOfInsertion= groceryItemsSrvc.addNewGoceryItems(groceryItemsList, userId);
		if(countOfInsertion==0)
		{
			responseMsgStr.setMessageType("FAILED");
		    responseMsgStr.setMessage("New Records Addition Failed!!!");
		}
		else
		{
		
			responseMsgStr.setMessageType("SUCCESS");
			responseMsgStr.setMessage(countOfInsertion+" No. Of Records Added Successfully Out Of ::"+ size);
		}
		
		responseMsgStr.setErrorCode(errorcode);		
		responseMsgStr.setSuccessCount(countOfInsertion);
		}
		catch(Exception ex)
		{
			log.info("Exiting GroceryitmesController-->Exception occured::"+ex.getMessage()+""+ex.getStackTrace());
			ex.printStackTrace();
		}
		finally
		{
			log.info("GroceryitmesController->addNewGoceryItems()-->Method Ended");
		
		}
		
		return new ResponseEntity<ResponseMessageStr>(responseMsgStr, HttpStatus.OK);

	}
	
	
	@GetMapping("/adminSrvc/viewExistingGoceryItems")
	public ResponseEntity<ResponseMessageStr> viewExistingGoceryItems() 
	{

		long errorcode=ERROR_CODE.NO_ERROR;
		ResponseMessageStr responseMsgStr= new ResponseMessageStr();
		String userID="GrocerySrvc"	;	
		List<GroceryitmesModel> groceryItemsList = new ArrayList<>();
		try
		{
		
		log.info("GroceryitmesController->addNewGoceryItems()-->Method Started");
		groceryItemsList= groceryItemsSrvc.viewExistingGoceryItems(userID);
		responseMsgStr.setObjectList(groceryItemsList);
		if(groceryItemsList.size()==0)
		{
			responseMsgStr.setMessageType("FAILED");
		    responseMsgStr.setMessage("No Grocery Items  Found!!!");
		}
		else
		{
		
			responseMsgStr.setMessageType("SUCCESS");
			responseMsgStr.setMessage(groceryItemsList.size()+" Grocery Items  Found!!!");
		}
		
		responseMsgStr.setErrorCode(errorcode);		
		responseMsgStr.setSuccessCount(groceryItemsList.size());
		}
		catch(Exception ex)
		{
			log.info("Exiting GroceryitmesController-->Exception occured::"+ex.getMessage()+""+ex.getStackTrace());
			ex.printStackTrace();
		}
		finally
		{
			log.info("GroceryitmesController->addNewGoceryItems()-->Method Ended");
		
		}
		
		return new ResponseEntity<ResponseMessageStr>(responseMsgStr, HttpStatus.OK);

	}

	
	@DeleteMapping("/adminSrvc/removeGoceryItems")
	public ResponseEntity<ResponseMessageStr> removeGoceryItems(@RequestBody List<Integer> grocerytemsIdsList) 
	{

		long errorcode=ERROR_CODE.NO_ERROR;
		ResponseMessageStr responseMsgStr= new ResponseMessageStr();
		String userId="GroceryItemsService";
		int countOfDeletion=0;
		try
		{
		
		log.info("GroceryitmesController->removeGoceryItems()-->Method Started");
		log.info("GroceryitmesController->removeGoceryItems()--> Request received::"+grocerytemsIdsList.toString());
		log.info("GroceryitmesController->removeGoceryItems()--> Requests JSON received::"+new ObjectMapper().writeValueAsString(grocerytemsIdsList));
		int size=grocerytemsIdsList.size();
		countOfDeletion= groceryItemsSrvc.removeGoceryItems(grocerytemsIdsList, userId);
		log.info("GroceryitmesController->removeGoceryItems()--> NO. OF Deleted Records::"+countOfDeletion);
		if(countOfDeletion==0)
		{
			responseMsgStr.setMessageType("FAILED");
		    responseMsgStr.setMessage("New Records Addition Failed!!!");
		}
		else
		{
			responseMsgStr.setMessage(countOfDeletion+" No. Of Records Deleted Successfully Out Of ::"+size);
			responseMsgStr.setMessageType("SUCCESS");
			
		}
		responseMsgStr.setErrorCode(errorcode);		
		responseMsgStr.setSuccessCount(countOfDeletion);
		}
		catch(Exception ex)
		{
			log.info("Exiting GroceryitmesController-->Exception occured::"+ex.getMessage()+""+ex.getStackTrace());
			ex.printStackTrace();
		}
		
		log.info("GroceryitmesController->removeGoceryItems()-->Method Ended");
		
		return new ResponseEntity<ResponseMessageStr>(responseMsgStr, HttpStatus.OK);

	}
	
	@PutMapping("/adminSrvc/updateGoceryItems")
	public ResponseEntity<ResponseMessageStr> updateGoceryItems(@RequestBody GroceryitmesModel groceryItemsModelObj) 
	{

		long errorcode=ERROR_CODE.NO_ERROR;
		ResponseMessageStr responseMsgStr= new ResponseMessageStr();
		String userId="GroceryItemsService";
		try
		{
		
		log.info("GroceryitmesController->updateGoceryItems()-->Method Started");
		log.info("GroceryitmesController->updateGoceryItems()--> Request received::"+groceryItemsModelObj.toString());
		log.info("GroceryitmesController->updateGoceryItems()--> Requests JSON received::"+new ObjectMapper().writeValueAsString(groceryItemsModelObj));
		errorcode= groceryItemsSrvc.updateGoceryItems(groceryItemsModelObj, userId);
		
		if(errorcode!=ERROR_CODE.NO_ERROR)
		{
			responseMsgStr.setMessageType("FAILED");
		    responseMsgStr.setMessage("Record Updation Failed!!!");
		}
		else
		{
			responseMsgStr.setMessage("Record updates Successfully!!!");
			responseMsgStr.setMessageType("SUCCESS");
			
		}
		responseMsgStr.setErrorCode(errorcode);		
	}
		catch(Exception ex)
		{
			log.info("Exiting GroceryitmesController-->updateGoceryItems()-->Exception occured::"+ex.getMessage()+""+ex.getStackTrace());
			ex.printStackTrace();
		}
		
		log.info("GroceryitmesController->updateGoceryItems()-->Method Ended");
		
		return new ResponseEntity<ResponseMessageStr>(responseMsgStr, HttpStatus.OK);

	}
	
	@PutMapping("/adminSrvc/manageGoceryItems")
	public ResponseEntity<ResponseMessageStr> manageGoceryItems(@RequestBody GroceryitmesModel groceryItemsModelObj) 
	{

		long errorcode=ERROR_CODE.NO_ERROR;
		ResponseMessageStr responseMsgStr= new ResponseMessageStr();
		String userId="GroceryItemsService";
		try
		{
		
		log.info("GroceryitmesController->manageGoceryItems()-->Method Started");
		log.info("GroceryitmesController->manageGoceryItems()--> Request received::"+groceryItemsModelObj.toString());
		log.info("GroceryitmesController->manageGoceryItems()--> Requests JSON received::"+new ObjectMapper().writeValueAsString(groceryItemsModelObj));
		errorcode= groceryItemsSrvc.manageGoceryItems(groceryItemsModelObj, userId);
		if(errorcode!=ERROR_CODE.NO_ERROR)
		{
			responseMsgStr.setMessageType("FAILED");
		    responseMsgStr.setMessage("Inventory Management Failed!!!");
		}
		else
		{
			responseMsgStr.setMessageType("SUCCESS");
			responseMsgStr.setMessage("Inventory Management SuccessFull!!!");
			
		}
		responseMsgStr.setErrorCode(errorcode);		
	}
		catch(Exception ex)
		{
			log.info("Exiting GroceryitmesController-->manageGoceryItems()-->Exception occured::"+ex.getMessage()+""+ex.getStackTrace());
			ex.printStackTrace();
		}
		
		log.info("GroceryitmesController->manageGoceryItems()-->Method Ended");
		
		return new ResponseEntity<ResponseMessageStr>(responseMsgStr, HttpStatus.OK);

	}
	
	
	@GetMapping("/userSrvc/viewAvailableGroceryItems")
	public ResponseEntity<ResponseMessageStr> viewAvailableGroceryItems() 
	{

		long errorcode=ERROR_CODE.NO_ERROR;
		ResponseMessageStr responseMsgStr= new ResponseMessageStr();
		String userId="GroceryItemsService";
		
		List<GroceryitmesModel> groceryItemsList = new ArrayList<>();
		try
		{
		
		log.info("GroceryitmesController->addNewGoceryItems()-->Method Started");
		groceryItemsList= groceryItemsSrvc.viewAvailableGoceryItems(userId);
		responseMsgStr.setObjectList(groceryItemsList);
		if(groceryItemsList.size()==0)
		{
			responseMsgStr.setMessageType("FAILED");
		    responseMsgStr.setMessage("No Grocery Items  Found!!!");
		}
		else
		{
		
			responseMsgStr.setMessageType("SUCCESS");
			responseMsgStr.setMessage(groceryItemsList.size()+" Grocery Items  Found!!!");
		}
		
		responseMsgStr.setErrorCode(errorcode);		
		responseMsgStr.setSuccessCount(groceryItemsList.size());
		}
		catch(Exception ex)
		{
			log.info("Exiting GroceryitmesController-->Exception occured::"+ex.getMessage()+""+ex.getStackTrace());
			ex.printStackTrace();
		}
		finally
		{
			log.info("GroceryitmesController->addNewGoceryItems()-->Method Ended");
		
		}
		
		return new ResponseEntity<ResponseMessageStr>(responseMsgStr, HttpStatus.OK);

	}
	
	@PutMapping("/userSrvc/bookingMultipleGroceryItems")
	public ResponseEntity<ResponseMessageStr> bookingMultipleGroceryItems(@RequestBody List<Integer> groceryItemsBookingList) 
	{

		long errorcode=ERROR_CODE.NO_ERROR;
		ResponseMessageStr responseMsgStr= new ResponseMessageStr();
		String userId="GroceryItemsService";
		int rowsAffected=0;
		try
		{
		
		log.info("GroceryitmesController->updateGoceryItems()-->Method Started");
		log.info("GroceryitmesController->updateGoceryItems()--> Request received::"+groceryItemsBookingList.toString());
		log.info("GroceryitmesController->updateGoceryItems()--> Requests JSON received::"+new ObjectMapper().writeValueAsString(groceryItemsBookingList));
		rowsAffected= groceryItemsSrvc.bookMultipleGroceryItems(groceryItemsBookingList, userId);
		log.info("GroceryitmesController->updateGoceryItems()-->Items booked Are::"+ rowsAffected);
		if(rowsAffected!=groceryItemsBookingList.size())
		{
			responseMsgStr.setMessageType("FAILED");
		    responseMsgStr.setMessage("Records Booking Failed!!!");
		}
		else
		{
			responseMsgStr.setMessage(rowsAffected+" No. Of Records Booked Successfully!!!");
			responseMsgStr.setMessageType("SUCCESS");
			
		}
		responseMsgStr.setErrorCode(errorcode);		
	}
		catch(Exception ex)
		{
			log.info("Exiting GroceryitmesController-->updateGoceryItems()-->Exception occured::"+ex.getMessage()+""+ex.getStackTrace());
			ex.printStackTrace();
		}
		
		log.info("GroceryitmesController->updateGoceryItems()-->Method Ended");
		
		return new ResponseEntity<ResponseMessageStr>(responseMsgStr, HttpStatus.OK);

	}
	






}
