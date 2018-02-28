package statuschange;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class Inprogress {
	
		 public static String s2 = "Health Heal";
		 public static String sh ="";
		 public static String sh1 = "" ;
		 public static void main(String[] args)throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
		 {
				FileInputStream fis = new FileInputStream("E:/Scripts/Login/Excel/shashi.xlsx");
				Workbook wb = WorkbookFactory.create(fis);
				 int count = wb.getSheet("Sheet1").getLastRowNum();
				System.out.println(count);
				 //TO get the access to the sheet
				 for(int i = 0;i<=count;i++)
				 {
					 for(int j=0;j<2;j++)
					 {
						 if(j==0)
						 {
							 String sn1 = wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();	
							  sh =  new String (sn1);
								System.out.print(sh);
								System.out.print("shashi");
						 }
						 else {
							 String sn = wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
								 sh1 =  new String(sn);	
								System.out.print(sh1);
						 }
						
					 }
				//String sn1 = wb.getSheet("Sheet1").getRow(0).getCell(0).getStringCellValue();	
				//String sh =  new String (sn1);
					//String sn = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
					//String sh1 =  new String(sn);
					 
		
					//System.out.print(sh1);
					
					
		 {
				 
						System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
						WebDriver driver = new ChromeDriver();
						
						
						driver.manage().window().maximize();
						driver.get("http://testcare.healthheal.in");
						driver.findElement(By.xpath("//a[.= 'Login']")).click();
						driver.findElement(By.id("email")).sendKeys(sh);
						Thread.sleep(2000);
						driver.findElement(By.id("password")).sendKeys(sh1);
						driver.findElement(By.id("btnSignIn")).click();
						Thread.sleep(2000);
						String s1 =  driver.getTitle();
						System.out.println(s1);
						
						if(s1.equals(s2)) 
						{
							
							System.out.println("pass");
						}
						else
						{
							System.out.println("fail");
							
						}
						driver.findElement(By.xpath("//a[@href='/adminassign?name=Murtaza&status=Converted']")).click();
						driver.findElement(By.xpath("//td[@class='footable-visible']/../td[1]")).click();
						WebElement Element= driver.findElement(By.id("ServiceStatus"));
						Select s = new Select (Element);
						s.selectByVisibleText("Deferred");
//						 WebElement Element1 = driver.findElement(By.id("followupdate"));
//						 Element1.click();
						 driver.findElement(By.xpath("//input[@class='followupdaterequired']")).click();
						 driver.findElement(By.xpath("//input[@class='followupdaterequired']")).sendKeys("02022004");
						 Thread.sleep(10000);
						 
						 
//						
//						Actions actions = new Actions(driver);
//						actions.moveToElement(Element1);
//						actions.click();
//						actions.sendKeys("02-02-2004");
//						actions.build().perform();

					
						
					
//						 JavascriptExecutor js=(JavascriptExecutor) driver;
//						 js.executeScript("document.getElementByClass('followupdaterequired').focus()");

}}}}