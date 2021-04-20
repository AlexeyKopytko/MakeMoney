import java.util.ArrayList;
import java.util.Collections;

public class Gipoteza1 {
    private double uniqueCandleFull;
    private double prInc;
    private double prDic;
    private double vsIncDic;
    private double prIncF;
    private double prDicF;
    private double vsIncFDicF;

    public Double getUniqueCandleFull() {
        return uniqueCandleFull;
    }

    public Double getPrInc() {
        return prInc;
    }

    public Double getPrDic() {
        return prDic;
    }

    public Double getPrIncF() {
        return prIncF;
    }

    public Double getPrDicF() {
        return prDicF;
    }

    public double getVsIncDic() {
        return vsIncDic;
    }

    public double getVsIncFDicF() {
        return vsIncFDicF;
    }


    public ArrayList<Double> uniqueCandleFulls (ArrayList<ElementaryInfomation> elementaryInfomations){
        ArrayList<Double> uniqueCandleFulls = new ArrayList<>();
        for (int i=0; i<elementaryInfomations.size();i++){
           if(!uniqueCandleFulls.contains(elementaryInfomations.get(i).getCandleFull())){
               uniqueCandleFulls.add(elementaryInfomations.get(i).getCandleFull());
           }
        }
        Collections.sort(uniqueCandleFulls);
        return uniqueCandleFulls;
    }

    public ArrayList<Gipoteza1> worker(ArrayList<ElementaryInfomation> elementaryInfomations){
        ArrayList<Double> uniqueCandleFulls = uniqueCandleFulls(elementaryInfomations);
        ArrayList<Gipoteza1> result = new ArrayList<>();
        for (Double u: uniqueCandleFulls){
            Gipoteza1 g = new Gipoteza1();
            g.uniqueCandleFull =u;
            result.add(g);
        }

        for (int i = 0; i<result.size(); i++){
            double countP=0.0;
            double countM=0.0;
            double countPf=0.0;
            double countMf=0.0
                    ;
            for (int j = 0; j<elementaryInfomations.size()-1;j++) {
                double x = result.get(i).getUniqueCandleFull();
                double y = elementaryInfomations.get(j).getCandleFull();
                if(x==y){
                    if(elementaryInfomations.get(j+1).getCloseCH()>0){
                        countP++;
                    }
                    else {
                        countM++;
                    }
                    double fCL = 0;
                    if(elementaryInfomations.size()-j>6){
                        fCL=elementaryInfomations.get(j+1).getCloseCH()+elementaryInfomations.get(j+2).getCloseCH()
                                +elementaryInfomations.get(j+3).getCloseCH()+elementaryInfomations.get(j+4).getCloseCH()
                                +elementaryInfomations.get(j+5).getCloseCH();
                    }
                    if(fCL>0){
                        countPf++;
                    }
                    else {
                        countMf++;
                    }
                }
            }
            result.get(i).prInc=countP;
            result.get(i).prDic=countM;
            result.get(i).vsIncDic = result.get(i).prInc/(result.get(i).prInc+result.get(i).prDic);
            result.get(i).prIncF=countPf;
            result.get(i).prDicF=countMf;
            result.get(i).vsIncFDicF = result.get(i).prIncF/(result.get(i).prIncF+result.get(i).prDicF);
        }

        return result;
    }
}
