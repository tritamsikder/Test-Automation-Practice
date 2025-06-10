package dataDrivenTestingBasics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInSpecificRowAndCell {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\Book4.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook();
		
		XSSFSheet sheet = book.createSheet("Sheet1");
		
		Scanner sc = new Scanner(System.in);
		
		XSSFRow row = sheet.createRow(5);
		XSSFCell cell = row.createCell(4);
		System.out.println("Enter your data: ");
		cell.setCellValue(sc.next());
		
		book.write(file);
		book.close();
		file.close();
		
		System.out.println("File created");
	}
	
	

}
