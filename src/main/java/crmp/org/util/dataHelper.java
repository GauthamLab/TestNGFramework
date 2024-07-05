package crmp.org.util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class dataHelper {

    public static Map<String, Map<String, String>> getExcelData(String filePath, String sheetName) throws IOException {
        Map<String, Map<String, String>> data = new HashMap<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        DataFormatter formatter = new DataFormatter();

        Iterator<Row> rowIterator = sheet.iterator();
        Row headerRow = rowIterator.next(); // Assuming the first row is the header row
        String[] headers = new String[headerRow.getPhysicalNumberOfCells()];
        for (int i = 0; i < headers.length; i++) {
            headers[i] = formatter.formatCellValue(headerRow.getCell(i));
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Map<String, String> rowData = new HashMap<>();
            for (int i = 0; i < headers.length; i++) {
                rowData.put(headers[i], formatter.formatCellValue(row.getCell(i)));
            }
            data.put(rowData.get("TestCaseNumber"), rowData);
        }
        workbook.close();
        fis.close();
        return data;
    }
}
