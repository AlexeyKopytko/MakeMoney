package indicator;

import candlemaker.Stocks;

import java.util.ArrayList;

public class TrueRange {
    public static ArrayList<Stocks> worker(ArrayList<Stocks> stocks){
        for (int i=1; i<stocks.size(); i++){
            Double trueRange = 0.0;
            Double lh = 0.0;
            Double hc = 0.0;
            lh = Math.abs(stocks.get(i).getHigh()-stocks.get(i).getLow());
            hc = Math.abs(stocks.get(i).getHigh()-stocks.get(i-1).getClose());
            Double lc = Math.abs(stocks.get(i).getLow()-stocks.get(i-1).getClose());
            trueRange = Math.max(lh,hc);
            trueRange = Math.max(trueRange,lc);
            stocks.get(i).setTrueRange(trueRange);
        }
        return stocks;
    }
}
