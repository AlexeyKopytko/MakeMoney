package indicator;

import candlemaker.Stocks;

import java.util.ArrayList;

public class DI {
    public static ArrayList<Stocks> worker(ArrayList<Stocks> stocks, int period){

        Double ema1 = 0.0;
        Double kof = 2.0/((double)period+1.0);
        for(int i=1; i<stocks.size();i++){
            if(i<period+1){
                ema1 = ema1 + stocks.get(i).getPlusDM()/stocks.get(i).getTrueRange();
            }
            else {
                break;
            }
        }
        Double x1 = stocks.get(period).getPlusDM()/stocks.get(period).getTrueRange();
        Double x2 = ema1 / period;
        Double x4 = x1 - x2;
        Double x5 = x4 * kof;
        Double x6 = x5 + x2;
        ema1 = x6;
        stocks.get(period).setPlusDI(ema1);
        for(int i = period+1; i < stocks.size(); i++){
            Double x7 = stocks.get(i).getPlusDM()/stocks.get(i).getTrueRange();
            Double x8 = x7-ema1;
            Double x9 = x8*kof;
            Double x10 = x9+ema1;
            ema1 = x10;
            stocks.get(i).setPlusDI(ema1);
        }


        ema1 = 0.0;
        for(int i=1; i<stocks.size();i++){
            if(i<period+1){
                ema1 = ema1 + stocks.get(i).getMinusDM()/stocks.get(i).getTrueRange();
            }
            else {
                break;
            }
        }
        x1 = stocks.get(period).getMinusDM()/stocks.get(period).getTrueRange();
        x2 = ema1 / period;
        x4 = x1 - x2;
        x5 = x4 * kof;
        x6 = x5 + x2;
        ema1 = x6;
        stocks.get(period).setMinusDI(ema1);
        for(int i = period+1; i < stocks.size(); i++){
            Double x7 = stocks.get(i).getMinusDM()/stocks.get(i).getTrueRange();
            Double x8 = x7-ema1;
            Double x9 = x8*kof;
            Double x10 = x9+ema1;
            ema1 = x10;
            stocks.get(i).setMinusDI(ema1);
        }

        return stocks;

    }
}
