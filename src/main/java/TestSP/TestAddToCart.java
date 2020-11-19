package TestSP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.poly.model.Product;

import Test.Lists;
import Test.TestLoginSenenium;

public class TestAddToCart {
	public WebDriver driver;
	public String working;
	Workbook workbook;
	Sheet sheer;
	Map<String, Object[]> TestNGResults;
	Lists li = new Lists();
	public static String driverPath = "D:\\Java 5\\selenium-server-standalone-3.141.59.jar";

	List<String> demPass = new ArrayList<String>();
	List<String> demFail = new ArrayList<String>();

	// Setup write excel chay dau diem
	@BeforeClass(alwaysRun = true)
	public void suitsetup() {
		workbook = new HSSFWorkbook();
		sheer = workbook.createSheet("Kết Quả Test");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		System.setProperty("webdriver.chrome.driver", "D:\\Java 5\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

// Test ADD TO CART
	@Test(groups = "selenium", priority = 1)
	public void Test4() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			driver.navigate().to("http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Login.jsp");
			driver.findElement(ByName.name("username")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(ByName.name("username")).sendKeys("Linh");
			driver.findElement(ByName.name("password")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(ByName.name("password")).sendKeys("123456");
			Thread.sleep(1000);
			driver.findElement(ByName.name("btn")).click();
			Thread.sleep(1000);
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
			TestNGResults.put("1", new Object[] { "ID", "Test Data", "Expected Results", "Actual Results", "Status" });
			// List ADD TO CART
			List<Product> list = li.list_addtocartSP(7);
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				Thread.sleep(2000);
				int idTest = list.get(i).getId();
				String nameTest = list.get(i).getName();
				int priceTest = list.get(i).getPrice();
				String noteTest = list.get(i).getNote();
				String imageTest = list.get(i).getImage();
				int categoryTest = list.get(i).getCategory_id();
				if (list.get(i).getId() > 0) {
					System.out.println(idTest);
					driver.navigate().to(
							"http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/CartController?id="
					+idTest+"&name="+nameTest+"&price="+priceTest+"&note="+noteTest+"&image="
									+imageTest+"&category_id="+categoryTest+"&action=Add+to+Cart");
					Thread.sleep(1000);
				}
				Thread.sleep(1000);
				// Kết quả mong muốn test
				if (driver.getCurrentUrl().equals(urlexpec)) {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_AddToCart_" + (i + 1),
							"Add To Cart with " + list.get(i).getId(), "Thêm Sản Phẩm Thất Bại", "Thêm Sản Phẩm Thất Bại", "Fail" });
					TestLoginSenenium.takeSnapShot(driver,
							"..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_AddToCart_" + (i + 1) + ".png");
					demFail.add("Faild");

				} else {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_AddToCart_" + (i + 1),
							"Add To Cart with " + list.get(i).getId(), "Thêm Sản Phẩm Thành công", "Thêm Sản Phẩm Thành công", "Pass" });
					demPass.add("Pass");

				}
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			TestNGResults.put("3", new Object[] { "Error", "Add To Cart", "Thêm Sản Phẩm Không Thành công", "" + "Lỗi ", "Faild" });
			Assert.assertTrue(false);
			System.out.println(e);
		}
	}
	// Xóa Giỏ Hàng
//	@Test(groups = "selenium", priority = 2)
//	public void Test5() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
//		try {
//		   String url="http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Cart.jsp";
//			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
//			// List Xóa
//			Thread.sleep(1000);
//			List<Product> list = li.list_deltocartSP(8);
//			for (int i = 0; i < list.size(); i++) {
//				driver.get(url);
//				int idTest = list.get(i).getId();
//				if (list.get(i).getId() > 0) {
//					System.out.println(idTest);;
//					driver.findElement(ByName.name("rmv")).click();
//					 driver.navigate().to(
//							"http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/CartController?rmv="+idTest+"&action=Remove");
//					Thread.sleep(1000);
//				}
//				// Kết quả mong muốn test
//				if (driver.getCurrentUrl().equals(urlexpec)) {
//					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_deleteAddToCart_" + (i + 1),
//							"Delete Cart with " + list.get(i).getName(), "Xóa Thất Bại", "Xóa Thất Bại", "Fail" });
//					TestLoginSenenium.takeSnapShot(driver,
//							"..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_deleteAcount_" + (i + 1) + ".png");
//					demFail.add("Faild");
//				} else {
//					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_deleteAddToCart_" + (i + 1),
//							"Delete Cart with " + list.get(i).getName(), "Xóa Thành công", "Xóa Thành công", "Pass" });
//					demPass.add("Pass");
//
//				}
//				Assert.assertTrue(true);
//			}
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			TestNGResults.put("3", new Object[] { "Error", "Delete Login", "Xóa Không Thành công", "" + e, "Faild" });
//			Assert.assertTrue(false);
//			System.out.println(e);
//		} finally {
//		}
//	}

	@AfterClass
	public void suiteTearDown() {
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheer.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("ResultAddSPToExcel.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium Webdriver TestNG result to Excel File!!!");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		 driver.close();
//		  driver.quit();
	}

	public static void takeSnapShot(WebDriver webdriver, String fileWithPath) throws Exception {

		// Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);

		// Call getScreenshotAs method to create image file

		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination

		File DestFile = new File(fileWithPath);

		// Copy file at destination

		Files.copy(SrcFile, DestFile);

	}
}
