package excel;

import analise.Analise;
import candlemaker.StructureCandle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreatorDiapason {
    public static void worker(XSSFSheet sheetStrCa, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<Analise> aDiapason1, ArrayList<Analise> aDiapason2,
                                ArrayList<Analise> aDiapason3, ArrayList<Analise> aDiapason4,
                              ArrayList<Analise> aDiapason5){
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
        cell.setCellValue("Врехний диапазон-1");
        cell = rowSt.createCell(4);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Нижний диапазон-1");
        cell = rowSt.createCell(5);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Процент попадания-1");
        cell = rowSt.createCell(6);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Хай-1");
        cell = rowSt.createCell(7);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Ло-1");



        cell = rowSt.createCell(8);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Врехний диапазон-2");
        cell = rowSt.createCell(9);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Нижний диапазон-2");
        cell = rowSt.createCell(10);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Процент попадания-2");
        cell = rowSt.createCell(11);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Хай-2");
        cell = rowSt.createCell(12);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Ло-2");


        cell = rowSt.createCell(13);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Врехний диапазон-3");
        cell = rowSt.createCell(14);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Нижний диапазон-3");
        cell = rowSt.createCell(15);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Процент попадания-3");
        cell = rowSt.createCell(16);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Хай-3");
        cell = rowSt.createCell(17);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Ло-3");

        cell = rowSt.createCell(18);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Врехний диапазон-4");
        cell = rowSt.createCell(19);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Нижний диапазон-4");
        cell = rowSt.createCell(20);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Процент попадания-4");
        cell = rowSt.createCell(21);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Хай-4");
        cell = rowSt.createCell(22);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Ло-4");

        cell = rowSt.createCell(23);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Врехний диапазон-5");
        cell = rowSt.createCell(24);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Нижний диапазон-5");
        cell = rowSt.createCell(25);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Процент попадания-5");
        cell = rowSt.createCell(26);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Хай-4");
        cell = rowSt.createCell(27);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Ло-4");


        for(int i=0; i<aDiapason1.size();i++) {
            XSSFRow rowSt1 = sheetStrCa.createRow(i + 1);
            XSSFCell cell2 = rowSt1.createCell(0);
            cell2 = rowSt1.createCell(0);
            cell2.setCellStyle(cellStyle2);
            cell2.setCellValue(aDiapason1.get(i).getfParam());
            cell2 = rowSt1.createCell(1);
            cell2.setCellStyle(cellStyle2);
            cell2.setCellValue(aDiapason1.get(i).getsParam());
            cell2 = rowSt1.createCell(2);
            cell2.setCellStyle(cellStyle3);
            cell2.setCellValue(aDiapason1.get(i).getAllCases());
            if(i!=0) {
                cell2 = rowSt1.createCell(3);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason1.get(i).getFirstDiapasonHigh());
                cell2 = rowSt1.createCell(4);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason1.get(i).getFirstDiapasonLow());
                cell2 = rowSt1.createCell(5);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason1.get(i).getFirstDiapasonPercent());
                cell2 = rowSt1.createCell(6);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason1.get(i).getHigh80P());
                cell2 = rowSt1.createCell(7);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason1.get(i).getLow80P());

                cell2 = rowSt1.createCell(8);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason2.get(i).getFirstDiapasonHigh());
                cell2 = rowSt1.createCell(9);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason2.get(i).getFirstDiapasonLow());
                cell2 = rowSt1.createCell(10);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason2.get(i).getFirstDiapasonPercent());
                cell2 = rowSt1.createCell(11);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason2.get(i).getHigh80P());
                cell2 = rowSt1.createCell(12);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason2.get(i).getLow80P());


                cell2 = rowSt1.createCell(13);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason3.get(i).getFirstDiapasonHigh());
                cell2 = rowSt1.createCell(14);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason3.get(i).getFirstDiapasonLow());
                cell2 = rowSt1.createCell(15);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason3.get(i).getFirstDiapasonPercent());
                cell2 = rowSt1.createCell(16);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason3.get(i).getHigh80P());
                cell2 = rowSt1.createCell(17);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason3.get(i).getLow80P());

                cell2 = rowSt1.createCell(18);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason4.get(i).getFirstDiapasonHigh());
                cell2 = rowSt1.createCell(19);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason4.get(i).getFirstDiapasonLow());
                cell2 = rowSt1.createCell(20);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason4.get(i).getFirstDiapasonPercent());
                cell2 = rowSt1.createCell(21);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason4.get(i).getHigh80P());
                cell2 = rowSt1.createCell(22);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason4.get(i).getLow80P());

                cell2 = rowSt1.createCell(23);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason5.get(i).getFirstDiapasonHigh());
                cell2 = rowSt1.createCell(24);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason5.get(i).getFirstDiapasonLow());
                cell2 = rowSt1.createCell(25);
                cell2.setCellStyle(cellStyle3);
                cell2.setCellValue(aDiapason5.get(i).getFirstDiapasonPercent());
                cell2 = rowSt1.createCell(26);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason5.get(i).getHigh80P());
                cell2 = rowSt1.createCell(27);
                cell2.setCellStyle(cellStyle2);
                cell2.setCellValue(aDiapason5.get(i).getLow80P());
            }
        }
    }
}
