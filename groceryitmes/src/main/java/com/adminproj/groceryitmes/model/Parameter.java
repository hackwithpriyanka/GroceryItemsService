package com.adminproj.groceryitmes.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Parameter {
	private String parameterType;
	private String parameterName;
	private Object parameterValue;
	private ArrayList<Parameter> parameterList=null;
	
	public void add(String parameterType,String parameterName,Object parameterValue)
	{
		if(parameterList==null)
		parameterList=new  ArrayList<Parameter> ();
		Parameter parameterObj=new Parameter();
		parameterObj.setParameterName(parameterName);
		parameterObj.setParameterType(parameterType);
		parameterObj.setParameterValue(parameterValue);
		parameterList.add(parameterObj);
	}


}
