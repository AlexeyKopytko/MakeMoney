package analise;

import java.util.ArrayList;
import java.util.Collections;

public class AnaliseTotalRange {

    public static void worker(ArrayList <Analise> result) {
        for (int i = 0; i < result.size(); i++) {

            Analise analise = result.get(i);
            ArrayList<Double> max = analise.getMax();
            ArrayList<Double> min = analise.getMin();
            ArrayList<AllDiapasons> allDiapasons = new ArrayList<>();

            for (int ma = 0; ma < max.size(); ma++) {
                for (int mi = 0; mi < min.size(); mi++) {
                    Double h = max.get(ma);
                    Double l = min.get(mi);
                    AllDiapasons allDiapasons1 = new AllDiapasons(h, l);
                    allDiapasons.add(allDiapasons1);
                }
            }

            for (int k = 0; k < allDiapasons.size(); k++) {
                AllDiapasons allDiapasons1 = allDiapasons.get(k);
                for (int g = 0; g < max.size(); g++) {
                    Double maX = max.get(g);
                    Double miN = min.get(g);
                    Double hiGH = allDiapasons1.getHighDiapasons();
                    Double loW = allDiapasons1.getLowDiapasons();
                    boolean s1 = max.get(g) > allDiapasons1.getHighDiapasons();
                    boolean s2 = min.get(g) < allDiapasons1.getLowDiapasons();
                    boolean s3 = allDiapasons1.getHighDiapasons() > allDiapasons1.getLowDiapasons();

                    if (s1 && s2 && s3) {
                        Double a = allDiapasons1.getAmount() + 1.0;
                        allDiapasons1.setAmount(a);
                    }
                }
            }
            if (allDiapasons.size() >= 2) {
                Collections.sort(allDiapasons);
            }
            if (allDiapasons.size() >= 1) {
                analise.setFirstDiapasonHigh(allDiapasons.get(0).getHighDiapasons());
                analise.setFirstDiapasonLow(allDiapasons.get(0).getLowDiapasons());
                analise.setFirstDiapasonPercent(allDiapasons.get(0).getAmount() / analise.getAllCases());
            }
        }
    }
}
