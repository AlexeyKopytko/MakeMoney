package indicator;

import candlemaker.Stocks;

import java.util.ArrayList;

public class DM {
    public static ArrayList<Stocks> worker(ArrayList<Stocks> stocks){

        for (int i=1; i<stocks.size(); i++){
            Double plusDM = 0.0;
            Double minusDM = 0.0;
            if (stocks.get(i).getHigh()>stocks.get(i-1).getHigh()){
                plusDM = stocks.get(i).getHigh()-stocks.get(i-1).getHigh();
            }
            if(stocks.get(i).getLow()<stocks.get(i-1).getLow()) {
                minusDM = stocks.get(i-1).getLow() - stocks.get(i).getLow();
            }
            if(plusDM>minusDM){minusDM=0.0;}
            if(minusDM>plusDM){plusDM=0.0;}
            if(minusDM==plusDM){plusDM=0.0;minusDM=0.0;}
            stocks.get(i).setPlusDM(plusDM);
            stocks.get(i).setMinusDM(minusDM);
        }
        return stocks;
    }
}
