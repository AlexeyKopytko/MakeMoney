package excel;

import candlemaker.Stocks;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreateBD {
    public static void worker(XSSFSheet sheetBD, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                       XSSFCellStyle cellStyle3, ArrayList<Stocks> stocks){
        XSSFRow rowSt = sheetBD.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Дата");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Час");
        cell = rowSt.createCell(2);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Цена открытия");
        cell = rowSt.createCell(3);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Максимальная цена");
        cell = rowSt.createCell(4);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Минимальная цена");
        cell = rowSt.createCell(5);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Цена закрытия");
        cell = rowSt.createCell(6);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Обьем");
        cell = rowSt.createCell(7);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("EMA");
        cell = rowSt.createCell(8);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("PlusDM");
        cell = rowSt.createCell(9);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("MinusDM");
        cell = rowSt.createCell(10);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("TrueRange");
        cell = rowSt.createCell(11);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("PlusDI");
        cell = rowSt.createCell(12);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("MinusDI");
        cell = rowSt.createCell(13);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX");


        for (int i=0; i<stocks.size(); i++){
            XSSFRow row = sheetBD.createRow(i+1);
            XSSFCell cellD1 = row.createCell(0);
            cellD1.setCellStyle(cellStyle);
            cellD1.setCellValue(stocks.get(i).getDate());
            XSSFCell cellD = row.createCell(1);
            cellD = row.createCell(1);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getTime());
            cellD = row.createCell(2);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getOpen());
            cellD = row.createCell(3);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getHigh());
            cellD = row.createCell(4);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getLow());
            cellD = row.createCell(5);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getClose());
            cellD = row.createCell(6);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getVolume());
            cellD = row.createCell(7);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getEma());
            cellD = row.createCell(8);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getPlusDM());
            cellD = row.createCell(9);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getMinusDM());
            cellD = row.createCell(10);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getTrueRange());
            cellD = row.createCell(11);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getPlusDI());
            cellD = row.createCell(12);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getMinusDI());
            cellD = row.createCell(13);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(stocks.get(i).getIndicatorADX());
        }
    }
}
