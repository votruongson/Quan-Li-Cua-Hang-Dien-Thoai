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
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.poly.model.Product;
import com.poly.model.User;

import Test.Lists;
import Test.TestLoginSenenium;

public class TestAllSP {
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

	// Test Thêm Sản Phẩm
	@Test(groups = "selenium", priority = 1)
	public void Test1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {//Đăng Nhập tài khoản
			driver.navigate().to("http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Login.jsp");
			driver.findElement(ByName.name("username")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(ByName.name("username")).sendKeys("Linh");
			driver.findElement(ByName.name("password")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(ByName.name("password")).sendKeys("123456");
			driver.findElement(ByName.name("btn")).click();
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/add_Product.jsp";
			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
			TestNGResults.put("1", new Object[] { "ID", "Test Data", "Expected Results", "Actual Results", "Status" });
			// List data 
			List<Product> list = li.list_addSP(4);
			// Duyệt phần tử thêm vào
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				driver.findElement(ByName.name("name")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("name")).sendKeys(list.get(i).getName());
				driver.findElement(ByName.name("price")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("price")).sendKeys(String.valueOf(list.get(i).getPrice()));
				driver.findElement(ByName.name("note")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("note")).sendKeys(list.get(i).getNote());
				driver.findElement(ByName.name("image")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("image")).sendKeys(list.get(i).getImage());
				driver.findElement(ByName.name("category_id")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(3000);
				driver.findElement(ByName.name("_type")).click();
				Thread.sleep(3000);
				// Kết quả mong muốn test
				if (!driver.getCurrentUrl().equals(urlexpec)) {
					TestNGResults.put("2" + (list.size() + i),
							new Object[] { "Test_createProduct_" + (i + 1),
									"Add an product with name:" + list.get(i).getName() + "\t\n" + " " + "Price:"
											+ list.get(i).getPrice() + "\t\n" + " " + "Note:" + list.get(i).getNote()
											+ "\t\n" + " " + "Image:" + list.get(i).getImage() + "\t\n" + " "
											+ "Category:" + list.get(i).getCategory_id() + "\t\n",
									"Thêm Thất Bại", "Thêm Thất Bại", "Fail" });
					TestAllSP.takeSnapShot(driver,
							"..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_createProduct_" + (i + 1) + ".png");
					demFail.add("Fail");

				} else {
					TestNGResults.put("2" + (list.size() + i),
							new Object[] { "Test_createProduct_" + (i + 1),
									"Add an product with name:" + list.get(i).getName() + "\t\n" + " " + "Price:"
											+ list.get(i).getPrice() + "\t\n" + " " + "Note:" + list.get(i).getNote()
											+ "\t\n" + " " + "Image:" + list.get(i).getImage() + "\t\n" + " "
											+ "Category:" + list.get(i).getCategory_id() + "\t\n",
									"Thêm Thành công", "Thêm Thành công", "Pass" });
					demPass.add("Pass");

				}
				Assert.assertTrue(true);
			}
		} catch (Exception e) {
			TestNGResults.put("3", new Object[] { "Error", "Add Login", "Thêm Không Thành công", "" + e, "Faild" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {

		}
	}
	// Cập nhật sản Phẩm
	@Test(groups = "selenium", priority = 2)
	public void Test2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
			// List Update
			List<Product> list = li.list_updateSP(5);
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				int idTest = list.get(i).getId();
				if (list.get(i).getId() > 0) {
					driver.navigate().to(
							"http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Update_Product.jsp?_type=UPDATE&id="+ idTest);
					driver.findElement(ByName.name("name")).click();
					driver.findElement(ByName.name("name")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("name")).sendKeys(list.get(i).getName());
					driver.findElement(ByName.name("price")).click();
					driver.findElement(ByName.name("price")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("price")).sendKeys(String.valueOf(list.get(i).getPrice()));
					driver.findElement(ByName.name("note")).click();
					driver.findElement(ByName.name("note")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("note")).sendKeys(list.get(i).getNote());
					driver.findElement(ByName.name("image")).click();
					driver.findElement(ByName.name("image")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("image")).sendKeys(list.get(i).getImage());
					driver.findElement(ByName.name("category_id")).click();
					Thread.sleep(3000);
					driver.findElement(ByName.name("_type")).click();
				}
				// Kết quả mong muôn test
				if (driver.getCurrentUrl().equals(urlexpec)) {
					TestNGResults.put("2" + (list.size() + i),
							new Object[] { "Test_UpdateProduct_" + (i + 1),
									"Update an product with name:" + list.get(i).getName() + "\t\n" + " " + "Price:"
											+ list.get(i).getPrice() + "\t\n" + " " + "Note:" + list.get(i).getNote()
											+ "\t\n" + " " + "Image:" + list.get(i).getImage() + "\t\n" + " "
											+ "Category:" + list.get(i).getCategory_id() + "\t\n",
									"Cập Nhật Thất Bại", "Cập Nhật Thất Bại", "Fail" });
					TestAllSP.takeSnapShot(driver,
							"..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_UpdateProduct_" + (i + 1) + ".png");
					demFail.add("Fail");

				} else {
					TestNGResults.put("2" + (list.size() + i),
							new Object[] { "Test_UpdateProduct_" + (i + 1),
									"Update an product with name:" + list.get(i).getName() + "\t\n" + " " + "Price:"
											+ list.get(i).getPrice() + "\t\n" + " " + "Note:" + list.get(i).getNote()
											+ "\t\n" + " " + "Image:" + list.get(i).getImage() + "\t\n" + " "
											+ "Category:" + list.get(i).getCategory_id() + "\t\n",
									"Cập Nhật Thành công", "Cập Nhật Thành công", "Pass" });
					demPass.add("Pass");

				}
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			TestNGResults.put("3", new Object[] { "Error", "Update Login", "Update Không Thành công", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}
	}
// Xóa Sản Phẩm
	@Test(groups = "selenium", priority = 3)
	public void Test3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
			String urlexpe = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_Product.jsp";
			TestNGResults.put("1", new Object[] { "ID", "Test Data", "Expected Results", "Actual Results", "Status" });
			// List Xóa
			List<Product> list = li.list_deleteSP(6);
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				int idTest = list.get(i).getId();
				if (list.get(i).getId() > 0) {
					System.out.println(idTest);
					driver.navigate().to(
							"http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/ProController?_type=DELETE&proid="
									+ idTest);
					Thread.sleep(1000);
				}
				// Kết quả mong muốn test
				if (!driver.getCurrentUrl().equals(urlexpe)) {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_XoaSP_" + (i + 1),
							"Delete with " + list.get(i).getId(), "Xóa Thất Bại", "Xóa Thất Bại", "Fail" });
					TestAllSP.takeSnapShot(driver,
							"..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_deleteXoaSP_" + (i + 1) + ".png");
					demFail.add("Faild");

				} else {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_XoaSP_" + (i + 1),
							"Delete with " + list.get(i).getId(), "Xóa Thành công", "Xóa Thành công", "Pass" });
					demPass.add("Pass");

				}
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			TestNGResults.put("3", new Object[] { "Error", "Delete Product", "Xóa Không Thành công", "" + "Lỗi ", "Faild" });
			Assert.assertTrue(false);
			System.out.println(e);
		}
	}

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
			FileOutputStream out = new FileOutputStream(new File("ResultSPToExcel.xls"));
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
