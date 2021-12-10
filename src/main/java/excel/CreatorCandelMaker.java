package excel;

import candlemaker.CandleMaker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreatorCandelMaker {
    public static void worker(XSSFSheet sheetCan, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<CandleMaker> candleMakers){
        XSSFRow rowSt = sheetCan.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Дата");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Час");
        cell = rowSt.createCell(2);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Вся свеча");
        cell = rowSt.createCell(3);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Код свечи");
        cell = rowSt.createCell(4);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Код ADX");

        cell = rowSt.createCell(5);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Дата");
        cell = rowSt.createCell(6);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Час");
        cell = rowSt.createCell(7);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Вся свеча");
        cell = rowSt.createCell(8);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Код свечи");
        cell = rowSt.createCell(9);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Код ADX");
        cell = rowSt.createCell(10);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Макс свечи");
        cell = rowSt.createCell(11);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Мн свечи");
        cell = rowSt.createCell(12);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Макс свечи+1");
        cell = rowSt.createCell(13);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Мн свечи+1");
        cell = rowSt.createCell(14);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Макс свечи+2");
        cell = rowSt.createCell(15);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Мн свечи+2");
        cell = rowSt.createCell(16);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Макс свечи+3");
        cell = rowSt.createCell(17);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Мн свечи+3");
        cell = rowSt.createCell(18);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Макс свечи+4");
        cell = rowSt.createCell(19);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Мн свечи+4");
        cell = rowSt.createCell(20);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Закр свечи+1");
        cell = rowSt.createCell(21);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Закр свечи+2");
        cell = rowSt.createCell(22);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Закр свечи+3");
        cell = rowSt.createCell(23);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Закр свечи+4");
        cell = rowSt.createCell(24);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Закр свечи+5");

        for (int i=0; i<candleMakers.size(); i++){
            XSSFRow row = sheetCan.createRow(i+1);
            XSSFCell cellD1 = row.createCell(0);
            cellD1.setCellStyle(cellStyle);
            cellD1.setCellValue(candleMakers.get(i).getDate());
            XSSFCell cellD = row.createCell(1);
            cellD = row.createCell(1);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i).getTime());
            cellD = row.createCell(2);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i).getCandleFull());
            cellD = row.createCell(3);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i).getCandleView());
            cellD = row.createCell(4);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i).getCodeADX());

        if(i<candleMakers.size()-1) {
            cellD1 = row.createCell(5);
            cellD1.setCellStyle(cellStyle);
            cellD1.setCellValue(candleMakers.get(i+1).getDate());
            cellD = row.createCell(6);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getTime());
            cellD = row.createCell(7);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getCandleFull());
            cellD = row.createCell(8);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getCandleView());
            cellD = row.createCell(9);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getCodeADX());

            cellD = row.createCell(10);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getHighPC());
            cellD = row.createCell(11);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getLowPC());
            cellD = row.createCell(12);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getHighPC2());
            cellD = row.createCell(13);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getLowPC2());
            cellD = row.createCell(14);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getHighPC3());
            cellD = row.createCell(15);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getLowPC3());
            cellD = row.createCell(16);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getHighPC4());
            cellD = row.createCell(17);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getLowPC4());
            cellD = row.createCell(18);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getHighPC5());
            cellD = row.createCell(19);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getLowPC5());
            cellD = row.createCell(20);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getClosePC());
            cellD = row.createCell(21);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getClosePC2());
            cellD = row.createCell(22);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getClosePC3());
            cellD = row.createCell(23);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getClosePC4());
            cellD = row.createCell(24);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i+1).getClosePC5());
        }

        }
    }
}
