package corepackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import excelreader.ExcelReader;


public class Actions {

	public static WebDriver driver=null;
	public static Alert alert;
	//Method which initilize the driver object
	
	public static void initDriver(){
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Hvuser\\Downloads\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://adactin.com/HotelApp/index.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		
	

		
	}
 
	//method for Action enter text
	
	public static void enterText(String LocatorType,String Locator,String ActionValue){
		
		System.out.println(LocatorType+" "+Locator+" "+ActionValue);
		
		if(LocatorType.equalsIgnoreCase("id")){
			
			driver.findElement(By.id(Locator)).sendKeys(ActionValue);
		}else if(LocatorType.equalsIgnoreCase("xpath")){
			
			driver.findElement(By.xpath(Locator)).sendKeys(ActionValue);
		}else if(LocatorType.equalsIgnoreCase("name")){
			
			driver.findElement(By.name(Locator)).sendKeys(ActionValue);
		}
		
	}
	
	//method for Action click
	
     public static void click(String LocatorType,String Locator){
		
		if(LocatorType.equalsIgnoreCase("id")){
			
			driver.findElement(By.id(Locator)).click();
		}else if(LocatorType.equalsIgnoreCase("xpath")){
			
			driver.findElement(By.xpath(Locator)).click();
		}else if(LocatorType.equalsIgnoreCase("name")){
			
			driver.findElement(By.name(Locator)).click();
		}
	}
	

   //method for Action Select
     
     public static void select(String LocatorType,String Locator,String ActionValue){
    	 
 		if(LocatorType.equalsIgnoreCase("id")){
 			new Select(driver.findElement(By.id(Locator))).selectByVisibleText(ActionValue);
 		
 		}else if(LocatorType.equalsIgnoreCase("xpath")){
 			new Select(driver.findElement(By.xpath(Locator))).selectByVisibleText(ActionValue);
 		
 		}else if(LocatorType.equalsIgnoreCase("name")){
 			new Select(driver.findElement(By.name(Locator))).selectByVisibleText(ActionValue);
 			
 		}
 	}
     
   //method for adding explicit wait
     
     public static void wait(String LocatorType,String Locator,String ActionValue){
 		
 		if(LocatorType.equalsIgnoreCase("id")){
 			
 			int time=Integer.parseInt(ActionValue);
 			new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(By.id(Locator)));
 			
 		}else if(LocatorType.equalsIgnoreCase("xpath")){
 			
 			int time=Integer.parseInt(ActionValue);
 		 	new WebDriverWait(driver,time).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
 		}else if(LocatorType.equalsIgnoreCase("name")){
 			
 			
 		}
 	
     
     }	
     
     public static void tab(String LocatorType,String Locator){
 		
 		//System.out.println(LocatorType+" "+Locator+" ");
 		
 		if(LocatorType.equalsIgnoreCase("id")){
 			
 			driver.findElement(By.id(Locator)).sendKeys(Keys.TAB);
 		}else if(LocatorType.equalsIgnoreCase("xpath")){
 			
 			driver.findElement(By.xpath(Locator)).sendKeys(Keys.TAB);
 		}else if(LocatorType.equalsIgnoreCase("name")){
 			
 			driver.findElement(By.name(Locator)).sendKeys(Keys.TAB);
 		}
 		
 	}
     
     public static void clear(String LocatorType,String Locator){
  		
  		//System.out.println(LocatorType+" "+Locator+" ");
  		
  		if(LocatorType.equalsIgnoreCase("id")){
  			
  			driver.findElement(By.id(Locator)).clear();
  		}else if(LocatorType.equalsIgnoreCase("xpath")){
  			
  			driver.findElement(By.xpath(Locator)).clear();
  		}else if(LocatorType.equalsIgnoreCase("name")){
  			
  			driver.findElement(By.name(Locator)).clear();
  		}
  		
  	}
     
     public static void read(String LocatorType,String Locator,String ActionValue) throws IOException{
   		
   		//System.out.println(LocatorType+" "+Locator+" ");
   		
   		if(LocatorType.equalsIgnoreCase("id")){
   			
   			String textToWrite=driver.findElement(By.id(Locator)).getAttribute(ActionValue).toString();
   			ExcelReader.writeExcelData(textToWrite);
   			
   		}else if(LocatorType.equalsIgnoreCase("xpath")){
   			String textToWrite=driver.findElement(By.xpath(Locator)).getAttribute(ActionValue).toString();
   			ExcelReader.writeExcelData(textToWrite);
   			
   		}else if(LocatorType.equalsIgnoreCase("name")){
   			
   			String textToWrite=driver.findElement(By.name(Locator)).getAttribute(ActionValue).toString();
   			ExcelReader.writeExcelData(textToWrite);
   		}
   		
   	}
     
     
     public static void alert(String LocatorType) throws IOException{
    		
    		//System.out.println(LocatorType+" "+Locator+" ");
    		
    		if(LocatorType.equalsIgnoreCase("switchTo")){
    			alert=driver.switchTo().alert();
    			
    		}else if(LocatorType.equalsIgnoreCase("accept")){
    		    alert.accept();
    			
    		}else if(LocatorType.equalsIgnoreCase("dismiss")){
    			alert.dismiss();
    			
    		}else if(LocatorType.equalsIgnoreCase("sendkeys")){
    			alert.sendKeys("test text to be passed from excel");
    			
    		}
    		
    	}
     
     
     //************************Methods for test cases***************************************************************************************************************
     
   public static void Login() throws InvalidFormatException, IOException{
    	 
    	 for (int rowNo=1;rowNo<=ExcelReader.rowCount("Login");rowNo++){
  			
    		 int colNo=0;
 				String actionParameter=ExcelReader.readExcelData("Login", rowNo, colNo);
 		    	 if (actionParameter.equalsIgnoreCase("enterText")){
 		    		 enterText(ExcelReader.readExcelData("Login", rowNo, colNo+1),ExcelReader.readExcelData("Login", rowNo, colNo+2),ExcelReader.readExcelData("Login", rowNo, colNo+3)); 
 		    	 }else if(actionParameter.equalsIgnoreCase("click")){
 		    		click(ExcelReader.readExcelData("Login", rowNo, colNo+1),ExcelReader.readExcelData("Login", rowNo, colNo+2));	 
 		    	 }else if(actionParameter.equalsIgnoreCase("wait")){
 		    		wait(ExcelReader.readExcelData("Login", rowNo, colNo+1),ExcelReader.readExcelData("Login", rowNo, colNo+2),ExcelReader.readExcelData("Login", rowNo, colNo+3));
 		    		 
 		    	 }else if(actionParameter.equalsIgnoreCase("tab")){
  		    		tab(ExcelReader.readExcelData("Login", rowNo, colNo+1),ExcelReader.readExcelData("Login", rowNo, colNo+2));
 				} else if(actionParameter.equalsIgnoreCase("select")){
 					select(ExcelReader.readExcelData("Login", rowNo, colNo+1),ExcelReader.readExcelData("Login", rowNo, colNo+2),ExcelReader.readExcelData("Login", rowNo, colNo+3));
 		        }else if(actionParameter.equalsIgnoreCase("select")){
 				clear(ExcelReader.readExcelData("Login", rowNo, colNo+1),ExcelReader.readExcelData("Login", rowNo, colNo+2));
 	   }
 		   }
    	}//end of login function
     
     
    public static void Book_Hotel() throws InvalidFormatException, IOException{
    	
    	for (int rowNo=1;rowNo<=ExcelReader.rowCount("Book_Hotel");rowNo++){
  			
   		 int colNo=0;
				String actionParameter=ExcelReader.readExcelData("Book_Hotel", rowNo, colNo);
		    	 if (actionParameter.equalsIgnoreCase("enterText")){
		    		 enterText(ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+2),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+3)); 
		    	 }else if(actionParameter.equalsIgnoreCase("click")){
		    		click(ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+2));	 
		    	 }else if(actionParameter.equalsIgnoreCase("wait")){
		    		wait(ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+2),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+3));
		    		 
		    	 }else if(actionParameter.equalsIgnoreCase("tab")){
 		    		tab(ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+2));
				} else if(actionParameter.equalsIgnoreCase("select")){
					select(ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+2),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+3));
		   }else if(actionParameter.equalsIgnoreCase("select")){
				clear(ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+2));
	   }else if(actionParameter.equalsIgnoreCase("read")){
			read(ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+2),ExcelReader.readExcelData("Book_Hotel", rowNo, colNo+3));
        }
		    	 
    	
    	}	
    }//end of book hotel
    
     public static void Search_Hotel() throws InvalidFormatException, IOException{
    	
    	for (int rowNo=1;rowNo<=ExcelReader.rowCount("Search_Hotel");rowNo++){
  			
   		 int colNo=0;
				String actionParameter=ExcelReader.readExcelData("Search_Hotel", rowNo, colNo);
		    	 if (actionParameter.equalsIgnoreCase("enterText")){
		    		 //need to chnage harcoded text
		    		 enterText(ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+2),ExcelReader.readExcelDataForOutput(0, 1)); 
		    	 }else if(actionParameter.equalsIgnoreCase("click")){
		    		click(ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+2));	 
		    	 }else if(actionParameter.equalsIgnoreCase("wait")){
		    		wait(ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+2),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+3));
		    		 
		    	 }else if(actionParameter.equalsIgnoreCase("tab")){
 		    		tab(ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+2));
				} else if(actionParameter.equalsIgnoreCase("select")){
					select(ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+2),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+3));
		   }else if(actionParameter.equalsIgnoreCase("select")){
				clear(ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+2));
	   }else if(actionParameter.equalsIgnoreCase("read")){
			read(ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+1),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+2),ExcelReader.readExcelData("Search_Hotel", rowNo, colNo+3));
        }
		    	 
    	
    	}	
    }//end of search hotel
     
     
     public static void Cancel_Booking() throws InvalidFormatException, IOException{
     	
     	for (int rowNo=1;rowNo<=ExcelReader.rowCount("Cancel_Booking");rowNo++){
   			
    		 int colNo=0;
 				String actionParameter=ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo);
 		    	 if (actionParameter.equalsIgnoreCase("enterText")){
 		    		enterText(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+2),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+3));  
 		    	 }else if(actionParameter.equalsIgnoreCase("click")){
 		    		click(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+2));	 
 		    	 }else if(actionParameter.equalsIgnoreCase("wait")){
 		    		wait(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+2),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+3));
 		    		 
 		    	 }else if(actionParameter.equalsIgnoreCase("tab")){
  		    		tab(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+2));
 				} else if(actionParameter.equalsIgnoreCase("select")){
 					select(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+2),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+3));
 		   }else if(actionParameter.equalsIgnoreCase("select")){
 				clear(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+2));
 	   }else if(actionParameter.equalsIgnoreCase("read")){
 			read(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+2),ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+3));
         }else if(actionParameter.equalsIgnoreCase("Alert")){
 			alert(ExcelReader.readExcelData("Cancel_Booking", rowNo, colNo+1));
         }
 		    	 
     	
     	}	
     }//end of cancel hotel booking
    
    
     
     public static void Logout() throws InvalidFormatException, IOException{
    	 
    		for (int rowNo=1;rowNo<=ExcelReader.rowCount("Logout");rowNo++){
      			
    	   		 int colNo=0;
    					String actionParameter=ExcelReader.readExcelData("Logout", rowNo, colNo);
    			    	 if (actionParameter.equalsIgnoreCase("enterText")){
    			    		 enterText(ExcelReader.readExcelData("Logout", rowNo, colNo+1),ExcelReader.readExcelData("Logout", rowNo, colNo+2),ExcelReader.readExcelData("Logout", rowNo, colNo+3)); 
    			    	 }else if(actionParameter.equalsIgnoreCase("click")){
    			    		click(ExcelReader.readExcelData("Logout", rowNo, colNo+1),ExcelReader.readExcelData("Logout", rowNo, colNo+2));	 
    			    	 }else if(actionParameter.equalsIgnoreCase("wait")){
    			    		wait(ExcelReader.readExcelData("Logout", rowNo, colNo+1),ExcelReader.readExcelData("Logout", rowNo, colNo+2),ExcelReader.readExcelData("Logout", rowNo, colNo+3));
    			    		 
    			    	 }else if(actionParameter.equalsIgnoreCase("tab")){
    	 		    		tab(ExcelReader.readExcelData("Logout", rowNo, colNo+1),ExcelReader.readExcelData("Logout", rowNo, colNo+2));
    					} else if(actionParameter.equalsIgnoreCase("select")){
    						select(ExcelReader.readExcelData("Logout", rowNo, colNo+1),ExcelReader.readExcelData("Logout", rowNo, colNo+2),ExcelReader.readExcelData("Logout", rowNo, colNo+3));
    			   }else if(actionParameter.equalsIgnoreCase("select")){
    					clear(ExcelReader.readExcelData("Logout", rowNo, colNo+1),ExcelReader.readExcelData("Logout", rowNo, colNo+2));
    		   }
    			    	 
    	    	
    	    	}
    	 
    	 
    	 
     }//logout end
     
     
     public static void close(){
    	 
    	 driver.close();
    	 driver.quit();
    	 
     }
     
     
     //introducing public static main for debugging purposes
     
     public static void main(String[] args) throws InvalidFormatException, IOException, InterruptedException {
 		/*
    	initDriver();
    	Login();
    	Book_Hotel();
    	Search_Hotel();
    	Cancel_Booking();
    	Logout();
    	 */
 	}//end of test main function
       

    //Methods for test cases
         
     
}//end of class
