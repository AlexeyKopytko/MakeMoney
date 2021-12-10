package analise;

import candlemaker.CandleMaker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Analise {
    private int fParam;
    private int sParam;
    private int allCases;
    private ArrayList<Double> max = new ArrayList<>();
    private ArrayList<Double> min =  new ArrayList<>();
    private Double firstDiapasonHigh;
    private Double firstDiapasonLow;
    private Double firstDiapasonPercent;
    private Double high80P;
    private Double low80P;


    public Double getHigh80P() {
        return high80P;
    }

    public void setHigh80P(Double high80P) {
        this.high80P = high80P;
    }

    public Double getLow80P() {
        return low80P;
    }

    public void setLow80P(Double low80P) {
        this.low80P = low80P;
    }

    public ArrayList<Double> getMax() {
        return max;
    }

    public void setMax(ArrayList<Double> max) {
        this.max = max;
    }

    public ArrayList<Double> getMin() {
        return min;
    }

    public void setMin(ArrayList<Double> min) {
        this.min = min;
    }

    public int getfParam() {
        return fParam;
    }

    public void setfParam(int fParam) {
        this.fParam = fParam;
    }

    public int getsParam() {
        return sParam;
    }

    public void setsParam(int sParam) {
        this.sParam = sParam;
    }

    public int getAllCases() {
        return allCases;
    }

    public void setAllCases(int allCases) {
        this.allCases = allCases;
    }

    public Double getFirstDiapasonHigh() {
        return firstDiapasonHigh;
    }

    public void setFirstDiapasonHigh(Double firstDiapasonHigh) {
        this.firstDiapasonHigh = firstDiapasonHigh;
    }

    public Double getFirstDiapasonLow() {
        return firstDiapasonLow;
    }

    public void setFirstDiapasonLow(Double firstDiapasonLow) {
        this.firstDiapasonLow = firstDiapasonLow;
    }

    public Double getFirstDiapasonPercent() {
        return firstDiapasonPercent;
    }

    public void setFirstDiapasonPercent(Double firstDiapasonPercent) {
        this.firstDiapasonPercent = firstDiapasonPercent;
    }


    public ArrayList<Analise> worker1 (ArrayList<CandleMaker> data, int way){
        ArrayList <Analise> result = new ArrayList<>();
        AnaliseFirstSecondPar.worker(result,data,way);
        System.out.println("n");
        AnaliseTotalRange.worker(result);
        System.out.println("m");
        AnaliseHighLow.worker(result);
        System.out.println("v");
        System.out.println("n");
        /*
        Analise analise1 = new Analise();
        result.add(analise1);
        for(int i=1;i<data.size();i++){
            Analise analise = new Analise();
            analise.setfParam(data.get(i-1).getCandleView());
            analise.setsParam(data.get(i).getCandleView());
            int count = 0;
            for(int j=0; j<result.size();j++){
                if(result.get(j).getfParam()==analise.getfParam()
                        && result.get(j).getsParam()==analise.getsParam()){
                    int aC = result.get(j).getAllCases()+1;
                    result.get(j).setAllCases(aC);
                    if(i<data.size()-1) {
                        ArrayList<Double> ma = result.get(j).getMax();
                        ma.add(data.get(i).getHighPC());
                        result.get(j).setMax(ma);
                        ArrayList<Double> mi = result.get(j).getMin();
                        mi.add(data.get(i).getLowPC());
                        result.get(j).setMin(mi);
                    }
                    else{
                        ArrayList<Double> ma = result.get(j).getMax();
                        ma.add(0.0);
                        result.get(j).setMax(ma);
                        ArrayList<Double> mi = result.get(j).getMin();
                        mi.add(0.0);
                        result.get(j).setMin(mi);
                    }
                } else{
                    count++;
                }
                if(count == result.size()){
                    result.add(analise);
                }
            }
        }
        */
        /*
        for (int i=0;i<result.size(); i++){

            Analise analise = result.get(i);
            ArrayList<Double> max = analise.getMax();
            ArrayList<Double> min = analise.getMin();
            ArrayList<AllDiapasons> allDiapasons = new ArrayList<>();

            for(int ma = 0; ma<max.size(); ma++){
                for(int mi = 0; mi<min.size(); mi++ ){
                    Double h = max.get(ma);
                    Double l = min.get(mi);
                    AllDiapasons allDiapasons1 = new AllDiapasons(h, l);
                    allDiapasons.add(allDiapasons1);
                }
            }

            for (int k = 0; k<allDiapasons.size();k++){
                AllDiapasons allDiapasons1 = allDiapasons.get(k);
                for (int g=0; g<max.size(); g++ ){
                    Double maX = max.get(g);
                    Double miN = min.get(g);
                    Double hiGH = allDiapasons1.getHighDiapasons();
                    Double loW = allDiapasons1.getLowDiapasons();
                    boolean s1 = max.get(g)>allDiapasons1.getHighDiapasons();
                    boolean s2 = min.get(g)<allDiapasons1.getLowDiapasons();
                    boolean s3 = allDiapasons1.getHighDiapasons()>allDiapasons1.getLowDiapasons();

                    if(s1 && s2 && s3){
                        Double a = allDiapasons1.getAmount()+1.0;
                        allDiapasons1.setAmount(a);
                    }
                }
            }
            if(allDiapasons.size()>=2) {
                Collections.sort(allDiapasons);
            }
            if(allDiapasons.size()>=1) {
                analise.setFirstDiapasonHigh(allDiapasons.get(0).getHighDiapasons());
                analise.setFirstDiapasonLow(allDiapasons.get(0).getLowDiapasons());
                analise.setFirstDiapasonPercent(allDiapasons.get(0).getAmount() / analise.getAllCases());
            }

            result.set(i, analise);
        }
         */
        return result;
    }
}

