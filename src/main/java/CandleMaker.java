import java.util.ArrayList;
import java.util.Date;

public class CandleMaker {
    private Date date;
    private Integer time;
    private Double candleFull;
    private int candleView;

    public ArrayList<CandleMaker> candleMake(ArrayList<ElementaryInfomation> eI,ArrayList<Stocks> st){
        ArrayList<CandleMaker> result = new ArrayList<>();
        Double body = 0.0;
        Double full = 0.0;
        Double mid = 0.0;
        Double fb = 0.0;
        Double open = 0.0;
        Double close = 0.0;
        Double high = 0.0;
        Double low = 0.0;
        for(int i=0; i<eI.size(); i++){
            CandleMaker candleMaker = new CandleMaker();
            candleMaker.date = eI.get(i).getDate();
            candleMaker.time = eI.get(i).getTime();
            full = eI.get(i).getCandleFull();
            candleMaker.candleFull = full;
            body = eI.get(i).getCandleBody();
            mid = full/2;
            fb = full/body;
            open = st.get(i+1).getOpen();
            close = st.get(i+1).getClose();
            high = st.get(i+1).getHigh();
            low = st.get(i+1).getLow();
            double clhi = high - close;
            double opcl = close - low;
            double centrePl = clhi/mid;
            double centreMn = opcl/mid;
            if (body>=0){                                   // положительная свеча(1)
                if(body<3.0 || fb<0.05){                    // крест(1)
                    if(centrePl>0.8 && centrePl<1.2 ){          // крест в центре(1)
                        candleMaker.candleView = 111;
                    }
                    else if(centrePl<0.8){
                        candleMaker.candleView = 112;       // крест в верхней части свечи(2)
                    }
                    else if (centrePl>1.2){
                        candleMaker.candleView = 113;       // крест в нижней части свечи(3)
                    }
                }
            }
            else {                                          // отрицательная свеча(2)
                if(body>-3.0 || fb<-0.05){                  // крест(1)
                    if(centreMn>0.8 && centreMn<1.2 ){      // крест в центре(1)
                        candleMaker.candleView = 211;
                    }
                    else if(centreMn<0.8){
                        candleMaker.candleView = 212;       // крест в верхней части свечи(2)
                    }
                    else if (centreMn>1.2){
                        candleMaker.candleView = 213;       // крест в нижней части свечи(3)
                    }
                }
            }

            if (body>=0){

            }
            else {

            }
                result.add(candleMaker);
        }

        return result;
    }
}
