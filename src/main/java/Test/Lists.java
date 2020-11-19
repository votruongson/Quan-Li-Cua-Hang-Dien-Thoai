package Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.poly.model.Product;
import com.poly.model.User;

public class Lists {
		// Thực hiện LIST kèm excel
		public List<User> list(int login) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<User> list = new ArrayList<User>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(login);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   User test = new User();
		    		    test.setUsername(fmt.formatCellValue(curr.getCell(0)));
	                    test.setPassword(fmt.formatCellValue(curr.getCell(1)));
		    	   list.add(test);   
		       }
			return list;
		}
		public List<User> list_user(int adduser) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<User> list = new ArrayList<User>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(adduser);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   User test = new User();
		    		    test.setUsername(fmt.formatCellValue(curr.getCell(0)));
	                    test.setPassword(fmt.formatCellValue(curr.getCell(1)));
	                    test.setFullname(fmt.formatCellValue(curr.getCell(2)));
	                    test.setEmail(fmt.formatCellValue(curr.getCell(3)));
	                    test.setPhone(fmt.formatCellValue(curr.getCell(4)));
	                    test.setRole(Integer.parseInt(fmt.formatCellValue(curr.getCell(5))));
		    	   list.add(test);   
		       }
			return list;
		}
		public List<User> list_upuser(int upuser) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<User> list = new ArrayList<User>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(upuser);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   User test = new User(); 
		    	   test.setId(Integer.parseInt(fmt.formatCellValue(curr.getCell(0))));
		    		    test.setUsername(fmt.formatCellValue(curr.getCell(1)));
	                    test.setPassword(fmt.formatCellValue(curr.getCell(2)));
	                    test.setFullname(fmt.formatCellValue(curr.getCell(3)));
	                    test.setEmail(fmt.formatCellValue(curr.getCell(4)));
	                    test.setPhone(fmt.formatCellValue(curr.getCell(5)));
	                    test.setRole(Integer.parseInt(fmt.formatCellValue(curr.getCell(6))));
		    	   list.add(test);   
		       }
			return list;
		}
		public List<User> list_deuser(int deuser) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<User> list = new ArrayList<User>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(deuser);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   User test = new User(); 
		    	   test.setId(Integer.parseInt(fmt.formatCellValue(curr.getCell(0))));
		    	   list.add(test);   
		       }
			return list;
		}
		public List<Product> list_addSP(int addSP) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<Product> list = new ArrayList<Product>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(addSP);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   Product test = new Product(); 
		    		    test.setName(fmt.formatCellValue(curr.getCell(0)));
	                    test.setPrice(Integer.parseInt(fmt.formatCellValue(curr.getCell(1))));
	                    test.setNote(fmt.formatCellValue(curr.getCell(2)));
	                    test.setImage(fmt.formatCellValue(curr.getCell(3)));
	                    test.setCategory_id(Integer.parseInt(fmt.formatCellValue(curr.getCell(4))));
	    
		    	   list.add(test);   
		       }
			return list;
		}
		public List<Product> list_updateSP(int upSP) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<Product> list = new ArrayList<Product>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(upSP);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   Product test = new Product(); 
		    	   test.setId(Integer.parseInt(fmt.formatCellValue(curr.getCell(0))));
		    		    test.setName(fmt.formatCellValue(curr.getCell(1)));
	                    test.setPrice(Integer.parseInt(fmt.formatCellValue(curr.getCell(2))));
	                    test.setNote(fmt.formatCellValue(curr.getCell(3)));
	                    test.setImage(fmt.formatCellValue(curr.getCell(4)));
	                    test.setCategory_id(Integer.parseInt(fmt.formatCellValue(curr.getCell(5))));
	    
		    	   list.add(test);   
		       }
			return list;
		}
		public List<Product> list_deleteSP(int delSP) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<Product> list = new ArrayList<Product>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(delSP);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   Product test = new Product(); 
		    	   test.setId(Integer.parseInt(fmt.formatCellValue(curr.getCell(0))));
	    
		    	   list.add(test);   
		       }
			return list;
		}
		public List<Product> list_addtocartSP(int addtocartSP) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<Product> list = new ArrayList<Product>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(addtocartSP);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   Product test = new Product(); 
		    	       test.setId(Integer.parseInt(fmt.formatCellValue(curr.getCell(0))));
		    		    test.setName(fmt.formatCellValue(curr.getCell(1)));
	                    test.setPrice(Integer.parseInt(fmt.formatCellValue(curr.getCell(2))));
	                    test.setNote(fmt.formatCellValue(curr.getCell(3)));
	                    test.setImage(fmt.formatCellValue(curr.getCell(4)));
	                    test.setCategory_id(Integer.parseInt(fmt.formatCellValue(curr.getCell(5))));
	    
		    	   list.add(test);   
		       }
			return list;
		}
		public List<Product> list_deltocartSP(int deltocartSP) throws EncryptedDocumentException, InvalidFormatException, IOException{
			List<Product> list = new ArrayList<Product>();
			//Luồng lất file cần đọc
			FileInputStream inputstream = new FileInputStream(new File("D:\\Java 4\\PS10683_ASM_SOF301_NguyenThanhHau\\Data.xls"));
			HSSFWorkbook workbook = (HSSFWorkbook) HSSFWorkbookFactory.create(inputstream);
			HSSFSheet sheet = workbook.getSheetAt(deltocartSP);
			//định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);
			  while(iterator.hasNext()) {
		    	   Row curr = iterator.next();
		    	   Product test = new Product(); 
		    	       test.setName(fmt.formatCellValue(curr.getCell(0)));
		    	   list.add(test);   
		       }
			return list;
		}

	
}
