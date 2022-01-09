package main;

import analise.Analise;
import analise.NeuralNetwork;
import candlemaker.*;
import excel.ExProject;
import indicator.ADX;
import indicator.CodeADX;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        //String s = File.separator;
        System.out.println("start");

        // Получаем данные из .CSV файла.
        InputStream is = Main.class.getResourceAsStream("/SBER_1_hour.csv");
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




        stocks = ADX.worker(stocks,14);


        ElementaryInfomation elementaryInfomation = new ElementaryInfomation();
        ArrayList<ElementaryInfomation> eInfomations = elementaryInfomation.counting(stocks);

        CandleMaker candleMaker = new CandleMaker();
        ArrayList<CandleMaker> candleMakers = candleMaker.candleMake(eInfomations,stocks);

        AnaliseCandle analiseCandle = new AnaliseCandle();
        ArrayList<AnaliseCandle> analiseCandles = analiseCandle.analiseCandles(candleMakers);

        ArrayList<Integer> unicCandels = analiseCandle.unicCandel(analiseCandles);
        ArrayList<AnaliseCandle> dAnaliseCandles = analiseCandle.dAnaliseCandles(candleMakers);

        //AnaliseDiaposon analiseDiaposon = new AnaliseDiaposon();
        //ArrayList<AnaliseDiaposon> highAnaliseDiaposons = analiseDiaposon.highAnaliseDiaposon(candleMakers);
        //ArrayList<AnaliseDiaposon> lowAnaliseDiaposons = analiseDiaposon.lowAnaliseDiaposon(candleMakers);
        StructureCandle structureCandle = new StructureCandle();
        ArrayList<StructureCandle> structureCandles = structureCandle.structureCandels(dAnaliseCandles);

        Analise analise1 = new Analise();
        Analise analise2 = new Analise();
        ArrayList<CandleMaker> candleMakers1 = candleMaker.makeFuture(candleMakers,stocks);

        ArrayList<Analise> analises1 = analise1.worker1(candleMakers1,1);
        ArrayList<Analise> analises2 = analise2.worker1(candleMakers1,2);
        ArrayList<Analise> analises3 = new Analise().worker1(candleMakers1,3);
        ArrayList<Analise> analises4 = new Analise().worker1(candleMakers1,4);
        ArrayList<Analise> analises5 = new Analise().worker1(candleMakers1,5);
        candleMakers1 = CodeADX.worker(candleMakers1,stocks);
        ArrayList<NeuralNetwork> neuralNetworks = NeuralNetwork.neuralNetworks(candleMakers);


        System.out.println("write");



        ExProject exProject = new ExProject("workbook1.xlsx");
        exProject.creatorBD(stocks);
        exProject.creatorEInformation(eInfomations);
        exProject.creatorCandleMaker(candleMakers);
        exProject.creatorAnalisCandle(analiseCandles,unicCandels);
        exProject.creatordAnalisCandle(dAnaliseCandles,unicCandels);
        //exProject.creatorHighAnCa(highAnaliseDiaposons);
        //exProject.creatorLowAnCa(lowAnaliseDiaposons);
        exProject.creatorStructureCandle(structureCandles);
        exProject.creatorDiapason(analises1,analises2,analises3,analises4,analises5);
        exProject.creatorNeuralNetwork(neuralNetworks);
        ExProject exProject1 = new ExProject("education.xlsx");
        exProject1.creatorBD(stocks);
        exProject1.creatorNeuralNetwork(neuralNetworks);


        exProject.wRite();
        exProject1.wRite();

        System.out.println("finish");

    }
}
