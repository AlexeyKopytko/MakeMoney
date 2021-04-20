import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExProject {
    //модель ексель файла
    private XSSFWorkbook book = new XSSFWorkbook();
    XSSFSheet sheetBD = book.createSheet("Базовые данные");
    XSSFSheet sheetEI = book.createSheet("Элементарные расчеты");
    XSSFSheet sheetG1 = book.createSheet("Гипотеза1");
    //запись
    FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
    //шрифты
    XSSFFont font1 = book.createFont();
    XSSFFont font2 = book.createFont();
    // стили
    XSSFCellStyle cellStyle = book.createCellStyle();
    XSSFCellStyle cellStyle2 = book.createCellStyle();
    XSSFCellStyle cellStyle3 = book.createCellStyle();
    public ExProject() throws FileNotFoundException {
    }

    private void createStyle(){
        font1.setFontHeightInPoints((short)14);
        font1.setFontName("Times New Roman");
        font1.setBold(true);

        font2.setFontHeightInPoints((short)12);
        font2.setFontName("Times New Roman");

        CreationHelper createHelper = book.getCreationHelper();
        cellStyle.setDataFormat(createHelper
                .createDataFormat()
                .getFormat("dd/mm/yy"));
        cellStyle.setFont(font2);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);

        cellStyle2.setFont(font1);
        cellStyle2.setBorderTop(BorderStyle.THIN);
        cellStyle2.setBorderBottom(BorderStyle.THIN);
        cellStyle2.setBorderLeft(BorderStyle.THIN);
        cellStyle2.setBorderRight(BorderStyle.THIN);

        cellStyle3.setFont(font2);
        cellStyle3.setBorderTop(BorderStyle.THIN);
        cellStyle3.setBorderBottom(BorderStyle.THIN);
        cellStyle3.setBorderLeft(BorderStyle.THIN);
        cellStyle3.setBorderRight(BorderStyle.THIN);
    }

    public void creatorBD(ArrayList<Stocks> stocks) throws IOException {


        createStyle();

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
        }




    }

    public void creatorEInformation (ArrayList<ElementaryInfomation> eInformation) throws IOException {


        createStyle();

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

    public void creatorGipoteza1(ArrayList<Gipoteza1> gipoteza1s){
        XSSFRow rowSt = sheetG1.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Уникальный размер свечи");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Количество положительных следующих случаев");
        cell = rowSt.createCell(2);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Количество отрицательных следующих случаев");
        cell = rowSt.createCell(3);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Отношение прошлых двух колонок");
        cell = rowSt.createCell(4);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Количество положительных следующих случаев(5)");
        cell = rowSt.createCell(5);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Количество отрицательных следующих случаев(5)");
        cell = rowSt.createCell(6);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Отношение прошлых двух колонок(5)");

        for (int i=0;i<gipoteza1s.size();i++){
            XSSFRow row = sheetG1.createRow(i+1);
            XSSFCell cellD1 = row.createCell(0);
            cellD1.setCellStyle(cellStyle3);
            cellD1.setCellValue(gipoteza1s.get(i).getUniqueCandleFull());
            XSSFCell cellD = row.createCell(1);
            cellD = row.createCell(1);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(gipoteza1s.get(i).getPrInc());
            cellD = row.createCell(2);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(gipoteza1s.get(i).getPrDic());
            cellD = row.createCell(3);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(gipoteza1s.get(i).getVsIncDic());
            cellD = row.createCell(4);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(gipoteza1s.get(i).getPrIncF());
            cellD = row.createCell(5);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(gipoteza1s.get(i).getPrDicF());
            cellD = row.createCell(6);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(gipoteza1s.get(i).getVsIncFDicF());
        }

    }

    public void  wRite() throws IOException {
        book.write(fileOut);
        fileOut.close();
    }
}
