package excel;

import candlemaker.ElementaryInfomation;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreatorEInformation {
    public static void worker(XSSFSheet sheetEI, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<ElementaryInfomation> eInformation){

        XSSFRow rowSt = sheetEI.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Дата");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Час");
        cell = rowSt.createCell(2);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Гэп");
        cell = rowSt.createCell(3);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Изменение цены закрытияв %");
        cell = rowSt.createCell(4);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Изменение объема в %");
        cell = rowSt.createCell(5);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Тело свечи");
        cell = rowSt.createCell(6);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Вся свеча");
        cell = rowSt.createCell(7);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Положительный хвост");
        cell = rowSt.createCell(8);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Отрицаетельный хвост");

        for (int i=0; i<eInformation.size(); i++){
            XSSFRow row = sheetEI.createRow(i+1);
            XSSFCell cellD1 = row.createCell(0);
            cellD1.setCellStyle(cellStyle);
            cellD1.setCellValue(eInformation.get(i).getDate());
            XSSFCell cellD = row.createCell(1);
            cellD = row.createCell(1);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getTime());
            cellD = row.createCell(2);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getOpenCH());
            cellD = row.createCell(3);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getCloseCH());
            cellD = row.createCell(4);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getVolumeCH());
            cellD = row.createCell(5);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getCandleBody());
            cellD = row.createCell(6);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getCandleFull());
            cellD = row.createCell(7);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getCandlePlus());
            cellD = row.createCell(8);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(eInformation.get(i).getCandleMinus());
        }
    }
}
