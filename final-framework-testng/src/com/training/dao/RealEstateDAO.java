package com.training.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.connection.GetConnection;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.LoadDBDetails;

public class RealEstateDAO {

	Properties properties;

	public RealEstateDAO() throws IOException {
		properties = new Properties();
		FileInputStream inputStream = new FileInputStream("./resources/sql.properties");
		properties.load(inputStream);
	}

	public List<RegisterBean> getRegisters() throws SQLException {
		String sql = properties.getProperty("get.registers");
		List<RegisterBean> list = null;
		GetConnection gc = new GetConnection();
		
		gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql);
		list = new ArrayList<RegisterBean>();
		
		gc.rs1 = gc.ps1.executeQuery();
		
		while(gc.rs1.next())
		{
			RegisterBean temp = new RegisterBean();
			temp.setEmail(gc.rs1.getString(1));
			temp.setFirstname(gc.rs1.getString(2));
			temp.setLastname(gc.rs1.getString(3));
			
			list.add(temp);
			
			/*if(gc.rs1.getString(1).equals(email) && gc.rs1.getString(2).equals(firstname) && gc.rs1.getString(3).equals(lastname))
			{
				System.out.println("User successfully registered");
			}*/
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
