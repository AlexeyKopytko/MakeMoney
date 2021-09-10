package excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExWorker {
    private static XSSFWorkbook book = new XSSFWorkbook();

    public static void worker(String nameSheet){

    }

    public static void  wRite() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
        book.write(fileOut);
        fileOut.close();
    }
}
