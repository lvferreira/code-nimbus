package tests;

import java.io.IOException;
import java.util.Iterator;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;

public class ExcelDataDriven {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//fileInputStream argument
		String excelData = System.getProperty("user.dir") 
				+ "\\test-data\\excel_data.xlsx";
			System.out.println(excelData);
		FileInputStream fileStream = new FileInputStream(excelData);
		//@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				// Identify TestCases column by scanning the entire 1st row
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Get sheet rows
				Iterator<Row> rows = sheet.iterator(); //sheet is collection of rows
				Row firstRow = rows.next();
				// Get row cells
				Iterator<Cell> cells = firstRow.cellIterator(); //row is collection of cells
				// Get cell data
				int j=0;
				int column=0;
				while(cells.hasNext()) {
					Cell data = cells.next();
					if(data.getStringCellValue().equalsIgnoreCase("TestCases")) {
						//desired column
						column = j;
					}
					j++;
				}
				System.out.println(column);
			}
		}
		workbook.close();
		fileStream.close();

	}

}
