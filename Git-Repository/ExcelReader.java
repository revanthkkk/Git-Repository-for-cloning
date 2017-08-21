package excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	public static File f;
	public static FileInputStream fis;
	public static FileOutputStream fout;
	public static String readfilepath;
	public static String writefilepath;
	public static Workbook workbook;
	public static Sheet sheet;
	public static int counter=1;
	
	
	//main fuc for debugging
	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		//System.out.println(rowCount("Login"));
		//System.out.println(columnCount("Login",0));
		
		/*
		for (int rowNo=1;rowNo<=rowCount("Login");rowNo++){
			
			for(int colNo=0;colNo<columnCount("Login",rowNo);colNo++){
				
				System.out.print(readExcelData("Login",rowNo,colNo)+" ");
			}
			
			System.out.println();
			
		}*/
		
		//System.out.println(ExcelReader.readExcelDataForOutput(0, 1));

	}
	
	public static void writeExcelData(String textToWrite) throws IOException{
		writefilepath="C:/Users/Hvuser/workspace/KeywordDrivenFrameWork/src/testoutputdata/TestOutput.xlsx";
		f=new File(writefilepath);
		fout=new FileOutputStream(f);
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		String sheetName = "TestRun"+counter;
		XSSFSheet    sheet=workbook.createSheet(sheetName);
		Row row=sheet.createRow(0);
		Cell cellA=row.createCell(0);
		Cell cellB=row.createCell(1);
		cellA.setCellValue("Booking ID");
		cellB.setCellValue(textToWrite);
		
		workbook.write(fout);
		fout.close();
		
	}
	
	
	
	public static String readExcelData(String sheetName,int rowNo,int colNo) throws InvalidFormatException, IOException{
		
		readfilepath="C:/Users/Hvuser/workspace/KeywordDrivenFrameWork/src/testData/KeywordDrivenExcelSheet.xlsx";
	    f=new File(readfilepath);
		fis=new FileInputStream(f);
		workbook=WorkbookFactory.create(fis);
		sheet=workbook.getSheet(sheetName);
		
		Row row=sheet.getRow(rowNo);
		Cell cell=row.getCell(colNo);
		String cellValue=cell.getStringCellValue();
		fis.close();
		return cellValue;
		
	}
	
	public static int rowCount(String sheetName) throws InvalidFormatException, IOException{
		
		readfilepath="C:/Users/Hvuser/workspace/KeywordDrivenFrameWork/src/testData/KeywordDrivenExcelSheet.xlsx";
	    f=new File(readfilepath);
		fis=new FileInputStream(f);
		workbook=WorkbookFactory.create(fis);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		fis.close();
		
		return rowCount;
	}

  public static int columnCount(String sheetName,int rowNo) throws InvalidFormatException, IOException{
		
	    readfilepath="C:/Users/Hvuser/workspace/KeywordDrivenFrameWork/src/testData/KeywordDrivenExcelSheet.xlsx";
	    f=new File(readfilepath);
		fis=new FileInputStream(f);
		workbook=WorkbookFactory.create(fis);
		sheet=workbook.getSheet(sheetName); 
		Row row=sheet.getRow(rowNo);
		int colCount=row.getLastCellNum();
		fis.close();
		
		return colCount;
	}
  
  public static String readExcelDataForOutput(int rowNo,int colNo) throws InvalidFormatException, IOException{
		
		readfilepath="C:/Users/Hvuser/workspace/KeywordDrivenFrameWork/src/testoutputdata/TestOutput.xlsx";
	    f=new File(readfilepath);
		fis=new FileInputStream(f);
		workbook=WorkbookFactory.create(fis);
		String sheetName=workbook.getSheetName(0);
		sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rowNo);
		Cell cell=row.getCell(colNo);
		String cellValue=cell.getStringCellValue();
		fis.close();
		return cellValue;
		
	}
	
}
