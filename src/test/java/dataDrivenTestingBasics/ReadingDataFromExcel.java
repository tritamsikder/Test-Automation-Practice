package dataDrivenTestingBasics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

    public static void main(String[] args) throws IOException {
        
        // Step 1: Load the Excel file using FileInputStream
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\Book1.xlsx");
        
        // Step 2: Create a workbook instance to access the .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        
        // Step 3: Select the sheet from the workbook by its name
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        
        // Step 4: Get the number of rows (note: this gives the last row index, not the total count)
        int totalRows = sheet.getLastRowNum();  // Index starts from 0
        
        // Step 5: Get the number of cells in the first row (generally the header row)
        int totalCells = sheet.getRow(0).getLastCellNum(); // Indexing starts from 1 for cell count
        
        System.out.println("Total number of rows: " + totalRows);
        System.out.println("Total number of cells: " + totalCells);
        
        // Step 6: Loop through each row
        for (int r = 0; r <= totalRows; r++) {
            // Get the current row
            XSSFRow currentRow = sheet.getRow(r);
            
            // Check if the row is null to avoid NullPointerException
            if (currentRow == null) {
                continue;
            }
            
            // Step 7: Loop through each cell in the current row
            for (int c = 0; c < totalCells; c++) {
                // Get the current cell
                XSSFCell currentCell = currentRow.getCell(c);
                
                // Check if the cell is null
                if (currentCell == null) {
                    System.out.print("NULL\t"); // Handle missing cells
                } else {
                    // Print the cell value with a tab space
                    System.out.print(currentCell.toString() + "\t");
                }
            }
            System.out.println(); // Move to next line after each row
        }
        
        // Step 8: Close the workbook and file to release resources
        workbook.close();
        file.close();
    }
}
