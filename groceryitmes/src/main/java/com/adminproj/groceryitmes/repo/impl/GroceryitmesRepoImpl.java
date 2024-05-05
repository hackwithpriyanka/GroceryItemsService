package com.adminproj.groceryitmes.repo.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adminproj.groceryitmes.common.Constants.PARAMETER_TYPE;
import com.adminproj.groceryitmes.model.GroceryitmesModel;
import com.adminproj.groceryitmes.model.NamedPreparedStatement;
import com.adminproj.groceryitmes.model.Parameter;
import com.adminproj.groceryitmes.repo.GroceryitmesRepo;

@Repository("groceryItemsRepo")
public class GroceryitmesRepoImpl implements GroceryitmesRepo{
	@Autowired
	DataSource ds;
	
	@Override
	public int insertNewGroceryItems(GroceryitmesModel groceryItemsModel, String userId,
			Logger log) {
		log.info("GroceryitmesRepoImpl---->insertNewGroceryItems()--->Method Started");

		int rowsAffected = 0; 
        Parameter param = new Parameter(); 
        Connection con =null;
		try {
			con=ds.getConnection();
			con.setAutoCommit(false);
			StringBuilder sqlQuery = new StringBuilder();
			// change
			sqlQuery.append(
					"INSERT INTO grocery_items (name, category,price,availability_status,booking_status,total_inventory) "
							+ "VALUES(:name,:cat,:price,:availStatus,:bookStatus,:inv)");

			NamedPreparedStatement namedPreparedStatementObj = NamedPreparedStatement.prepareStatement(con,
					sqlQuery.toString());

			param.add(PARAMETER_TYPE.STRING, "name", groceryItemsModel.getName());
			param.add(PARAMETER_TYPE.STRING, "cat", groceryItemsModel.getCat());
			param.add(PARAMETER_TYPE.INT, "price", groceryItemsModel.getPrice());
			param.add(PARAMETER_TYPE.STRING, "availStatus", groceryItemsModel.getAvailStatus());
			param.add(PARAMETER_TYPE.STRING, "bookStatus", groceryItemsModel.getBookingStatus());
			param.add(PARAMETER_TYPE.INT, "inv", groceryItemsModel.getInventory());
			namedPreparedStatementObj.setParameter(param);
			log.info("QUERY:" + namedPreparedStatementObj.getQuery());
			rowsAffected = namedPreparedStatementObj.executeUpdate();

		} catch (Exception ex) {
			log.error("GroceryitmesRepoImpl--->insertNewGroceryItems()-->Exception::" + ex.getStackTrace()
					+ "Message: " + ex.getMessage());
			rowsAffected=0;
			ex.printStackTrace();

		}
		finally {
			log.info("GroceryitmesRepoImpl-->insertNewGroceryItems()--->Entering Into Finally Block");
			try {
					if(!con.isClosed())
					{
						if(rowsAffected!=1)
						{
							con.rollback();
						}
						else
						{
							con.commit();
							
						}
						
					}
					con.close();
				}
				catch(SQLException ex)
				{
					rowsAffected=0;
					log.info("GroceryitmesRepoImpl-->insertNewGroceryItems()--->Exception occured in finaaly block with mesage:: "+ex.getMessage()+" and stacktrace::"+ ex.getStackTrace());
					ex.printStackTrace();
					
				}
				
			}
			
	log.info("GroceryitmesRepoImpl-->insertNewGroceryItems()--->Method Ended");

		return rowsAffected;

	}

	
	@Override
	public int removeGroceryItems( int id, String userId,
			Logger log) {
		log.info("GroceryitmesRepoImpl---->removeGroceryItems()--->Method Started");

		int rowsAffected = 0; 
        Parameter param = new Parameter(); 
        Connection con =null;
		try {
			con=ds.getConnection();
			StringBuilder sqlQuery = new StringBuilder();
			// change
			sqlQuery.append(
					"DELETE From  grocery_items where id=:ID");

			NamedPreparedStatement namedPreparedStatementObj = NamedPreparedStatement.prepareStatement(con,
					sqlQuery.toString());
			param.add(PARAMETER_TYPE.INT, "ID", id);

			namedPreparedStatementObj.setParameter(param);
			log.info("QUERY:" + namedPreparedStatementObj.getQuery());
			rowsAffected = namedPreparedStatementObj.executeUpdate();

		} catch (Exception ex) {
			log.error("GroceryitmesRepoImpl--->removeGroceryItems()-->Exception::" + ex.getStackTrace()
					+ "Message: " + ex.getMessage());
			ex.printStackTrace();

		} 
		log.info("GroceryitmesRepoImpl-->removeGroceryItems()--->Method Ended");

		return rowsAffected;

	}
	
	
	@Override
	public int updateGroceryItems(GroceryitmesModel groceryItemsModel, String userId,
			Logger log) {
		log.info("GroceryitmesRepoImpl---->updateGroceryItems()--->Method Started");

		int rowsAffected = 0; 
        Parameter param = new Parameter(); 
        Connection con =null;
		try {
			con =ds.getConnection();
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(
					"UPDATE  grocery_items set name=:Name, category=:cat,price=:Price,availability_status=:AVS,booking_status=:BKS where id=:ID ");

			NamedPreparedStatement namedPreparedStatementObj = NamedPreparedStatement.prepareStatement(con,
					sqlQuery.toString());
			
			param.add(PARAMETER_TYPE.STRING, "Name", groceryItemsModel.getName());
			param.add(PARAMETER_TYPE.STRING, "cat", groceryItemsModel.getCat());
			param.add(PARAMETER_TYPE.INT, "Price", groceryItemsModel.getPrice());
			param.add(PARAMETER_TYPE.STRING, "AVS", groceryItemsModel.getAvailStatus());
			param.add(PARAMETER_TYPE.STRING, "BKS", groceryItemsModel.getBookingStatus());
			param.add(PARAMETER_TYPE.INT, "ID", groceryItemsModel.getId());
			
			namedPreparedStatementObj.setParameter(param);
			log.info("QUERY:" + namedPreparedStatementObj.getQuery());
			rowsAffected = namedPreparedStatementObj.executeUpdate();

		} catch (Exception ex) {
			log.error("GroceryitmesRepoImpl--->updateGroceryItems()-->Exception::" + ex.getStackTrace()
					+ "Message: " + ex.getMessage());
			ex.printStackTrace();

		} 
		log.info("GroceryitmesRepoImpl-->updateGroceryItems()--->Method Ended");

		return rowsAffected;

	}
	
	
	
	@Override
	public int manageInvLevelGroceryItems(GroceryitmesModel groceryItemsModel, String userId,
			Logger log) {
		log.info("GroceryitmesRepoImpl---->manageInvLevelGroceryItems()--->Method Started");

		int rowsAffected = 0; 
        Parameter param = new Parameter();    
        Connection con=null;
		try {
			con =ds.getConnection();
			StringBuilder sqlQuery = new StringBuilder();
			sqlQuery.append(
					"UPDATE  grocery_items set total_inventory=:inv where id=:ID");

			NamedPreparedStatement namedPreparedStatementObj = NamedPreparedStatement.prepareStatement(con,
					sqlQuery.toString());

			param.add(PARAMETER_TYPE.INT, "inv", groceryItemsModel.getInventory());
			param.add(PARAMETER_TYPE.INT, "ID", groceryItemsModel.getId());
			
			namedPreparedStatementObj.setParameter(param);
			log.info("QUERY:" + namedPreparedStatementObj.getQuery());
			rowsAffected = namedPreparedStatementObj.executeUpdate();

		} catch (Exception ex) {
			log.error("GroceryitmesRepoImpl--->manageInvLevelGroceryItems()-->Exception::" + ex.getStackTrace()
					+ "Message: " + ex.getMessage());
			ex.printStackTrace();

		} 
		log.info("GroceryitmesRepoImpl-->manageInvLevelGroceryItems()--->Method Ended");

		return rowsAffected;

	}
	
	@Override
	public List<GroceryitmesModel> viewExistingGroceryItems(String userId,
			Logger log) {
		log.info("GroceryitmesRepoImpl---->viewGroceryItems()--->Method Started");

		Connection con =null;
        Parameter param = new Parameter();    
        ResultSet rs= null;
        GroceryitmesModel groceryItemsModel=null;
        List<GroceryitmesModel> groceryItemsModelList = new ArrayList<>();
		try {
			con = ds.getConnection();
			StringBuilder sqlQuery = new StringBuilder();
			// change
			sqlQuery.append(
					"select * from grocery_items");

			NamedPreparedStatement namedPreparedStatementObj = NamedPreparedStatement.prepareStatement(con,
					sqlQuery.toString());

			namedPreparedStatementObj.setParameter(param);
			log.info("QUERY:" + namedPreparedStatementObj.getQuery());
			rs = namedPreparedStatementObj.executeQuery();
			while(rs.next())
			{
				groceryItemsModel= new GroceryitmesModel();
				groceryItemsModel.setId(rs.getString("id"));
				groceryItemsModel.setName(rs.getString("name"));
				groceryItemsModel.setPrice(rs.getInt("price"));
				groceryItemsModel.setCat(rs.getString("category"));
				groceryItemsModel.setAvailStatus(rs.getString("availability_status"));
				groceryItemsModel.setBookingStatus(rs.getString("booking_status"));
				groceryItemsModel.setInventory(rs.getInt("total_inventory"));
				groceryItemsModelList.add(groceryItemsModel);
			}

		} catch (Exception ex) {
			log.error("GroceryitmesRepoImpl--->viewGroceryItems()-->Exception::" + ex.getStackTrace()
					+ "Message: " + ex.getMessage());
			ex.printStackTrace();

		} 
		log.info("GroceryitmesRepoImpl-->viewGroceryItems()--->Method Ended");

		return groceryItemsModelList;

	}
	
	
	@Override
	public List<GroceryitmesModel> viewvAvailableGroceryItems(String userId,
			Logger log) {
		log.info("GroceryitmesRepoImpl---->viewGroceryItems()--->Method Started");

		Connection con=null;
        Parameter param = new Parameter();    
        ResultSet rs= null;
        GroceryitmesModel groceryItemsModel=null;
        List<GroceryitmesModel> groceryItemsModelList = new ArrayList<>();
		try {
			con=ds.getConnection();
			StringBuilder sqlQuery = new StringBuilder();
			// change
			sqlQuery.append(
					"select * from grocery_items where availability_status='Y'");

			NamedPreparedStatement namedPreparedStatementObj = NamedPreparedStatement.prepareStatement(con,
					sqlQuery.toString());

			namedPreparedStatementObj.setParameter(param);
			log.info("QUERY:" + namedPreparedStatementObj.getQuery());
			rs = namedPreparedStatementObj.executeQuery();
			while(rs.next())
			{
				groceryItemsModel= new GroceryitmesModel();
				groceryItemsModel.setId(rs.getString("id"));
				groceryItemsModel.setName(rs.getString("name"));
				groceryItemsModel.setPrice(rs.getInt("price"));
				groceryItemsModel.setCat(rs.getString("category"));
				groceryItemsModel.setAvailStatus(rs.getString("availability_status"));
				groceryItemsModel.setBookingStatus(rs.getString("booking_status"));
				groceryItemsModel.setInventory(rs.getInt("total_inventory"));
				groceryItemsModelList.add(groceryItemsModel);
			}

		} catch (Exception ex) {
			log.error("GroceryitmesRepoImpl--->viewGroceryItems()-->Exception::" + ex.getStackTrace()
					+ "Message: " + ex.getMessage());
			ex.printStackTrace();

		} 
		log.info("GroceryitmesRepoImpl-->viewGroceryItems()--->Method Ended");

		return groceryItemsModelList;

	}

@Override	
public int bookMultipleGroceryItems(List<Integer> idsList,Logger log) {

	log.info("GroceryitmesRepoImpl---->manageInvLevelGroceryItems()--->Method Started");

	int rowsAffected = 0; 
    Parameter param = new Parameter();    
    Connection con=null;
	try {
		con =ds.getConnection();
		StringBuilder sqlQuery = new StringBuilder();
		String idsStr="";
		sqlQuery.append(
				"UPDATE  grocery_items set booking_status='Y' where id in (:IDs)");
		for(int id :idsList)
		{
			idsStr=idsStr+id+",";
		}
		if (idsStr.endsWith(",")) {
			idsStr = idsStr.substring(0, idsStr.length() - 1);
		}
		int ids=Integer.parseInt(idsStr);
		NamedPreparedStatement namedPreparedStatementObj = NamedPreparedStatement.prepareStatement(con,
				sqlQuery.toString());

		param.add(PARAMETER_TYPE.INT, "IDs", ids);
			
		namedPreparedStatementObj.setParameter(param);
		log.info("QUERY:" + namedPreparedStatementObj.getQuery());
		rowsAffected = namedPreparedStatementObj.executeUpdate();

	} catch (Exception ex) {
		log.error("GroceryitmesRepoImpl--->manageInvLevelGroceryItems()-->Exception::" + ex.getStackTrace()
				+ "Message: " + ex.getMessage());
		ex.printStackTrace();

	} 
	log.info("GroceryitmesRepoImpl-->manageInvLevelGroceryItems()--->Method Ended");

	return rowsAffected;


}
	

}
