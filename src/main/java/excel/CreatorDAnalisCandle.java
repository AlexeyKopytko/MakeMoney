package excel;

import candlemaker.AnaliseCandle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreatorDAnalisCandle {
    public static void worker(XSSFSheet sheetdACan, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<AnaliseCandle> aC, ArrayList<Integer> unicCandel){
        XSSFRow rowSt = sheetdACan.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Предидущая свеча");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Текущая свеча");
        for (int i=0; i<unicCandel.size(); i++){
            cell = rowSt.createCell(i+2);
            cell.setCellStyle(cellStyle2);
            cell.setCellValue(unicCandel.get(i));
        }
        int count=0;
        for (int i=0; i<unicCandel.size(); i++){
            for (int m=0; m<unicCandel.size(); m++) {
                count++;
                XSSFRow row = sheetdACan.createRow(count);
                XSSFCell cellD1 = row.createCell(0);
                cellD1.setCellStyle(cellStyle3);
                cellD1.setCellValue(unicCandel.get(i));
                XSSFCell cellD2 = row.createCell(1);
                cellD2.setCellStyle(cellStyle3);
                cellD2.setCellValue(unicCandel.get(m));
                for (int j = 0; j < aC.size(); j++) {
                    if (unicCandel.get(i) == aC.get(j).getUnicPrivCandle()
                            && unicCandel.get(m) == aC.get(j).getUnicCandle() ) {
                        for (int k = 0; k < unicCandel.size(); k++) {
                            if (unicCandel.get(k) == aC.get(j).getNextCandle()) {
                                XSSFCell cellD3 = row.createCell(k + 2);
                                cellD3.setCellStyle(cellStyle3);
                                cellD3.setCellValue(aC.get(j).getCountNextCandle());
                            }
                        }
                    }
                }
            }
        }
    }
}
