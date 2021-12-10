package indicator;

import candlemaker.Stocks;

import java.util.ArrayList;

public class ADX {
    public static ArrayList<Stocks> worker(ArrayList<Stocks> stocks, int period){
        stocks = EMA.worker(stocks, period);
        stocks = DM.worker(stocks);
        stocks = TrueRange.worker(stocks);
        stocks = DI.worker(stocks,period);
        Double ema1 = 0.0;
        Double kof = 2.0/((double)period+1.0);
        for(int i=14; i<stocks.size();i++){
            if(i<period+14){
                Double x1 = stocks.get(i).getPlusDI();
                Double x2 = stocks.get(i).getMinusDI();
                Double x3 = Math.abs(x1-x2);
                Double x4 = x1 + x2;
                Double x5 = x3 / x4;
                Double x6 = x5*100;

                ema1 = ema1 + x6;
            }
            else {
                break;
            }
        }
        Double y1 = stocks.get(period+13).getPlusDI();
        Double y2 = stocks.get(period+13).getMinusDI();
        Double y3 = Math.abs(y1-y2);
        Double y4 = y1+y2;
        Double y5 = y3 / y4 * 100;
        Double x1 = y5;
        Double x2 = ema1 / period;
        Double x4 = x1 - x2;
        Double x5 = x4 * kof;
        Double x6 = x5 + x2;
        ema1 = x6;
        stocks.get(period+14).setIndicatorADX(ema1);
        for(int i = period+14; i < stocks.size()-1; i++){
            Double y7 = stocks.get(i).getPlusDI();
            Double y8 = stocks.get(i).getMinusDI();
            Double y9 = Math.abs(y7-y8);
            Double y10 = y7+y8;
            Double y11 = y9 / y10 * 100;
            Double x7 = y11;
            Double x8 = x7-ema1;
            Double x9 = x8*kof;
            Double x10 = x9+ema1;
            ema1 = x10;
            stocks.get(i+1).setIndicatorADX(ema1);
        }
        for (int i=0; i<stocks.size(); i++){
            stocks.get(i).setPlusDI(stocks.get(i).getPlusDI()*100);
            stocks.get(i).setMinusDI(stocks.get(i).getMinusDI()*100);
        }
        return stocks;

    }

}
