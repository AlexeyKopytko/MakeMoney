import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //String s = File.separator;
        String way = "C://Users//Алексей//Documents//JavaProgram//SBER_060101_101231.csv";
        BufferedReader br = new BufferedReader(new FileReader(way));
        ArrayList<Stocks> stocks = new ArrayList<>();
        br.readLine();
        while (br.ready()){
            String result = br.readLine();
            Stocks stocks1 = new Stocks();
            stocks1.createStocks(result);
            stocks.add(stocks1);
        }

        ExProject exProject = new ExProject();
        exProject.creatorBD(stocks);
        ElementaryInfomation elementaryInfomation = new ElementaryInfomation();
        ArrayList<ElementaryInfomation> eInfomations = elementaryInfomation.counting(stocks);
        exProject.creatorEInformation(eInfomations);



    }
}
