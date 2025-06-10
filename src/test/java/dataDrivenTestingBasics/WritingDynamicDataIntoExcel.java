package dataDrivenTestingBasics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		// Creating a file output stream to write data into Book3.xlsx file
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\Book3.xlsx");
		
		// Creating a new workbook in .xlsx format
		XSSFWorkbook book = new XSSFWorkbook();
		
		// Creating a sheet named "Sheet1" in the workbook
		XSSFSheet sheet = book.createSheet("Sheet1");
		
		// Creating a Scanner object to take input from the user
		Scanner sc = new Scanner(System.in);
		
		// Asking the user to input the number of rows to write
		System.out.println("Enter row number: ");
		int noOfRow = sc.nextInt();
		
		// Asking the user to input the number of cells (columns) per row
		System.out.println("Enter cell number: ");
		int noOfCell = sc.nextInt();
		
		// Looping through the number of rows
		for(int r = 0; r <= noOfRow; r++) {
			// Creating a new row in the sheet
			XSSFRow row = sheet.createRow(r);
			
			// Looping through the number of cells in each row
			for(int c = 0; c < noOfCell; c++) {
				// Creating a new cell in the current row
				XSSFCell cell = row.createCell(c);
				
				// Taking input from the user and setting it as the cell value
				cell.setCellValue(sc.next());
			}
		}
		
		// Writing the workbook data to the Excel file
		book.write(file);
		
		// Closing the workbook and the output file stream
		book.close();
		file.close();
		
		// Displaying confirmation message
		System.out.println("file is created");
	}
}
