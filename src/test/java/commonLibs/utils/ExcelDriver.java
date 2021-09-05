package commonLibs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelDriver {
	private InputStream fileReader;
	private Workbook excelWorkbook;

	public void openWorkbook(String excelFileName) throws Exception {
		excelFileName = excelFileName.trim();
		File file = new File(excelFileName);

		if (!file.exists()) {
			throw new Exception("File does not exists");
		}

		fileReader = new FileInputStream(excelFileName);
		excelWorkbook = WorkbookFactory.create(fileReader);
	}

	public int getRowCount(String sheetname) throws Exception {
		sheetname = sheetname.trim();
		Sheet sheet = excelWorkbook.getSheet(sheetname);
		if (sheet == null) {
			throw new Exception("Invalid sheet name");
		}
		return sheet.getLastRowNum();
	}

	public int getCellCountFromARow(String sheetname, int RowNumber) throws Exception {
		sheetname = sheetname.trim();
		Sheet sheet = excelWorkbook.getSheet(sheetname);
		if (sheet == null) {
			throw new Exception("Invalid sheet name");
		}
		if (RowNumber < 0) {
			throw new Exception("Invalid row number");
		}

		Row row = sheet.getRow(RowNumber);
		if (row == null) {
			return 0;
		} else {
			return row.getLastCellNum();
		}
	}

	public String getCellData(String sheetname, int RowNumber, int CellNumber) throws Exception {
		sheetname = sheetname.trim();
		Sheet sheet = excelWorkbook.getSheet(sheetname);
		if (sheet == null) {
			throw new Exception("Invalid sheet name");
		}
		if (RowNumber < 0 || CellNumber <0 ) {
			throw new Exception("Invalid row or cell number");
		}
		Row row = sheet.getRow(RowNumber);
		if (row == null) {
			return "";
		} 
		Cell cell = row.getCell(CellNumber);
		if(cell==null) {
			return "";
		}
		else {
			if(cell.getCellType() == CellType.NUMERIC) {
				return String.valueOf(cell.getNumericCellValue());
			}else {
				return cell.getStringCellValue();
			}
		}
	}
	
}
