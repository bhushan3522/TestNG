package DataTesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {
	
	public static Object[][] getData(String WorkbookName, String SheetName) {
		
		Workbook wb = null;
		try {
			FileInputStream fis = new FileInputStream(WorkbookName);
			wb = WorkbookFactory.create(fis);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		Sheet sheet = wb.getSheet(SheetName);
		Object data[][]= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}

}
