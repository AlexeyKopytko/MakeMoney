package excel;

import analise.Analise;
import analise.NeuralNetwork;
import candlemaker.*;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExProject {
    String fileName;
    //модель ексель файла
    private XSSFWorkbook book;
    //запись
    FileOutputStream fileOut;

    XSSFSheet sheetNeur;
    XSSFSheet sheetBD;
    XSSFSheet sheetEI;
    //XSSFSheet sheetG1;
    XSSFSheet sheetCan;

    XSSFSheet sheetACan;
    XSSFSheet sheetdACan;
    XSSFSheet sheetStrCa;
    XSSFSheet sheetDiaposon;


    //шрифты
    XSSFFont font1;
    XSSFFont font2;
    // стили
    XSSFCellStyle cellStyle;
    XSSFCellStyle cellStyle2;
    XSSFCellStyle cellStyle3;
    public ExProject(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.fileOut = new FileOutputStream(fileName);
        this.book =new XSSFWorkbook();
        this.sheetNeur = book.createSheet("Нейронный анализ");
        this.sheetBD = book.createSheet("Базовые данные");
        this.sheetEI = book.createSheet("Элементарные расчеты");
        //this.sheetG1 = book.createSheet("Гипотеза1");
        this.sheetCan = book.createSheet("Свечи");

        this.sheetACan = book.createSheet("Анализ Свечей");
        this.sheetdACan = book.createSheet("Д.Анализ Свечей");
        this.sheetStrCa = book.createSheet("Структура свечей");
        this.sheetDiaposon = book.createSheet("Диапазон по свечам");


        //шрифты
        this.font1 = book.createFont();
        this.font2 = book.createFont();
        // стили
        this.cellStyle = book.createCellStyle();
        this.cellStyle2 = book.createCellStyle();
        this.cellStyle3 = book.createCellStyle();
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
        CreateBD.worker(sheetBD,cellStyle,cellStyle2,cellStyle3,stocks);
/*
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
*/
    }

    public void creatorEInformation (ArrayList<ElementaryInfomation> eInformation) throws IOException {
        CreatorEInformation.worker(sheetEI,cellStyle,cellStyle2,cellStyle3,eInformation);
 /*       XSSFRow rowSt = sheetEI.createRow(0);
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
        */
    }
    /*
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
    */
    public void creatorCandleMaker(ArrayList<CandleMaker> candleMakers){
        CreatorCandelMaker.worker(sheetCan,cellStyle,cellStyle2,cellStyle3,candleMakers);
        /*
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
        cell.setCellValue("Макс свечи");
        cell = rowSt.createCell(5);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Мн свечи");


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
            cellD.setCellValue(candleMakers.get(i).getHighPC());
            cellD = row.createCell(5);
            cellD.setCellStyle(cellStyle3);
            cellD.setCellValue(candleMakers.get(i).getLowPC());
        }

         */
    }

    public void creatorAnalisCandle(ArrayList<AnaliseCandle> aC, ArrayList<Integer> unicCandel){
        CreatorAnalisCandle.worker(sheetACan,cellStyle,cellStyle2,cellStyle3,aC,unicCandel);
        /*
        XSSFRow rowSt = sheetACan.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Уникальная свеча");
        for (int i=0; i<unicCandel.size(); i++){
            cell = rowSt.createCell(i+1);
            cell.setCellStyle(cellStyle2);
            cell.setCellValue(unicCandel.get(i));
        }
        for (int i=0; i<unicCandel.size(); i++){
            XSSFRow row = sheetACan.createRow(i+1);
            XSSFCell cellD1 = row.createCell(0);
            cellD1.setCellStyle(cellStyle3);
            cellD1.setCellValue(unicCandel.get(i));
            for (int j=0; j<aC.size();j++){
                if(unicCandel.get(i)==aC.get(j).getUnicCandle()){
                    for(int k=0; k<unicCandel.size(); k++){
                        if(unicCandel.get(k)==aC.get(j).getNextCandle()){
                            XSSFCell cellD2 = row.createCell(k+1);
                            cellD2.setCellStyle(cellStyle3);
                            cellD2.setCellValue(aC.get(j).getCountNextCandle());
                        }
                    }
                }
            }
        }

         */
    }

    public void creatordAnalisCandle(ArrayList<AnaliseCandle> aC, ArrayList<Integer> unicCandel){
        CreatorDAnalisCandle.worker(sheetdACan,cellStyle,cellStyle2,cellStyle3,aC,unicCandel);
       /*
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

        */
    }

    public void creatorStructureCandle(ArrayList<StructureCandle> aC) {
        CreatorStructureCandle.worker(sheetStrCa,cellStyle,cellStyle2,cellStyle3,aC);
        /*
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
            cell2.setCellStyle(cellStyle2);
            cell2.setCellValue(aC.get(i).getAllCases());
            cell2 = rowSt1.createCell(3);
            cell2.setCellStyle(cellStyle2);
            cell2.setCellValue(aC.get(i).getUpCases());
            cell2 = rowSt1.createCell(4);
            cell2.setCellStyle(cellStyle2);
            cell2.setCellValue(aC.get(i).getAddiction());
        }
         */
    }

    public void creatorDiapason(ArrayList<Analise> analises1,ArrayList<Analise> analises2,ArrayList<Analise> analises3,
                                ArrayList<Analise> analises4,ArrayList<Analise> analises5){
        CreatorDiapason.worker(sheetDiaposon,cellStyle,cellStyle2,cellStyle3,
                                analises1,analises2,analises3,analises4,analises5);
    }

    public void creatorNeuralNetwork(ArrayList<NeuralNetwork> neuralNetworks) {
        CreatorNeuralNetwork.worker(sheetNeur, cellStyle, cellStyle2, cellStyle3, neuralNetworks);
    }


    public void  wRite() throws IOException {
        book.write(fileOut);
        fileOut.close();
    }
}
