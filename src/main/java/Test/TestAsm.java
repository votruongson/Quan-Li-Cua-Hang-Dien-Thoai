package Test;

import java.io.File;
import java.io.FileInputStream;
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
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.poly.model.User;
import com.sun.media.sound.InvalidFormatException;
import com.techbeamers.testng.UIMap;

public class TestAsm {
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	Map<String, Object[]>TestNGResult;
	Lists li = new Lists();
	public static String driverPath="D:\\Java 5\\selenium-server-standalone-3.141.59.jar";
	List<String> demPass = new ArrayList<String>();
	List<String> demFail = new ArrayList<String>();
	
  @Test(description="Open the TestNG Demo Website for login Test",priority = 1)
  public void LaunchWebsite() throws Exception{
	  try {
		  driver.get("http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Login.jsp");
		  driver.manage().window().maximize();
		  TestNGResult.put("2", new Object[] {1d,"Navigate to demo website","Site gets opened","Pass"});
		  	
	  }catch(Exception e) {
		  TestNGResult.put("2", new Object[] {1d,"Navigate to demo website","Site gets opened","Fail"});
  Assert.assertTrue(false);
	  }
  }
  @Test(description="Fill the login Details",priority = 2)
  public void FillLoginDetails() throws Exception {
	  try {
		  WebElement username=driver.findElement(uimap.getLocator("Username_field"));
		  username.sendKeys(datafile.getData("username"));
		  WebElement password =driver.findElement(uimap.getLocator("Password_field"));
		  password.sendKeys(datafile.getData("password"));
		  Thread.sleep(1000);
		  TestNGResult.put("3", new Object[] {2d,"Fill Login from Data(Username/Password)","Login details get filled","Pass"});
	  }catch(Exception e) {
		  TestNGResult.put("3", new Object[] {2d,"Fill Login from Data(Username/Password)","Login details get filled","Fail"});
		  Assert.assertTrue(false);
	  }
  }
  @Test(description="Perform Login",priority = 3)
  public void DoLogin() throws Exception{
	  try {
		  WebElement login =driver.findElement(uimap.getLocator("Login_button"));
		  login.click();
		  Thread.sleep(1000);
		  WebElement onlineuser=driver.findElement(uimap.getLocator("online_user"));
		  TestNGResult.put("4", new Object[] {3d,"Click Login and verify welcome message","Login success","Pass"});
		  
	  }catch(Exception e) {
		  TestNGResult.put("4", new Object[] {3d,"Click Login and verify welcome message","Login success","Fail"});
		  Assert.assertTrue(false);
	  }
  }
  @BeforeClass(alwaysRun=true)
  public void suiteSetUp() {
	  workbook=new HSSFWorkbook();
	  sheet=workbook.createSheet("TestNG Result Summary");
	  TestNGResult=new LinkedHashMap<String, Object[]>();
	  TestNGResult.put("1",new Object[] {"Test Step No.","Action","Expected Output","Actual Output"});
	  try {
		  workingDir=System.getProperty("user.dir");
		  datafile=new UIMap(workingDir + "\\Resources\\datafile.properties");
		  uimap=new UIMap(workingDir + "\\Resources\\locator.properties");
		  System.setProperty("webdriver.chrome.driver","D:\\Java 5\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }catch(Exception e) {
		  throw new IllegalStateException("Can't start the Firefox Web Driver",e);
	  }
  }
	@org.testng.annotations.Test(groups = "selenium", priority = 4)
	public void Test1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "http://localhost:8080/PS10683_ASM_SOF301_NguyenThanhHau/Admin/add_User.jsp";
			List<User> list = li.list(1);

			for (int i = 0; i < list.size(); i++) {

				 driver.get(url);	
				  driver.findElement(ByName.name("username")).click();;
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.findElement(ByName.name("username")).sendKeys(list.get(i).getUsername());
				  driver.findElement(ByName.name("password")).click();;
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.findElement(ByName.name("password")).sendKeys(list.get(i).getPassword());;;
				  driver.findElement(ByName.name("fullname")).click();;
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.findElement(ByName.name("fullname")).sendKeys(list.get(i).getFullname());;;
				  driver.findElement(ByName.name("email")).click();;
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.findElement(ByName.name("email")).sendKeys(list.get(i).getEmail());;;
				  driver.findElement(ByName.name("phone")).click();;
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				  driver.findElement(ByName.name("phone")).sendKeys(list.get(i).getPhone());;;
				  driver.findElement(ByName.name("role")).click();;
					 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				if(list.get(i).getRole()==1) {
					 driver.findElement(ByName.xpath("//*[@id=\"role\"]/option[1]")).click();;
				}else {
					 driver.findElement(ByName.xpath("//*[@id=\"role\"]/option[2]")).click();;
				}
				  driver.findElement(ByName.name("submit")).click();;
				  driver.manage().timeouts().implicitlyWait(525, TimeUnit.SECONDS);
				  Thread.sleep(300);
				// *[@id="dataTable"]/tbody/tr[3]/td[1]/b/a
				// Ket mong muon thong
				// ket qua mong muon dang nhap thanh cong
				List<User> count = li.list(0);
				String error = driver.findElement(ByName.xpath("/html/body/div[2]/span[3]")).getText();
				System.out.println(error);
				if (error.equals("Vui lòng kiểm tra các lỗi nhập liệu")) {
					TestNGResult.put("2" + (count.size() + i), new Object[] { "Test_createAcount_" + (i + 1),
							"Add an account with username:" + list.get(i).getUsername() + "\t\n" + "password:"
									+ list.get(i).getPassword() + "\t\n" + "fullname:" + list.get(i).getFullname()
									+ "\t\n" + "email:" + list.get(i).getEmail() + "\t\n" + "phone:" + list.get(i).getPhone() + "\t\n" + "role:"
									+ list.get(i).getRole() + "\t\n",
							"Thêm Thành công", error, "FAILDED" });
					demFail.add("Faild");

				} else {
					TestNGResult.put("2" + (count.size() + i), new Object[] { "Test_createAcount_" + (i + 1),
							" Add an account with username:" + list.get(i).getUsername() + "\t\n" + "password:"
									+ list.get(i).getPassword() + "\t\n" + "fullname:" + list.get(i).getFullname()
									+ "\t\n" + "email:" + list.get(i).getEmail() + "\t\n" + "phone:" + list.get(i).getPhone() +"\t\n" +"role:"
									+ list.get(i).getRole() + "\t\n",
							"Thêm Thành công", error, "PASSED" });
					demPass.add("PASSED");

				}
				Assert.assertTrue(true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			TestNGResult.put("3", new Object[] { "Error", "Add Login", "Thêm Thành công", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		

		}

	}
	  @AfterClass
	  public void suiteTearDown() {
		  Set<String> keyset=TestNGResult.keySet();
		  int rownum=0;
		  for(String key: keyset) {
			  Row row=sheet.createRow(rownum++);
			  Object[] objArr=TestNGResult.get(key);
			  int cellnum=0;
			  for(Object obj : objArr) {
				  Cell cell=row.createCell(cellnum++);
				  if(obj instanceof Date)
					  cell.setCellValue((Date) obj);
				  else if(obj instanceof Boolean)
					  cell.setCellValue((Boolean) obj);
				  else if(obj instanceof String)
					  cell.setCellValue((String) obj);
				  else if(obj instanceof Double)
					  cell.setCellValue((Double) obj);
			  }
		  }
		  try {
			  FileOutputStream out=new FileOutputStream(new File("SaveTestNGResultToExcel.xls"));
			  workbook.write(out);
			  out.close();
			  System.out.println("Successfully saved Selenium Webdriver TestNG result to Excel File!!!");
			  
		  }catch (FileNotFoundException e) {
		e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		  driver.close();
		  driver.quit();
	  }
}
