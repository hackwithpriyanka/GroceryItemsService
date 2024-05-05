package com.adminproj.groceryitmes.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminproj.groceryitmes.common.Constants.ERROR_CODE;
import com.adminproj.groceryitmes.model.GroceryitmesModel;
import com.adminproj.groceryitmes.repo.GroceryitmesRepo;
import com.adminproj.groceryitmes.service.GroceryitmesService;



@Service("groceryItemsSrvc")
public class GroceryitmesServiceImpl implements GroceryitmesService{
	private static final Logger log = LoggerFactory.getLogger(GroceryitmesServiceImpl.class);	
	
	
	@Autowired
	GroceryitmesRepo groceryItemsRepo;
	
	@Override
	public int  addNewGoceryItems(List<GroceryitmesModel> groceryItemsList, String userId) {
		log.info("GroceryItemsServiceImpl--->addNewGoceryItems()--->Method Strated");
		long errorCode= ERROR_CODE.NO_ERROR;
		int rowsAffected=0;
		int count=0;
		try
		{
			for(GroceryitmesModel groceryModelObj:groceryItemsList)
			{
				rowsAffected=groceryItemsRepo.insertNewGroceryItems(groceryModelObj, userId, log);
				if(rowsAffected==1)
				{
					count++;
					log.info("GroceryItemsServiceImpl--->addNewGoceryItems()--->Record Inserted Successfully With Counter As ::"+count);
					
				}
				else
				{
					errorCode=ERROR_CODE.INSERTION_FAILED;
					log.info("GroceryItemsServiceImpl--->addNewGoceryItems()--->Record Inserted Faile  With ErrorCode As ::"+errorCode);
					
				}
				
			}
			
		}
		catch(Exception ex)
		{
			log.info("GroceryItemsServiceImpl--->addNewGoceryItems()--->Exception Occured With Message ::"+ex.getMessage()+" And StackTrace::"+ex.getStackTrace());
			errorCode=ERROR_CODE.INSERTION_FAILED;
			ex.printStackTrace();
			
		}
		
		log.info("GroceryItemsServiceImpl--->addNewGoceryItems()--->Method Ended");
		return count;
	}

	@Override
	public List<GroceryitmesModel> viewExistingGoceryItems(String userId) {


		log.info("GroceryItemsServiceImpl--->viewAvailableGoceryItems()--->Method Strated");
		long errorCode=ERROR_CODE.NO_ERROR;
	   List<GroceryitmesModel> groceryitemsList = new ArrayList<>();
		try
		{
			
			groceryitemsList=groceryItemsRepo.viewExistingGroceryItems(userId, log);
				
		}
		catch(Exception ex)
		{
			log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Exception Occured With Message ::"+ex.getMessage()+" And StackTrace::"+ex.getStackTrace());
			errorCode=ERROR_CODE.INSERTION_FAILED;
			ex.printStackTrace();
			
		}
		
		log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Method Ended");
		return groceryitemsList;
	
	
	}
	
	@Override
	public List<GroceryitmesModel> viewAvailableGoceryItems(String userId) {


		log.info("GroceryItemsServiceImpl--->viewAvailableGoceryItems()--->Method Strated");
		long errorCode= ERROR_CODE.NO_ERROR;
		List<GroceryitmesModel> groceryitemsList = new ArrayList<>();
		try
		{
			groceryitemsList=groceryItemsRepo.viewvAvailableGroceryItems(userId, log);
				
		}
		catch(Exception ex)
		{
			log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Exception Occured With Message ::"+ex.getMessage()+" And StackTrace::"+ex.getStackTrace());
			errorCode=ERROR_CODE.INSERTION_FAILED;
			ex.printStackTrace();
			
		}
		
		log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Method Ended");
		return groceryitemsList;
	
	
	}


	@Override
	public int removeGoceryItems(List<Integer> groceryItemsIdsList, String userId) {

		log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Method Strated");
		long errorCode= ERROR_CODE.NO_ERROR;
		int rowsAffected=0;
		int count=0;
		try
		{
			for(int  id:groceryItemsIdsList)
			{
				rowsAffected=groceryItemsRepo.removeGroceryItems(id, userId, log);
				if(rowsAffected==1)
				{
					count++;
					log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Record Removed Successfully With Counter As ::"+count);
					
				}
				else
				{
					errorCode=ERROR_CODE.INSERTION_FAILED;
					log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Record Removal Failed  With ErrorCode As ::"+errorCode);
					
				}
			
			}
			
						
		}
		catch(Exception ex)
		{
			log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Exception Occured With Message ::"+ex.getMessage()+" And StackTrace::"+ex.getStackTrace());
			errorCode=ERROR_CODE.INSERTION_FAILED;
			ex.printStackTrace();
			
		}
		
		log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Method Ended");
		return count;
	
	}

	@Override
	public long updateGoceryItems(GroceryitmesModel groceryItemsModelObj, String userId) {


		log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Method Strated");
		long errorCode= ERROR_CODE.NO_ERROR;
		int rowsAffected=0;
		int count=0;
		try
		{
			
			rowsAffected=groceryItemsRepo.updateGroceryItems( groceryItemsModelObj, userId, log);
			if(rowsAffected==1)
			{
				
				log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Record Updated Successfully With ErrorCode As ::"+errorCode);
				
			}
			else
			{
				errorCode=ERROR_CODE.INSERTION_FAILED;
				log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Record Removal Failed  With ErrorCode As ::"+errorCode);
				
			}
						
		}
		catch(Exception ex)
		{
			log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Exception Occured With Message ::"+ex.getMessage()+" And StackTrace::"+ex.getStackTrace());
			errorCode=ERROR_CODE.INSERTION_FAILED;
			ex.printStackTrace();
			
		}
		
		log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Method Ended");
		return errorCode;
	
	
	}

	@Override
	public long manageGoceryItems(GroceryitmesModel groceryItemsModelObj, String userId) {



		log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Method Strated");
		long errorCode= ERROR_CODE.NO_ERROR;
		int rowsAffected=0;
		try
		{
		
			rowsAffected=groceryItemsRepo.manageInvLevelGroceryItems(groceryItemsModelObj, userId, log);
			if(rowsAffected==1)
			{
				
				log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Record Updated Successfully With ErrorCode As ::"+errorCode);
				
			}
			else
			{
				errorCode=ERROR_CODE.INSERTION_FAILED;
				log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Record Removal Failed  With ErrorCode As ::"+errorCode);
				
			}
						
		}
		catch(Exception ex)
		{
			log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Exception Occured With Message ::"+ex.getMessage()+" And StackTrace::"+ex.getStackTrace());
			errorCode=ERROR_CODE.INSERTION_FAILED;
			ex.printStackTrace();
			
		}
		
		log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Method Ended");
		return errorCode;
	
	
	
	}
	
	
	@Override
	public int bookMultipleGroceryItems(List<Integer> ids, String userId) {


		log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Method Strated");
		long errorCode= ERROR_CODE.NO_ERROR;
		int rowsAffected=0;
		
		try
		{
			rowsAffected=groceryItemsRepo.bookMultipleGroceryItems(ids, log);
			if(rowsAffected>=ids.size())
			{
				
				log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Record Updated Successfully With ErrorCode As ::"+errorCode);
				
			}
			else
			{
				errorCode=ERROR_CODE.INSERTION_FAILED;
				log.info("GroceryItemsServiceImpl--->updateGoceryItems()--->Record Removal Failed  With ErrorCode As ::"+errorCode);
				
			}
						
		}
		catch(Exception ex)
		{
			log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Exception Occured With Message ::"+ex.getMessage()+" And StackTrace::"+ex.getStackTrace());
			errorCode=ERROR_CODE.INSERTION_FAILED;
			ex.printStackTrace();
			
		}
		
		log.info("GroceryItemsServiceImpl--->removeGoceryItems()--->Method Ended");
		return rowsAffected;
	
	
	}
	
	
	
	

}
