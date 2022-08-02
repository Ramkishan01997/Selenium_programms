package package15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelFile {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testData\\new.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("Sheet1");
		
		
		
		for(int i=0;i<=3;i++) {
			XSSFRow currentrow=sheet.createRow(i);
			for(int j=0;j<3;j++) {
				currentrow.createCell(j).setCellValue("java");
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("created excel sheet");
	}

}
