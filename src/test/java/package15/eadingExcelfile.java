package package15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class eadingExcelfile {
////File--->Workbook-->Sheet--->Rows-->Cells
	public static void main(String[] args) throws IOException {

//		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\testData\\data1.csv");
		FileInputStream file = new FileInputStream("C:\\Users\\ramkishan\\Desktop\\LoginData.xlsx");
       XSSFWorkbook workbook=new XSSFWorkbook(file);
       XSSFSheet sheet=workbook.getSheet("Sheet1");
       int rowcount=sheet.getLastRowNum();
       int colcount=sheet.getRow(1).getLastCellNum();
       
       System.out.println(" no of rows "+rowcount);
       System.out.println("col count "+colcount);
       
       for(int i=0;i<=rowcount;i++) {
    	   XSSFRow currentrow=sheet.getRow(i);
    	   for(int j=0;j<colcount;j++){
    		   String value=currentrow.getCell(j).toString();
    		   System.out.print(value+ " ");
    	   }
    	   System.out.println();
       }
       workbook.close();
       file.close();
		

	}

}
