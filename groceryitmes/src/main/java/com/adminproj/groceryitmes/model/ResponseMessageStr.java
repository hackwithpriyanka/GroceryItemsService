package com.adminproj.groceryitmes.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMessageStr {
	private long errorCode;
	private String message;
	private String messageType;
	private String bookingQty;
   private List<String> dataList;
   private List<?> objectList;
	private long successCount;


}
