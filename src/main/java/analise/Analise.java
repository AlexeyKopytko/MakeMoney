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
    private Double secondDiapasonHigh;
    private Double secondDiapasonLow;
    private Double secondDiapasonPercent;
    private Double thirdDiapasonHigh;
    private Double thirdDiapasonLow;
    private Double thirdDiapasonPercent;


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

    public Double getSecondDiapasonHigh() {
        return secondDiapasonHigh;
    }

    public void setSecondDiapasonHigh(Double secondDiapasonHigh) {
        this.secondDiapasonHigh = secondDiapasonHigh;
    }

    public Double getSecondDiapasonLow() {
        return secondDiapasonLow;
    }

    public void setSecondDiapasonLow(Double secondDiapasonLow) {
        this.secondDiapasonLow = secondDiapasonLow;
    }

    public Double getSecondDiapasonPercent() {
        return secondDiapasonPercent;
    }

    public void setSecondDiapasonPercent(Double secondDiapasonPercent) {
        this.secondDiapasonPercent = secondDiapasonPercent;
    }

    public Double getThirdDiapasonHigh() {
        return thirdDiapasonHigh;
    }

    public void setThirdDiapasonHigh(Double thirdDiapasonHigh) {
        this.thirdDiapasonHigh = thirdDiapasonHigh;
    }

    public Double getThirdDiapasonLow() {
        return thirdDiapasonLow;
    }

    public void setThirdDiapasonLow(Double thirdDiapasonLow) {
        this.thirdDiapasonLow = thirdDiapasonLow;
    }

    public Double getThirdDiapasonPercent() {
        return thirdDiapasonPercent;
    }

    public void setThirdDiapasonPercent(Double thirdDiapasonPercent) {
        this.thirdDiapasonPercent = thirdDiapasonPercent;
    }

    public ArrayList<Analise> worker (ArrayList<CandleMaker> data){
        ArrayList <Analise> result = new ArrayList<>();

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
                    ArrayList<Double> ma = result.get(j).getMax();
                    ma.add(data.get(i).getHighPC());
                    result.get(j).setMax(ma);
                    ArrayList<Double> mi = result.get(j).getMin();
                    mi.add(data.get(i).getLowPC());
                    result.get(j).setMax(mi);
                } else{
                    count++;
                }
                if(count == result.size()){
                    result.add(analise);
                }
            }
        }
        ArrayList<AllDiapasons> allDiapasons = AllDiapasons.diapasons();

        for (int i=0;i<result.size(); i++){

            Analise analise = result.get(i);
            ArrayList<Double> max = analise.getMax();
            ArrayList<Double> min = analise.getMin();

            for (int k = 0; k<allDiapasons.size();k++){

                AllDiapasons allDiapasons1 = allDiapasons.get(k);
                for (int g=0; g<max.size(); g++ ){
                    if(max.get(g)>allDiapasons1.getHighDiapasons()
                            && min.get(g)<allDiapasons1.getLowDiapasons()){
                        Double a = allDiapasons1.getAmount()+1.0;
                        allDiapasons1.setAmount(a);
                    }
                }
            }
            Collections.sort(allDiapasons);
            analise.setFirstDiapasonHigh(allDiapasons.get(0).getHighDiapasons());
            analise.setFirstDiapasonLow(allDiapasons.get(0).getLowDiapasons());
            analise.setFirstDiapasonPercent(allDiapasons.get(0).getAmount()/analise.getAllCases());
            analise.setSecondDiapasonHigh(allDiapasons.get(1).getHighDiapasons());
            analise.setSecondDiapasonLow(allDiapasons.get(1).getLowDiapasons());
            analise.setSecondDiapasonPercent(allDiapasons.get(1).getAmount()/analise.getAllCases());
            analise.setThirdDiapasonHigh(allDiapasons.get(2).getHighDiapasons());
            analise.setThirdDiapasonLow(allDiapasons.get(2).getLowDiapasons());
            analise.setThirdDiapasonPercent(allDiapasons.get(2).getAmount()/analise.getAllCases());

            result.set(i, analise);

            for(int w=0;w<allDiapasons.size();w++){
                allDiapasons.get(w).setAmount(0.0);
            }


        }




        return result;
    }
}

