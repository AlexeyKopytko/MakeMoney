import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //String s = File.separator;

        InputStream is = Main.class.getResourceAsStream("/SBER_060101_101231.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        ArrayList<Stocks> stocks = new ArrayList<>();
        br.readLine();
        while (br.ready()){
            String result = br.readLine();
            Stocks stocks1 = new Stocks();
            stocks1.createStocks(result);
            stocks.add(stocks1);
        }
        ElementaryInfomation elementaryInfomation = new ElementaryInfomation();
        ArrayList<ElementaryInfomation> eInfomations = elementaryInfomation.counting(stocks);
        CandleMaker candleMaker = new CandleMaker();
        ArrayList<CandleMaker> candleMakers = candleMaker.candleMake(eInfomations,stocks);




        ExProject exProject = new ExProject();
        exProject.creatorBD(stocks);
        exProject.creatorEInformation(eInfomations);
        exProject.creatorCandleMaker(candleMakers);


        exProject.wRite();



    }
}
