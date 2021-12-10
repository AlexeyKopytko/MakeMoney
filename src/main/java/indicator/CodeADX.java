package indicator;

import candlemaker.CandleMaker;
import candlemaker.Stocks;

import java.util.ArrayList;

public class CodeADX {
    public static ArrayList<CandleMaker> worker(ArrayList<CandleMaker> candleMakers, ArrayList<Stocks> stocks){
        ArrayList<Double> diaposon = new ArrayList<>();
        diaposon.add(10.0);
        for(int i=0; i<9; i++){
            diaposon.add(diaposon.get(i)+5.0);
        }
        ArrayList<Integer> cod = new ArrayList<>();
        cod.add(1);
        for (int i = 0;i<10;i++){
            cod.add(cod.get(i)+1);
        }
        for (int i = 0; i<candleMakers.size(); i++){
            for (int j=0;j<stocks.size();j++){
                if(candleMakers.get(i).getDate().getTime()==stocks.get(j).getDate().getTime() &&
                    candleMakers.get(i).getTime()==stocks.get(j).getTime()){
                    String x1="-1";
                    String x2="-1";
                    String x3="-1";
                    if(stocks.get(j).getPlusDI()<10.0){
                        x1 = "0";
                    }
                    if(stocks.get(j).getMinusDI()<10.0){
                        x2 = "0";
                    }
                    if(stocks.get(j).getIndicatorADX()<10.0){
                        x3 = "0";
                    }
                    if(stocks.get(j).getPlusDI()>=50.0){
                        x1 = "9";
                    }
                    if(stocks.get(j).getMinusDI()>=50.0){
                        x2 = "9";
                    }
                    if(stocks.get(j).getIndicatorADX()>=50.0){
                        x3 = "9";
                    }
                    for (int k=1;k<diaposon.size();k++){
                        if(stocks.get(j).getPlusDI()>=diaposon.get(k-1) &&
                            stocks.get(j).getPlusDI()<diaposon.get(k)){
                            x1=cod.get(k).toString();
                        }
                        if(stocks.get(j).getMinusDI()>=diaposon.get(k-1) &&
                                stocks.get(j).getMinusDI()<diaposon.get(k)){
                            x2=cod.get(k).toString();
                        }
                        if(stocks.get(j).getIndicatorADX()>=diaposon.get(k-1) &&
                                stocks.get(j).getIndicatorADX()<diaposon.get(k)){
                            x3=cod.get(k).toString();
                        }
                    }
                    String result = x1+x2+x3;
                    candleMakers.get(i).setCodeADX(result);
                }

            }
        }


        return candleMakers;
    }
}
