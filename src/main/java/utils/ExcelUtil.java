package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    private static final String FILE_PATH = "D:\\INTERVIEW TRAINING\\Automation\\Web - UI Automation\\Java selenium\\Data driven testing\\excel code\\DataFromExcel\\src\\resources\\testdata\\testData.xlsx";

    // 1. Get cell data by index
    public static String getCellData(String sheetName, int rowNum, int colNum) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);

            if (row == null) {
                throw new NullPointerException("Row " + rowNum + " is null.");
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                throw new NullPointerException("Cell (" + rowNum + "," + colNum + ") is null.");
            }

            return cell.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 2. Get cell data by header name
    public static String getCellDataByHeader(String sheetName, int rowNum, String headerName) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found.");
            }

            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new NullPointerException("Header row is null.");
            }

            int colIndex = -1;
            for (Cell cell : headerRow) {
                if (cell.getStringCellValue().trim().equalsIgnoreCase(headerName.trim())) {
                    colIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (colIndex == -1) {
                throw new IllegalArgumentException("Header '" + headerName + "' not found.");
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                throw new NullPointerException("Row " + rowNum + " is null.");
            }

            Cell cell = row.getCell(colIndex);
            if (cell == null) {
                return ""; // Or throw exception if required
            }

            return cell.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
