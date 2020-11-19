package Test;

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
import com.poly.model.User;

import TestSP.TestAllSP;
public class TestLoginSenenium {
	public WebDriver driver;
	public String working;
	Workbook workbook;
	Sheet sheer;
	Map<String, Object[]> TestNGResults;
	Lists li = new Lists();
	public static String driverPath = "D:\\Java 5\\selenium-server-standalone-3.141.59.jar";

	List<String> demPass = new ArrayList<String>();
	List<String> demFail = new ArrayList<String>();

	// Thiết Lập Excel
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

	// Test Login
	@Test(groups = "selenium", priority = 1)
	// Test Login
	public void Test() throws Exception {
		try {
			// Lấy Đường dẫn Login
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Login.jsp";
			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/index.jsp";
			TestNGResults.put("1", new Object[] { "ID", "Test Data", "Expected Results", "Actual Results", "Status" });
			//Duyêt Data từ Excel
			List<User> list = li.list(0);
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				//Điền dữ Liệu
				driver.findElement(ByName.name("username")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("username")).sendKeys(list.get(i).getUsername());
				driver.findElement(ByName.name("password")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("password")).sendKeys(list.get(i).getPassword());
				Thread.sleep(1000);
				//Click Chạy Login
				driver.findElement(ByName.name("btn")).click();
				Thread.sleep(1000);
                   // Kết Quả Mong Muốn Test
				if (driver.getCurrentUrl().equals(urlexpec)) {
					TestNGResults.put("2" + i,
							new Object[] { "Test_Login_" + (i + 1),
									"Login \t\n with Username = '" + list.get(i).getUsername() + "'\t\n Password = '"
											+ list.get(i).getPassword() + "'",
									"Đăng Nhập Thành Công", "Đăng Nhập Thành Công", "Pass" });
					demPass.add("Pass");

				} else {
					TestNGResults.put("2" + i,
							new Object[] { "Test_Login_" + (i + 1),
									"Login \t\n with Username = '" + list.get(i).getUsername() + "'\t\n Password = '"
											+ list.get(i).getPassword() + "'",
									"Đăng Nhập Thất Bại", "Đăng Nhập Thất Bại", "Fail" });
					TestLoginSenenium.takeSnapShot(driver, "..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_Login"+(i+1)+".png");
					demFail.add("Fail");
				}
				Assert.assertTrue(true);
			} 

		} catch (Exception e) {
			// TODO: handle exception
			TestNGResults.put("3", new Object[] { "Error", "Fill login from data (Username/Password)",
					"Login details gets filled", "Fail" });
			TestLoginSenenium.takeSnapShot(driver, "..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_Login\"+(i+1)+\".png");
			Assert.assertTrue(false);
			System.out.println(e);
		}
	}
//Test Thêm User
	@Test(groups = "selenium", priority = 2)
	public void Test1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/add_User.jsp";
			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_User.jsp";
			List<User> list = li.list_user(1);
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				//Thêm Dữ Liệu vào
				driver.findElement(ByName.name("username")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("username")).sendKeys(list.get(i).getUsername());
				driver.findElement(ByName.name("password")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("password")).sendKeys(list.get(i).getPassword());
				driver.findElement(ByName.name("fullname")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("fullname")).sendKeys(list.get(i).getFullname());
				driver.findElement(ByName.name("email")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("email")).sendKeys(list.get(i).getEmail());
				driver.findElement(ByName.name("phone")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(ByName.name("phone")).sendKeys(list.get(i).getPhone());
				driver.findElement(ByName.name("role")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Thread.sleep(3000);
				// Nhấn Nút Thêm Dữ Liệu
				driver.findElement(ByName.name("_type")).click();
				Thread.sleep(3000);
				// Kết quả mong muốn test
				if (!driver.getCurrentUrl().equals(urlexpec)) {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_createAcount_" + (i + 1),
							"Add an account with username:" +  list.get(i).getUsername() + "\t\n" +" "+ "Password:"
									+ list.get(i).getPassword() + "\t\n" +" "+ "Fullname:" + list.get(i).getFullname()
									+ "\t\n" +" "+ "Email:" + list.get(i).getEmail() + "\t\n" +" "+ "Phone:"
									+ list.get(i).getPhone() + "\t\n" +" "+ "Role:" + list.get(i).getRole() + "\t\n",
							"Thêm Thất Bại", "Thêm Thất Bại", "Fail" });
					TestLoginSenenium.takeSnapShot(driver, "..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_createAcount_"+(i+1)+".png");
					demFail.add("Fail");

				} else {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_createAcount_" + (i + 1),
							" Add an account with username:" + list.get(i).getUsername() + "\t\n" +" "+ "Password:"
									+ list.get(i).getPassword() + "'\t\n'" +" "+ "Fullname:" + list.get(i).getFullname()
									+ "\t\n" +" "+ "Email:" + list.get(i).getEmail() + "\t\n" +" "+ "Phone:"
									+ list.get(i).getPhone() + "\t\n" +" "+ "Role:" + list.get(i).getRole() + "\t\n",
							"Thêm Thành công", "Thêm Thành công", "Pass" });
					demPass.add("Pass");

				}
				Assert.assertTrue(true);
			}
			// Hiện Ngoại lệ
		} catch (Exception e) {
			TestNGResults.put("3", new Object[] { "Error", "Add Login", "Thêm Không Thành công", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} 
	}

	//Cập Nhật User
	@Test(groups = "selenium", priority = 3)
	public void Test2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_User.jsp";
			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_User.jsp";
			TestNGResults.put("1", new Object[] { "ID", "Test Data", "Expected Results", "Actual Results", "Status" });
			// Danh Sách Dữ liệu Cập nhật
			List<User> list = li.list_upuser(2);
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				int idTest = list.get(i).getId();
				if(list.get(i).getId()>0) {
					driver.navigate().to("http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Update_User.jsp?_type=UPDATE&id="+ idTest);
					driver.findElement(ByName.name("username")).click();
					driver.findElement(ByName.name("username")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("username")).sendKeys(list.get(i).getUsername());
					driver.findElement(ByName.name("password")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("password")).clear();
					driver.findElement(ByName.name("password")).sendKeys(list.get(i).getPassword());
					driver.findElement(ByName.name("fullname")).click();
					driver.findElement(ByName.name("fullname")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("fullname")).sendKeys(list.get(i).getFullname());
					driver.findElement(ByName.name("email")).click();
					driver.findElement(ByName.name("email")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("email")).sendKeys(list.get(i).getEmail());
					driver.findElement(ByName.name("phone")).click();
					driver.findElement(ByName.name("phone")).clear();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(ByName.name("phone")).sendKeys(list.get(i).getPhone());
					driver.findElement(ByName.name("role")).click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					Thread.sleep(3000);
					driver.findElement(ByName.name("_type")).click();
					Thread.sleep(3000);
				}
				// Kết quả mong muốn test
				if (driver.getCurrentUrl().equals(urlexpec)) {
					TestNGResults.put("2" + (list.size() + i), new Object[] {"Test_UpdateAcount_" + (i + 1),
							"Update an account with username:" + list.get(i).getUsername() + "\t\n" +" "+"Password:"
									+ list.get(i).getPassword() + "\t\n" +" "+ "Fullname:" + list.get(i).getFullname()
									+ "\t\n" +" "+ "Email:" + list.get(i).getEmail() + "\t\n" +" "+ "Phone:"
									+ list.get(i).getPhone() + "\t\n" +" "+"Role:" + list.get(i).getRole() + "\t\n",
							"Cập Nhật Thất Bại", "Cập Nhật Thất Bại", "Fail" });
//					TestLoginSenenium.takeSnapShot(driver, "..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_UpdateAcount_"+(i+1)+".png");
					demFail.add("Fail");

				} else {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_UpdateAcount_" + (i + 1),
							" Update an account with username:" + list.get(i).getUsername() + "\t\n" +" "+ "Password:"
									+ list.get(i).getPassword() + "\t\n" + "Fullname:" + list.get(i).getFullname()
									+ "\t\n" +" "+ "Email:" + list.get(i).getEmail() +" "+"\t\n" + "phone:"
									+ list.get(i).getPhone() + "\t\n" +" "+ "Role:" + list.get(i).getRole() + "\t\n",
							"Cập Nhật Thành công", "Cập Nhật Thành công", "Pass" });
					demPass.add("Pass");
				}
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			TestNGResults.put("3", new Object[] { "Error", "Update Login", "Cập Nhật Không Thành công", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		}
	}
	
//Xóa User
	@Test(groups = "selenium", priority = 4)
	public void Test3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_User.jsp";
			String urlexpec = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/Show_User.jsp";
			// Dữ Liệu Xóa
			List<User> list = li.list_deuser(3);
			//Duyệt Phần tử để Xóa
			for (int i = 0; i < list.size(); i++) {
				driver.get(url);
				int idTest = list.get(i).getId();
				if(list.get(i).getId()>0) {
					driver.navigate().to(
							"http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/UserController?_type=DELETE&userid="+idTest);
					Thread.sleep(1000);
				}
				// Kết Quả Mong Muôn Xóa
				if (!driver.getCurrentUrl().equals(urlexpec)) {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_DeleteAcount_" + (i + 1),
							"Delete with ID " + list.get(i).getId(), "Xóa Thất Bại", "Xóa Thất Bại", "Fail" });
					TestLoginSenenium.takeSnapShot(driver, "..\\PS10683_ASM_SOF301_NguyenThanhHau\\bug_images\\Test_deleteAcount_"+(i+1)+".png");
					demFail.add("Faild");

				} else {
					TestNGResults.put("2" + (list.size() + i), new Object[] { "Test_DeleteAcount_" + (i + 1),
							"Delete with ID " + list.get(i).getId(), "Xóa Thành công", "Xóa Thành công", "Pass" });
					demPass.add("Pass");

				}
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			TestNGResults.put("3", new Object[] { "Error", "Delete Login", "Xóa Không Thành công", "" + "Lỗi ", "Faild" });
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
			FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xls"));
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
