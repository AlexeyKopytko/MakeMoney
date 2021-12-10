package analise;

import candlemaker.CandleMaker;

import java.util.ArrayList;

public class AnaliseFirstSecondPar {

    public static void worker(ArrayList<Analise> result,ArrayList<CandleMaker> data,int way){
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
                        ArrayList<Double> ma = new ArrayList<>();
                        ArrayList<Double> mi = new ArrayList<>();
                        switch (way) {
                            case 1:
                                ma = result.get(j).getMax();
                                ma.add(data.get(i).getHighPC());
                                result.get(j).setMax(ma);
                                mi = result.get(j).getMin();
                                mi.add(data.get(i).getLowPC());
                                result.get(j).setMin(mi);
                                break;
                            case 2:
                                ma = result.get(j).getMax();
                                ma.add(data.get(i).getHighPC2());
                                result.get(j).setMax(ma);
                                mi = result.get(j).getMin();
                                mi.add(data.get(i).getLowPC2());
                                result.get(j).setMin(mi);
                                break;
                            case 3:
                                ma = result.get(j).getMax();
                                ma.add(data.get(i).getHighPC3());
                                result.get(j).setMax(ma);
                                mi = result.get(j).getMin();
                                mi.add(data.get(i).getLowPC3());
                                result.get(j).setMin(mi);
                                break;
                            case 4:
                                ma = result.get(j).getMax();
                                ma.add(data.get(i).getHighPC4());
                                result.get(j).setMax(ma);
                                mi = result.get(j).getMin();
                                mi.add(data.get(i).getLowPC4());
                                result.get(j).setMin(mi);
                                break;
                            case 5:
                                ma = result.get(j).getMax();
                                ma.add(data.get(i).getHighPC5());
                                result.get(j).setMax(ma);
                                mi = result.get(j).getMin();
                                mi.add(data.get(i).getLowPC5());
                                result.get(j).setMin(mi);
                                break;
                        }
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
    }
}
