package candlemaker;

import analise.Analise;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        System.out.println("start");

        // Получаем данные из .CSV файла.
        InputStream is = Main.class.getResourceAsStream("/SBER_070601_200601.csv");
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
        ArrayList<CandleMaker> candleMakers1 = candleMaker.makeFuture(candleMakers,stocks);

        ArrayList<Analise> analises = new Analise().worker1(candleMakers1,1);

        for (Analise analise:analises){
            if(analise.getAllCases()>10) {
                System.out.println(analise.getfParam() + "_" + analise.getsParam() + "_" + analise.getAllCases()
                        + "_" + analise.getFirstDiapasonHigh() + "_" +analise.getFirstDiapasonLow()
                        + "_" + analise.getFirstDiapasonPercent());
            }
        }


    }
}
