import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> arreglo = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("C://Automation//DataExel//dataDemo.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int numbersSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numbersSheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("testData")) {
				// Sheet es una colecion de rows
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				// Rows es una coleccion de cell
				Iterator<Cell> ce = firstRow.cellIterator();

				int k = 0;
				int coloum = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCase")) {
						coloum = k;

					}
					k++;
				}
				System.out.println(coloum);

				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(coloum).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						Iterator<Cell> cell2 = r.iterator();
						while (cell2.hasNext()) {
							Cell c = cell2.next();
							if (c.getCellType() == CellType.STRING) {
								arreglo.add(c.getStringCellValue());
							} else {

								arreglo.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}

		}
		return arreglo;
	}
}
