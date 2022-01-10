package excel;

import analise.NeuralNetwork;
import candlemaker.CandleMaker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;
import java.util.Collections;

public class CreatorNeuralNetwork {
    public static void worker(XSSFSheet sheetCan, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<NeuralNetwork> neuralNetworks) {
        XSSFRow rowSt = sheetCan.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Candle 16");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 16");
        cell = rowSt.createCell(2);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 15");
        cell = rowSt.createCell(3);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 15");
        cell = rowSt.createCell(4);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 14");
        cell = rowSt.createCell(5);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 14");
        cell = rowSt.createCell(6);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 13");
        cell = rowSt.createCell(7);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 13");
        cell = rowSt.createCell(8);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 12");
        cell = rowSt.createCell(9);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 12");
        cell = rowSt.createCell(10);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 11");
        cell = rowSt.createCell(11);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 11");
        cell = rowSt.createCell(12);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 10");
        cell = rowSt.createCell(13);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 10");
        cell = rowSt.createCell(14);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 9");
        cell = rowSt.createCell(15);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 9");
        cell = rowSt.createCell(16);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 8");
        cell = rowSt.createCell(17);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 8");
        cell = rowSt.createCell(18);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 7");
        cell = rowSt.createCell(19);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 7");
        cell = rowSt.createCell(20);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 6");
        cell = rowSt.createCell(21);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 6");
        cell = rowSt.createCell(22);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 5");
        cell = rowSt.createCell(23);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 5");
        cell = rowSt.createCell(24);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 4");
        cell = rowSt.createCell(25);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 4");
        cell = rowSt.createCell(26);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 3");
        cell = rowSt.createCell(27);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 3");
        cell = rowSt.createCell(28);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 2");
        cell = rowSt.createCell(29);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 2");
        cell = rowSt.createCell(30);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cnadle 1");
        cell = rowSt.createCell(31);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("ADX 1");
        cell = rowSt.createCell(32);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Cod Close Price");
        for(int i=0;i<neuralNetworks.size();i++){
            ArrayList<Integer> candle = neuralNetworks.get(i).getCandle();
            ArrayList<Integer> adx = neuralNetworks.get(i).getAdx();
            Collections.reverse(candle);
            Collections.reverse(adx);
            XSSFRow row = sheetCan.createRow(i+1);
            for(int j=0;j<candle.size();j++){
                    XSSFCell cellD1 ;
                    cellD1 = row.createCell(j * 2);
                    cellD1.setCellStyle(cellStyle3);
                    cellD1.setCellValue(candle.get(j));
                    cellD1 = row.createCell(j * 2+1);
                    cellD1.setCellStyle(cellStyle3);
                    cellD1.setCellValue(adx.get(j));
                    if (j==0){
                        cellD1 = row.createCell(0);
                        cellD1.setCellStyle(cellStyle3);
                        cellD1.setCellValue(candle.get(j));
                        cellD1 = row.createCell(1);
                        cellD1.setCellStyle(cellStyle3);
                        cellD1.setCellValue(adx.get(j));
                    }
            }
            XSSFCell cellD1;
            cellD1 = row.createCell(32);
            cellD1.setCellStyle(cellStyle3);
            cellD1.setCellValue(neuralNetworks.get(i).getCodeClosePrice1());
        }

    }
}
