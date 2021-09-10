package candlemaker;

import java.util.ArrayList;

public class AnaliseDiaposon {
    private int SecondParam;
    private int FirstParam;
    private ArrayList<Double> resultParam;
    private ArrayList<Double> prParam;

    public int getSecondParam() {
        return SecondParam;
    }

    public int getFirstParam() {
        return FirstParam;
    }

    public ArrayList<Double> getResultParam() {
        return resultParam;
    }

    public ArrayList<Double> getPrParam() {
        return prParam;
    }

    public ArrayList<AnaliseDiaposon> highAnaliseDiaposon(ArrayList<CandleMaker> candleMakers){
        ArrayList<AnaliseDiaposon> analiseDiaposons = new ArrayList<>();
        analiseDiaposons.add(new AnaliseDiaposon());


        for (int i=2; i<candleMakers.size(); i++) {
            AnaliseDiaposon analiseDiaposon = new AnaliseDiaposon();
            analiseDiaposon.FirstParam = candleMakers.get(i - 2).getCandleView();
            analiseDiaposon.SecondParam = candleMakers.get(i - 1).getCandleView();
            analiseDiaposon.resultParam = new ArrayList<>();

            int c=0;
            analiseDiaposon.prParam = new ArrayList<>();
            for(int q=0; q<11; q++){
                analiseDiaposon.prParam.add(0.0);
            }

            for(int k=0;k<analiseDiaposons.size();k++){
                if(analiseDiaposon.SecondParam==analiseDiaposons.get(k).SecondParam
                        && analiseDiaposon.FirstParam == analiseDiaposons.get(k).FirstParam){
                    analiseDiaposon=analiseDiaposons.get(k);
                    analiseDiaposon.resultParam.add(candleMakers.get(i).getHighPC());
                    analiseDiaposons.set(k,analiseDiaposon);

                }
                else{
                   c++;
                   if(c==analiseDiaposons.size()){
                       analiseDiaposons.add(analiseDiaposon);
                   }
                }
            }
        }

        for(int k=0;k<analiseDiaposons.size();k++){
            boolean worker=true;
            int sc = 0;
            double start = -0.2;

            while(worker) {
                double count = 0;

                if(analiseDiaposons.get(k).resultParam!=null) {
                    for (int i = 0; i < analiseDiaposons.get(k).resultParam.size(); i++) {
                        if (analiseDiaposons.get(k).resultParam.get(i) >= start) {
                            count = count + 1.0;
                        }
                    }
                    if (count==0){
                        worker=false;
                        continue;
                    }
                    double pc = 1.0;
                    if (count / (double) analiseDiaposons.get(k).resultParam.size() == pc) {
                        analiseDiaposons.get(k).prParam.set(0, rounding(start));
                    }
                    else {
                        for (int h = 0; h < 10; h++) {
                            double mpc = pc - 0.1;
                            if (count / (double) analiseDiaposons.get(k).resultParam.size() < pc &&
                                    count / (double) analiseDiaposons.get(k).resultParam.size() >= mpc) {
                                analiseDiaposons.get(k).prParam.set(h + 1, rounding(start));
                            }
                            pc = pc - 0.1;
                        }
                    }
                }
                else {
                    worker=false;
                }
                start=start+0.001;
                sc++;

                System.out.println(start+"^^^"+k);
                if(sc==400){
                    worker=false;
                }
            }
        }
        return analiseDiaposons;
    }

    public ArrayList<AnaliseDiaposon> lowAnaliseDiaposon(ArrayList<CandleMaker> candleMakers){
        ArrayList<AnaliseDiaposon> analiseDiaposons = new ArrayList<>();
        analiseDiaposons.add(new AnaliseDiaposon());


        for (int i=2; i<candleMakers.size(); i++) {
            AnaliseDiaposon analiseDiaposon = new AnaliseDiaposon();
            analiseDiaposon.FirstParam = candleMakers.get(i - 2).getCandleView();
            analiseDiaposon.SecondParam = candleMakers.get(i - 1).getCandleView();
            analiseDiaposon.resultParam = new ArrayList<>();

            int c=0;
            analiseDiaposon.prParam = new ArrayList<>();
            for(int q=0; q<11; q++){
                analiseDiaposon.prParam.add(0.0);
            }

            for(int k=0;k<analiseDiaposons.size();k++){
                if(analiseDiaposon.SecondParam==analiseDiaposons.get(k).SecondParam
                        && analiseDiaposon.FirstParam == analiseDiaposons.get(k).FirstParam){
                    analiseDiaposon=analiseDiaposons.get(k);
                    analiseDiaposon.resultParam.add(candleMakers.get(i).getLowPC());
                    analiseDiaposons.set(k,analiseDiaposon);

                }
                else{
                    c++;
                    if(c==analiseDiaposons.size()){
                        analiseDiaposons.add(analiseDiaposon);
                    }
                }
            }
        }

        for(int k=0;k<analiseDiaposons.size();k++){
            boolean worker=true;
            int sc = 0;
            double start = 0.2;

            while(worker) {
                double count = 0;

                if(analiseDiaposons.get(k).resultParam!=null) {
                    for (int i = 0; i < analiseDiaposons.get(k).resultParam.size(); i++) {
                        if (analiseDiaposons.get(k).resultParam.get(i) <= start) {
                            count = count + 1.0;
                        }
                    }
                    if (count==0){
                        worker=false;
                        continue;
                    }
                    double pc = 1.0;
                    if (count / (double) analiseDiaposons.get(k).resultParam.size() == pc) {
                        analiseDiaposons.get(k).prParam.set(0, rounding(start));
                    }
                    else {
                        for (int h = 0; h < 10; h++) {
                            double mpc = pc - 0.1;
                            if (count / (double) analiseDiaposons.get(k).resultParam.size() < pc &&
                                    count / (double) analiseDiaposons.get(k).resultParam.size() >= mpc) {
                                analiseDiaposons.get(k).prParam.set(h + 1, rounding(start));
                            }
                            pc = pc - 0.1;
                        }
                    }
                }
                else {
                    worker=false;
                }
                start=start-0.001;
                sc++;

                System.out.println(start+"^^^"+k);
                if(sc==400){
                    worker=false;
                }
            }
        }
        return analiseDiaposons;
    }

    private Double rounding(Double d){
        double k = d;
        int s1 = (int) k;
        double s2  = (d-s1)*1000;
        int s3 = (int) Math.round(s2);
        return (double) s3/1000+(double) s1;
    }
}
