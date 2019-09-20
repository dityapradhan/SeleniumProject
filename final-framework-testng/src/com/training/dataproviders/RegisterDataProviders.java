package com.training.dataproviders;

import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.bean.RegisterBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RealEstateDAO;
import com.training.readexcel.ApachePOIExcelRead;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.testng.annotations.DataProvider;

public class RegisterDataProviders {
	 
  @DataProvider(name = "excel-input")
  public Object[][] getExcelData() {
	  String fileName = "C:\\Users\\DITYAPRADHAN\\Desktop\\Selenium\\Project\\RealEstateData.xlsx";
	  String sheetName = "Register";
	  return new ApachePOIExcelRead().getExcelContent(fileName, sheetName);
  }
  
  @DataProvider(name = "db-input")
	public Object[][] getDBData() throws SQLException, IOException {

	  List<RegisterBean> list = new RealEstateDAO().getRegisters();

		Object[][] result = new Object[list.size()][];
		int count = 0;
		for (RegisterBean temp : list) {
			Object[] obj = new Object[3];
			obj[0] = temp.getEmail();
			obj[1] = temp.getFirstname();
			obj[2] = temp.getLastname();

			result[count++] = obj;
		}

		return result;
	}
}
