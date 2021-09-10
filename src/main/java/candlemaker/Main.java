package candlemaker;

import excel.ExProject;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //String s = File.separator;
        System.out.println("start");

        // Получаем данные из .CSV файла.
        InputStream is = Main.class.getResourceAsStream("/SBER_060101_101231.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        // Создаем список в котором храним данные об изменний цен за один ход цены
        ArrayList<Stocks> stocks = new ArrayList<>();
        br.readLine();

        // Заполняем список данными полученным из .CSV файла.
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
        StructureCandle structureCandle = new StructureCandle();
        ArrayList<StructureCandle> structureCandles = structureCandle.structureCandels(dAnaliseCandles);



        System.out.println("write");



        ExProject exProject = new ExProject();
        exProject.creatorBD(stocks);
        exProject.creatorEInformation(eInfomations);
        exProject.creatorCandleMaker(candleMakers);
        exProject.creatorAnalisCandle(analiseCandles,unicCandels);
        exProject.creatordAnalisCandle(dAnaliseCandles,unicCandels);
        exProject.creatorHighAnCa(highAnaliseDiaposons);
        exProject.creatorLowAnCa(lowAnaliseDiaposons);
        exProject.creatorStructureCandle(structureCandles);

        exProject.wRite();

        System.out.println("finish");

    }
}
