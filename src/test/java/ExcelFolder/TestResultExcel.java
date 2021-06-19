package ExcelFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Pages.BaseClass;

public class TestResultExcel {

	public static FileInputStream excelFile;
	public static XSSFWorkbook workBook;
	LocalDateTime atNow ;
	DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH");
	
	public XSSFSheet openExcel() throws IOException {
		
		atNow = LocalDateTime.now();
		workBook = new XSSFWorkbook();
		XSSFSheet Sheet = workBook.createSheet("Test-"+dateTime.format(atNow));
		return Sheet;
	}
	
	public void WriteExcel(XSSFSheet Sheet,ArrayList<String> MessageList) throws IOException {
		
		int testStep = 1;
		for(int i = 0 ; i < MessageList.size() ; i++) {
			Row row = Sheet.createRow(i);
			Cell cell = row.createCell(0);
			
			if(MessageList.get(i).contains(testStep+ " test")) {
				cell.setCellValue(MessageList.get(i));
			}else {
				cell.setCellValue(testStep+"test is failed");
				i = i-1;
			}
			testStep = testStep+1;
		}
		writeWorkBook(workBook);
	}
	
	
	public void writeWorkBook(XSSFWorkbook workbook)
	 {
	  try 
	  {
	       FileOutputStream out = new FileOutputStream(new File("./TestResult/TestResult.xlsx"));
	       workbook.write(out);
	       out.close();
	  } 
	  catch (FileNotFoundException e) {
	    e.printStackTrace();
	  } 
	  catch (IOException e) {
	       e.printStackTrace();
	  }
	 }
	
	
}
