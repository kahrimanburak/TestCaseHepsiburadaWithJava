package ExcelFolder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Pages.BaseClass;

public class GetUserData {

public static FileInputStream excelFile;
	
	public XSSFSheet openExcel() throws IOException {
		File file = new File("./Documents/UsersFiles.xlsx");
		excelFile = new FileInputStream(file);
		XSSFWorkbook Data = new XSSFWorkbook(excelFile);
		XSSFSheet Sheet = Data.getSheetAt(0);
		
		return Sheet;
	}
	
	public void closeExcel() throws IOException {
		excelFile.close();
	}
	
	public String getUsername() throws IOException {
		XSSFSheet sheet = openExcel();
		String username = sheet.getRow(1).getCell(0).getStringCellValue();
		closeExcel();
		return username;
	}
	
	public String getPassword() throws IOException {
		XSSFSheet Sheet = openExcel();
		String password =  Sheet.getRow(1).getCell(1).getStringCellValue();
		closeExcel();
		return password;
	}
	
	
}
