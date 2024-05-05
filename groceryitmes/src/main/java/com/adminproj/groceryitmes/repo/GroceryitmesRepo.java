package com.adminproj.groceryitmes.repo;

import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;

import com.adminproj.groceryitmes.model.GroceryitmesModel;

public interface GroceryitmesRepo {

	public int insertNewGroceryItems( GroceryitmesModel groceryItemsModel, String userId, Logger log);

	public int updateGroceryItems(GroceryitmesModel groceryItemsModel, String userId, Logger log);

	public int manageInvLevelGroceryItems(GroceryitmesModel groceryItemsModel, String userId, Logger log);

	public int removeGroceryItems(int id, String userId, Logger log);

	public List<GroceryitmesModel> viewExistingGroceryItems(String userId, Logger log);
   	
	public List<GroceryitmesModel> viewvAvailableGroceryItems(String userId, Logger log);

	public int bookMultipleGroceryItems(List<Integer> idsList, Logger log);

}
