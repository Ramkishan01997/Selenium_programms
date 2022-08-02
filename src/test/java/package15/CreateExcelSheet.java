package package15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelSheet {
	// File--->Work book-->Sheet--->Rows-->Cells
	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\new.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Sheet1");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i <= 3; i++) {
			XSSFRow currentrow = sheet.createRow(i);
			for (int j = 0; j < 3; j++) {

				System.out.println(" Enter value");
				String value = sc.next();
				currentrow.createCell(j).setCellValue(value);
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("created excel sheet");

	}

}
