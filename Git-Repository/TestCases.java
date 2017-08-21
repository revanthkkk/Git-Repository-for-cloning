package testpackage;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import corepackage.Actions;

public class TestCases {

	public static WebDriver driver=null;
	
	@BeforeClass
	public void beforeClass() throws FileNotFoundException, InvalidFormatException, IOException{
		Actions.initDriver();
	
	}
	

	@Test(priority=1)
	public void Login() throws InvalidFormatException, IOException{
	Actions.Login();		
		
	}
	
	@Test(priority=2)
	public void Book_Hotel() throws InvalidFormatException, IOException{
			
	Actions.Book_Hotel();	
	}
	
	@Test(priority=3)
	public void search_Hotel() throws InvalidFormatException, IOException{
	
	Actions.Search_Hotel();
		
	}
	
	@Test(priority=4)
	public void Cancel_Hotel() throws InvalidFormatException, IOException{
			
	Actions.Cancel_Booking();	
	}
	
	@Test(priority=5)
	public void Logout() throws InvalidFormatException, IOException{
			
	Actions.Logout();
	}
	
 
   
   

}
