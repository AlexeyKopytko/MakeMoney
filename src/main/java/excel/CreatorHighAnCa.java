package excel;

import candlemaker.AnaliseDiaposon;
import candlemaker.CandleMaker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreatorHighAnCa {
    public static void worker(XSSFSheet sheetHighAnCa, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<AnaliseDiaposon> analiseDiaposons){
        XSSFRow rowSt = sheetHighAnCa.createRow(0);
        XSSFCell cell = rowSt.createCell(0);
        cell = rowSt.createCell(0);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Предидущая свеча");
        cell = rowSt.createCell(1);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Текущая свеча");
        cell = rowSt.createCell(2);
        cell.setCellStyle(cellStyle2);
        cell.setCellValue("Количество случаев");
        int s = 100;
        for (int i = 0; i<10; i++) {
            cell = rowSt.createCell(i+3);
            cell.setCellStyle(cellStyle2);
            cell.setCellValue(s);
            s=s-10;
        }

        for (int i=0; i<analiseDiaposons.size();i++){
            if(analiseDiaposons.get(i).getPrParam()!=null) {
                XSSFRow row = sheetHighAnCa.createRow(i);
                XSSFCell cellD1 = row.createCell(0);
                cellD1.setCellStyle(cellStyle3);
                cellD1.setCellValue(analiseDiaposons.get(i).getFirstParam());
                XSSFCell cellD2 = row.createCell(1);
                cellD2.setCellStyle(cellStyle3);
                cellD2.setCellValue(analiseDiaposons.get(i).getSecondParam());
                XSSFCell cellD3 = row.createCell(2);
                cellD3.setCellStyle(cellStyle3);
                cellD3.setCellValue(analiseDiaposons.get(i).getResultParam().size());
                for (int j = 0; j < analiseDiaposons.get(i).getPrParam().size(); j++) {
                    XSSFCell cellD4 = row.createCell(j + 3);
                    cellD4.setCellStyle(cellStyle3);
                    cellD4.setCellValue(analiseDiaposons.get(i).getPrParam().get(j));
                }
            }
        }
    }
}
