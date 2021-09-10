package candlemaker;

import java.util.ArrayList;
import java.util.Collections;


public class AnaliseCandle implements Comparable<AnaliseCandle> {
    private int SecondParam;
    private int FirstParam;
    private int ResultParam;
    private int countP;

    public int getUnicCandle() {
        return FirstParam;
    }

    public int getNextCandle() {
        return ResultParam;
    }

    public int getCountNextCandle() {
        return countP;
    }

    public int getUnicPrivCandle() {
        return SecondParam;
    }

    public ArrayList<AnaliseCandle> analiseCandles(ArrayList<CandleMaker> candleMakers){
        ArrayList<AnaliseCandle> analiseCandles = new ArrayList<>();
        analiseCandles.add(new AnaliseCandle());

        for (int i=1; i<candleMakers.size(); i++){
            AnaliseCandle analiseCandle = new AnaliseCandle();
            analiseCandle.FirstParam = candleMakers.get(i-1).getCandleView();
            analiseCandle.ResultParam = candleMakers.get(i).getCandleView();
            analiseCandle.countP = 0;
            int c = 0;
            for (int j=0; j<analiseCandles.size();j++){
                if (analiseCandle.FirstParam==analiseCandles.get(j).FirstParam
                        && analiseCandle.ResultParam==analiseCandles.get(j).ResultParam){
                    int count = analiseCandles.get(j).countP+1;
                    analiseCandle.countP=count;
                    analiseCandles.set(j,analiseCandle);
                }
                else{
                    c++;
                    if(c==analiseCandles.size()){
                      analiseCandles.add(analiseCandle);
                    }
                }
            }
        }
        Collections.sort(analiseCandles);
        return analiseCandles;
    }

    public ArrayList<Integer> unicCandel (ArrayList<AnaliseCandle> analiseCandles){
        ArrayList<Integer> unicCandels = new ArrayList<>();
        for(int i=1; i<analiseCandles.size(); i++){
            if(analiseCandles.get(i-1).getUnicCandle()!=analiseCandles.get(i).getUnicCandle()){
                unicCandels.add(analiseCandles.get(i).getUnicCandle());
            }
        }
        return unicCandels;
    }

    public ArrayList<AnaliseCandle> dAnaliseCandles(ArrayList<CandleMaker> candleMakers){
        ArrayList<AnaliseCandle> analiseCandles = new ArrayList<>();
        analiseCandles.add(new AnaliseCandle());

        for (int i=2; i<candleMakers.size(); i++){
            AnaliseCandle analiseCandle = new AnaliseCandle();
            analiseCandle.SecondParam = candleMakers.get(i-2).getCandleView();
            analiseCandle.FirstParam = candleMakers.get(i-1).getCandleView();
            analiseCandle.ResultParam = candleMakers.get(i).getCandleView();
            analiseCandle.countP = 0;
            int c = 0;
            for (int j=0; j<analiseCandles.size();j++){
                if (analiseCandle.FirstParam==analiseCandles.get(j).FirstParam
                        && analiseCandle.ResultParam==analiseCandles.get(j).ResultParam
                        && analiseCandle.SecondParam==analiseCandles.get(j).SecondParam){
                    int count = analiseCandles.get(j).countP+1;
                    analiseCandle.countP=count;
                    analiseCandles.set(j,analiseCandle);
                }
                else{
                    c++;
                    if(c==analiseCandles.size()){
                        analiseCandles.add(analiseCandle);
                    }
                }
            }
        }
        Collections.sort(analiseCandles);
        return analiseCandles;
    }

    public class StructureCandel{



    }


    @Override
    public int compareTo(AnaliseCandle o) {
        int unP1 = this.SecondParam;
        int unP2 = o.SecondParam;
        int fCP = unP1-unP2;
        if (fCP!=0){
            return fCP;
        }
        int un1 = this.FirstParam;
        int un2 = o.FirstParam;
        int fC = un1-un2;
        if (fC!=0){
            return fC;
        }
        int ne1 = this.ResultParam;
        int ne2 = o.ResultParam;
        return ne1-ne2;
    }
}
