import java.util.ArrayList;
import java.util.Date;

public class CandleMaker {
    private Date date;
    private Integer time;
    private Double candleFull;
    private int candleView;

    public Date getDate() {
        return date;
    }

    public Integer getTime() {
        return time;
    }

    public Double getCandleFull() {
        return candleFull;
    }

    public int getCandleView() {
        return candleView;
    }

    public ArrayList<CandleMaker> candleMake(ArrayList<ElementaryInfomation> eI, ArrayList<Stocks> st){
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
            candleMaker.candleView = 000;
            candleMaker.date = eI.get(i).getDate();
            candleMaker.time = eI.get(i).getTime();

            candleMaker.candleFull = eI.get(i).getCandleFull();



            open = st.get(i+1).getOpen();
            close = st.get(i+1).getClose();
            high = st.get(i+1).getHigh();
            low = st.get(i+1).getLow();
            mid = (high-low)/2;
            full = high-low;
            body = close-open;
            fb = Math.abs(body/full);
            double clhi = high - close;
            double cllo = close - low;
            double centrePl = clhi/mid;
            double centreMn = cllo/mid;
            double ophi = high - open;
            double oplo = open - low;
            double centrOPPl = oplo/mid;
            double centrOPMN = ophi/mid;
            if (body>=0){                                   // положительная свеча(1)
                if(fb<0.05){                    // крест(1)
                    if(centrePl>0.85 && centrePl<1.15 ){          // крест в центре(1)
                        candleMaker.candleView = 111;
                    }
                    else if(centrePl<0.85){
                        candleMaker.candleView = 112;       // крест в верхней части свечи(2)
                    }
                    else if (centrePl>1.15){
                        candleMaker.candleView = 113;       // крест в нижней части свечи(3)
                    }
                }
            }
            else {                                          // отрицательная свеча(2)
                if(fb<0.05){                  // крест(1)
                    if(centreMn>0.85 && centreMn<1.15 ){      // крест в центре(1)
                        candleMaker.candleView = 211;
                    }
                    else if(centreMn<0.85){
                        candleMaker.candleView = 212;       // крест в верхней части свечи(2)
                    }
                    else if (centreMn>1.15){
                        candleMaker.candleView = 213;       // крест в нижней части свечи(3)
                    }
                }
            }
            if (body>=0){                                   // положительный свеча (1)
                if(fb>=0.5 && fb<0.6){                      // слона (2)
                    candleMaker.candleView = 121;           // размер слона(1)
                }
                else if(fb>=0.6 && fb<0.7){
                    candleMaker.candleView = 122;           // размер слона (2)
                }
                else if(fb>=0.7 && fb<0.8){
                    candleMaker.candleView = 123;           // размер слона (3)
                }
                else if(fb>=0.8 && fb<0.9){
                    candleMaker.candleView = 124;           // размер слона (4)
                }
                else if(fb>=0.9 && fb<=1){
                    candleMaker.candleView = 125;           // размер слона (5)
                }
            }
            else  {                                          // отрицательный свеча(1)
                if(fb>=0.5 && fb<0.6){                      // слона (2)
                    candleMaker.candleView = 221;           // размер слона(1)
                }
                else if(fb>=0.6 && fb<0.7){
                    candleMaker.candleView = 222;           // размер слона (2)
                }
                else if(fb>=0.7 && fb<0.8){
                    candleMaker.candleView = 223;           // размер слона (3)
                }
                else if(fb>=0.8 && fb<0.9){
                    candleMaker.candleView = 224;           // размер слона (4)
                }
                else if(fb>=0.9 && fb<=1){
                    candleMaker.candleView = 225;           // размер слона (5)
                }
            }

            if (body>=0){                                                                   // положительный свеча (1)
                if(fb>=0.05 && fb<0.1 && centrePl<=1.0 && centrOPPl<=1.0){                     // звезда (3)
                    candleMaker.candleView = 131;                                           // размер звезда(1)
                }
                else if(fb>=0.1 && fb<0.2 && centrePl<=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 132;                                           // размер звезда (2)
                }
                else if(fb>=0.2 && fb<0.3 && centrePl<=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 133;                                           // размер звезда (3)
                }
                else if(fb>=0.3 && fb<0.4 && centrePl<=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 134;                                           // размер звезда (4)
                }
                else if(fb>=0.4 && fb<0.5 && centrePl<=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 135;                                           // размер звезда (5)
                }
            }
            else {                                                                          // отрицательный свеча(1)
                if(fb>=0.05 && fb<0.1 && centreMn<=1.0 && centrOPMN<=1.0){                   // звезда (3)
                    candleMaker.candleView = 231;                                           // размер звезда(1)
                }
                else if(fb>=0.1 && fb<0.2 && centreMn<=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 232;                                           // размер звезда (2)
                }
                else if(fb>=0.2 && fb<0.3 && centreMn<=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 233;                                           // размер звезда (3)
                }
                else if(fb>=0.3 && fb<0.4 && centreMn<=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 234;                                           // размер звезда (4)
                }
                else if(fb>=0.4 && fb<0.5 && centreMn<=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 235;                                           // размер звезда (5)
                }
            }

            if (body>=0){                                                                   // положительный свеча (1)
                if(fb>=0.05 && fb<0.1 && centrePl>=1.0 && centrOPPl<=1.0){                     // молот (4)
                    candleMaker.candleView = 141;                                           // размер звезда(1)
                }
                else if(fb>=0.1 && fb<0.2 && centrePl>=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 142;                                           // размер звезда (2)
                }
                else if(fb>=0.2 && fb<0.3 && centrePl>=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 143;                                           // размер звезда (3)
                }
                else if(fb>=0.3 && fb<0.4 && centrePl>=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 144;                                           // размер звезда (4)
                }
                else if(fb>=0.4 && fb<0.5 && centrePl>=1.0 && centrOPPl<=1.0){
                    candleMaker.candleView = 145;                                           // размер звезда (5)
                }
            }
            else {                                                                          // отрицательный свеча(1)
                if(fb>=0.05 && fb<0.1 && centreMn>=1.0 && centrOPMN<=1.0){                   // звезда (3)
                    candleMaker.candleView = 241;                                           // размер звезда(1)
                }
                else if(fb>=0.1 && fb<0.2 && centreMn>=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 242;                                           // размер звезда (2)
                }
                else if(fb>=0.2 && fb<0.3 && centreMn>=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 243;                                           // размер звезда (3)
                }
                else if(fb>=0.3 && fb<0.4 && centreMn>=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 244;                                           // размер звезда (4)
                }
                else if(fb>=0.4 && fb<0.5 && centreMn>=1.0 && centrOPMN<=1.0){
                    candleMaker.candleView = 245;                                           // размер звезда (5)
                }
            }

            if (body>=0){                                                                   // положительный свеча (1)
                if(fb>=0.05 && fb<0.1 && centrePl<=1.0 && centrOPPl>=1.0){                     // топор (5)
                    candleMaker.candleView = 151;                                           // размер звезда(1)
                }
                else if(fb>=0.1 && fb<0.2 && centrePl<=1.0 && centrOPPl>=1.0){
                    candleMaker.candleView = 152;                                           // размер звезда (2)
                }
                else if(fb>=0.2 && fb<0.3 && centrePl<=1.0 && centrOPPl>=1.0){
                    candleMaker.candleView = 153;                                           // размер звезда (3)
                }
                else if(fb>=0.3 && fb<0.4 && centrePl<=1.0 && centrOPPl>=1.0){
                    candleMaker.candleView = 154;                                           // размер звезда (4)
                }
                else if(fb>=0.4 && fb<0.5 && centrePl<=1.0 && centrOPPl>=1.0){
                    candleMaker.candleView = 155;                                           // размер звезда (5)
                }
            }
            else {                                                                          // отрицательный свеча(1)
                if(fb>=0.05 && fb<0.1 && centreMn<=1.0 && centrOPMN>=1.0){                   // топор (3)
                    candleMaker.candleView = 251;                                           // размер звезда(1)
                }
                else if(fb>=0.1 && fb<0.2 && centreMn<=1.0 && centrOPMN>=1.0){
                    candleMaker.candleView = 252;                                           // размер звезда (2)
                }
                else if(fb>=0.2 && fb<0.3 && centreMn<=1.0 && centrOPMN>=1.0){
                    candleMaker.candleView = 253;                                           // размер звезда (3)
                }
                else if(fb>=0.3 && fb<0.4 && centreMn<=1.0 && centrOPMN>=1.0){
                    candleMaker.candleView = 254;                                           // размер звезда (4)
                }
                else if(fb>=0.4 && fb<0.5 && centreMn<=1.0 && centrOPMN>=1.0){
                    candleMaker.candleView = 255;                                           // размер звезда (5)
                }
            }
                result.add(candleMaker);
        }

        return result;
    }
}
