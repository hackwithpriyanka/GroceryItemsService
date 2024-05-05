package com.adminproj.groceryitmes.service;

import java.util.List;

import com.adminproj.groceryitmes.model.GroceryitmesModel;


public interface GroceryitmesService {
	
	public int addNewGoceryItems(List<GroceryitmesModel> groceryItemsList , String userId) ;
	public List<GroceryitmesModel> viewExistingGoceryItems(String userId) ;
	public long updateGoceryItems(GroceryitmesModel groceryItemsModelObj, String userId);
	public long manageGoceryItems(GroceryitmesModel groceryItemsModelObj, String userId);
	public int removeGoceryItems(List<Integer> groceryItemsIdsList, String userId);
	public  List<GroceryitmesModel> viewAvailableGoceryItems(String userId);
	public int bookMultipleGroceryItems(List<Integer> ids, String userId);
	

}
