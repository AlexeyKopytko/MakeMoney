package excel;

import candlemaker.AnaliseCandle;
import candlemaker.CandleMaker;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import java.util.ArrayList;

public class CreatorAnalisCandle {
    public static void worker(XSSFSheet sheetACan, XSSFCellStyle cellStyle, XSSFCellStyle cellStyle2,
                              XSSFCellStyle cellStyle3, ArrayList<AnaliseCandle> aC, ArrayList<Integer> unicCandel){
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
    }
}
