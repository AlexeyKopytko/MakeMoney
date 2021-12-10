package indicator;

import candlemaker.Stocks;

import java.util.ArrayList;

public class EMA {

    public static ArrayList<Stocks> worker(ArrayList<Stocks> stocks, int period){

        Double ema1 = 0.0;
        Double kof = 2.0/((double)period+1.0);
        for(int i=0; i<stocks.size();i++){
            if(i<period){
                ema1 = ema1 + stocks.get(i).getClose();
            }
            else {
                break;
            }
        }
        Double x1 = stocks.get(period-1).getClose();
        Double x2 = ema1 / period;
        Double x4 = x1 - x2;
        Double x5 = x4 * kof;
        Double x6 = x5 + x2;
        ema1 = x6;
        stocks.get(period).setEma(ema1);
        for(int i = period; i < stocks.size()-1; i++){
            Double x7 = stocks.get(i).getClose();
            Double x8 = x7-ema1;
            Double x9 = x8*kof;
            Double x10 = x9+ema1;
            ema1 = x10;
            stocks.get(i+1).setEma(ema1);
        }

        return stocks;

    }
}
