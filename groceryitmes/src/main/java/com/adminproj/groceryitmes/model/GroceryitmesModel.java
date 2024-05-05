package com.adminproj.groceryitmes.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GroceryitmesModel {
	private String id;
	private String name;
	private String cat;
	private String availStatus;
	private String bookingStatus;
	private int price;
	private int inventory;

}
