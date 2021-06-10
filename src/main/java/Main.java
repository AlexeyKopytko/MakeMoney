import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //String s = File.separator;
        System.out.println("start");

        InputStream is = Main.class.getResourceAsStream("/SBER_070101_191231.csv");
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
        AnaliseCandle analiseCandle = new AnaliseCandle();
        ArrayList<AnaliseCandle> analiseCandles = analiseCandle.analiseCandles(candleMakers);
        ArrayList<Integer> unicCandels = analiseCandle.unicCandel(analiseCandles);
        ArrayList<AnaliseCandle> dAnaliseCandles = analiseCandle.dAnaliseCandles(candleMakers);
        AnaliseDiaposon analiseDiaposon = new AnaliseDiaposon();
        ArrayList<AnaliseDiaposon> highAnaliseDiaposons = analiseDiaposon.highAnaliseDiaposon(candleMakers);
        ArrayList<AnaliseDiaposon> lowAnaliseDiaposons = analiseDiaposon.lowAnaliseDiaposon(candleMakers);



        System.out.println("write");



        ExProject exProject = new ExProject();
        exProject.creatorBD(stocks);
        exProject.creatorEInformation(eInfomations);
        exProject.creatorCandleMaker(candleMakers);
        exProject.creatorAnalisCandle(analiseCandles,unicCandels);
        exProject.creatordAnalisCandle(dAnaliseCandles,unicCandels);
        exProject.creatorHighAnCa(highAnaliseDiaposons);
        exProject.creatorLowAnCa(lowAnaliseDiaposons);

        exProject.wRite();

        System.out.println("finish");

    }
}
