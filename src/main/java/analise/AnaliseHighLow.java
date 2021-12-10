package analise;

import java.util.ArrayList;
import java.util.Collections;

public class AnaliseHighLow {
    public static void worker(ArrayList<Analise> result) {

        for (int i = 0; i < result.size(); i++) {

            Analise analise = result.get(i);
            ArrayList<Double> max = analise.getMax();
            ArrayList<Double> min = analise.getMin();
            Collections.sort(max);
            Collections.sort(min);

            for (int j=0;j<max.size();j++){
                double x = (double) j+1.0;
                int y1 = 0;
                int y2 = 0;
                double r = x/(double)max.size();
                boolean n = r>=0.7;
                if(n){
                    y2 = max.size()-(int)x;
                    y1 = (int)x-1;
                    analise.setHigh80P(max.get(y2));
                    analise.setLow80P(min.get(y1));
                    break;
                }
            }
        }
        System.out.println("ii");
        System.out.println("pp");
    }
}
