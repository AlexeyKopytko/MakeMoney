package excel;

import candlemaker.AnaliseDiaposon;
import candlemaker.StructureCandle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreatorStructureCandle {
    public static void worker(XSSFSheet sheetStrCa, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<StructureCandle> aC){
        XSSFRow rowSt = sheetStrCa.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Предидущая свеча");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Текущая свеча");
        cell = rowSt.createCell(2);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Всего случаев");
        cell = rowSt.createCell(3);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Быки");
        cell = rowSt.createCell(4);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Отношение");
        for(int i=0; i<aC.size();i++){
            XSSFRow rowSt1 = sheetStrCa.createRow(i+1);
            XSSFCell cell2 = rowSt1.createCell(0);
            cell2 = rowSt1.createCell(0);
            cell2.setCellStyle(cellStyle2);
            cell2.setCellValue(aC.get(i).getSecondParam());
            cell2 = rowSt1.createCell(1);
            cell2.setCellStyle(cellStyle2);
            cell2.setCellValue(aC.get(i).getFirstParam());
            cell2 = rowSt1.createCell(2);
            cell2.setCellStyle(cellStyle3);
            cell2.setCellValue(aC.get(i).getAllCases());
            cell2 = rowSt1.createCell(3);
            cell2.setCellStyle(cellStyle3);
            cell2.setCellValue(aC.get(i).getUpCases());
            cell2 = rowSt1.createCell(4);
            cell2.setCellStyle(cellStyle3);
            cell2.setCellValue(aC.get(i).getAddiction());

        }
    }
}
