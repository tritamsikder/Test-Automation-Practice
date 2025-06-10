package dataDrivenTestingBasics;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

    public static void main(String[] args) throws IOException {
        
        // Step 1: Create a FileOutputStream to write the Excel file
        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\TestData\\Book2.xlsx");
        
        // Step 2: Create a new workbook (XSSFWorkbook for .xlsx format)
        XSSFWorkbook workbook = new XSSFWorkbook();
        
        // Step 3: Create a new sheet in the workbook
        XSSFSheet sheet = workbook.createSheet("Sheet1");
        
        // Step 4: Create the first row and add data
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("abc");
        row1.createCell(1).setCellValue("pqr");
        row1.createCell(2).setCellValue("xyz");
        
        // Step 5: Create the second row and add data
        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("aaa");
        row2.createCell(1).setCellValue("bbb");
        row2.createCell(2).setCellValue("yyy");
        
        // Step 6: Create the third row and add data
        XSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("rrr");
        row3.createCell(1).setCellValue("eee");
        row3.createCell(2).setCellValue("hhh");
        
        // Step 7: Write the data to the Excel file
        workbook.write(file);
        
        // Step 8: Close the workbook and output stream
        workbook.close();
        file.close();
        
        // Step 9: Confirmation message
        System.out.println("File is created...");
    }
}
