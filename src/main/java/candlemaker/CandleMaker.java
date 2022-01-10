package candlemaker;

import java.util.ArrayList;
import java.util.Date;

public class CandleMaker {
    private Date date;
    private Integer time;
    private Double candleFull;
    private int candleView;
    private String codeADX;
    private double highPC;
    private double lowPC;
    private double closePC;
    private double highPC2;
    private double lowPC2;
    private double closePC2;
    private double highPC3;
    private double lowPC3;
    private double closePC3;
    private double highPC4;
    private double lowPC4;
    private double closePC4;
    private double highPC5;
    private double lowPC5;
    private double closePC5;


    public double getClosePC() {
        return closePC;
    }

    public double getClosePC2() {
        return closePC2;
    }

    public double getClosePC3() {
        return closePC3;
    }

    public double getClosePC4() {
        return closePC4;
    }

    public double getClosePC5() {
        return closePC5;
    }

    public String getCodeADX() {
        return codeADX;
    }

    public void setCodeADX(String codeADX) {
        this.codeADX = codeADX;
    }

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

    public double getHighPC() {
        return highPC;
    }

    public double getLowPC() {
        return lowPC;
    }

    public double getHighPC2() {
        return highPC2;
    }

    public double getLowPC2() {
        return lowPC2;
    }

    public double getHighPC3() {
        return highPC3;
    }

    public double getLowPC3() {
        return lowPC3;
    }

    public double getHighPC4() {
        return highPC4;
    }

    public double getLowPC4() {
        return lowPC4;
    }

    public double getHighPC5() {
        return highPC5;
    }

    public double getLowPC5() {
        return lowPC5;
    }

    public ArrayList<CandleMaker> candleMake(ArrayList<ElementaryInfomation> eI, ArrayList<Stocks> st) {
        ArrayList<CandleMaker> result = new ArrayList<>();
        Double body = 0.0;
        Double full = 0.0;
        Double mid = 0.0;
        Double fb = 0.0;
        Double open = 0.0;
        Double close = 0.0;
        Double high = 0.0;
        Double low = 0.0;
        for (int i = 0; i < eI.size(); i++) {
            CandleMaker candleMaker = new CandleMaker();
            candleMaker.highPC = (st.get(i + 1).getHigh() - st.get(i).getClose()) / st.get(i).getClose();
            candleMaker.lowPC = (st.get(i + 1).getLow() - st.get(i).getClose()) / st.get(i).getClose();
            candleMaker.candleView = 000;
            candleMaker.date = eI.get(i).getDate();
            candleMaker.time = eI.get(i).getTime();

            candleMaker.candleFull = eI.get(i).getCandleFull();


            open = st.get(i + 1).getOpen();
            close = st.get(i + 1).getClose();
            high = st.get(i + 1).getHigh();
            low = st.get(i + 1).getLow();
            mid = (high - low) / 2;
            full = high - low;
            body = close - open;
            fb = Math.abs(body / full);
            double clhi = high - close;
            double cllo = close - low;
            double centrePl = clhi / mid;
            double centreMn = cllo / mid;
            double ophi = high - open;
            double oplo = open - low;
            double centrOPPl = oplo / mid;
            double centrOPMN = ophi / mid;
            if (body >= 0) {                                   // положительная свеча(1)
                if (fb < 0.05) {                    // крест(1)
                    if (centrePl > 0.85 && centrePl < 1.15) {          // крест в центре(1)
                        candleMaker.candleView = 111;
                    } else if (centrePl < 0.85) {
                        candleMaker.candleView = 112;       // крест в верхней части свечи(2)
                    } else if (centrePl > 1.15) {
                        candleMaker.candleView = 113;       // крест в нижней части свечи(3)
                    }
                }
            } else {                                          // отрицательная свеча(2)
                if (fb < 0.05) {                  // крест(1)
                    if (centreMn > 0.85 && centreMn < 1.15) {      // крест в центре(1)
                        candleMaker.candleView = 211;
                    } else if (centreMn < 0.85) {
                        candleMaker.candleView = 212;       // крест в верхней части свечи(2)
                    } else if (centreMn > 1.15) {
                        candleMaker.candleView = 213;       // крест в нижней части свечи(3)
                    }
                }
            }
            if (body >= 0) {                                   // положительный свеча (1)
                if (fb >= 0.5 && fb < 0.6) {                      // слона (2)
                    candleMaker.candleView = 121;           // размер слона(1)
                } else if (fb >= 0.6 && fb < 0.7) {
                    candleMaker.candleView = 122;           // размер слона (2)
                } else if (fb >= 0.7 && fb < 0.8) {
                    candleMaker.candleView = 123;           // размер слона (3)
                } else if (fb >= 0.8 && fb < 0.9) {
                    candleMaker.candleView = 124;           // размер слона (4)
                } else if (fb >= 0.9 && fb <= 1) {
                    candleMaker.candleView = 125;           // размер слона (5)
                }
            } else {                                          // отрицательный свеча(1)
                if (fb >= 0.5 && fb < 0.6) {                      // слона (2)
                    candleMaker.candleView = 221;           // размер слона(1)
                } else if (fb >= 0.6 && fb < 0.7) {
                    candleMaker.candleView = 222;           // размер слона (2)
                } else if (fb >= 0.7 && fb < 0.8) {
                    candleMaker.candleView = 223;           // размер слона (3)
                } else if (fb >= 0.8 && fb < 0.9) {
                    candleMaker.candleView = 224;           // размер слона (4)
                } else if (fb >= 0.9 && fb <= 1) {
                    candleMaker.candleView = 225;           // размер слона (5)
                }
            }

            if (body >= 0) {                                                                   // положительный свеча (1)
                if (fb >= 0.05 && fb < 0.1 && centrePl <= 1.0 && centrOPPl <= 1.0) {                     // звезда (3)
                    candleMaker.candleView = 131;                                           // размер звезда(1)
                } else if (fb >= 0.1 && fb < 0.2 && centrePl <= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 132;                                           // размер звезда (2)
                } else if (fb >= 0.2 && fb < 0.3 && centrePl <= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 133;                                           // размер звезда (3)
                } else if (fb >= 0.3 && fb < 0.4 && centrePl <= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 134;                                           // размер звезда (4)
                } else if (fb >= 0.4 && fb < 0.5 && centrePl <= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 135;                                           // размер звезда (5)
                }
            } else {                                                                          // отрицательный свеча(1)
                if (fb >= 0.05 && fb < 0.1 && centreMn <= 1.0 && centrOPMN <= 1.0) {                   // звезда (3)
                    candleMaker.candleView = 231;                                           // размер звезда(1)
                } else if (fb >= 0.1 && fb < 0.2 && centreMn <= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 232;                                           // размер звезда (2)
                } else if (fb >= 0.2 && fb < 0.3 && centreMn <= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 233;                                           // размер звезда (3)
                } else if (fb >= 0.3 && fb < 0.4 && centreMn <= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 234;                                           // размер звезда (4)
                } else if (fb >= 0.4 && fb < 0.5 && centreMn <= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 235;                                           // размер звезда (5)
                }
            }

            if (body >= 0) {                                                                   // положительный свеча (1)
                if (fb >= 0.05 && fb < 0.1 && centrePl >= 1.0 && centrOPPl <= 1.0) {                     // молот (4)
                    candleMaker.candleView = 141;                                           // размер молот(1)
                } else if (fb >= 0.1 && fb < 0.2 && centrePl >= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 142;                                           // размер молот (2)
                } else if (fb >= 0.2 && fb < 0.3 && centrePl >= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 143;                                           // размер молот (3)
                } else if (fb >= 0.3 && fb < 0.4 && centrePl >= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 144;                                           // размер молот (4)
                } else if (fb >= 0.4 && fb < 0.5 && centrePl >= 1.0 && centrOPPl <= 1.0) {
                    candleMaker.candleView = 145;                                           // размер молот (5)
                }
            } else {                                                                          // отрицательный свеча(1)
                if (fb >= 0.05 && fb < 0.1 && centreMn <= 1.0 && centrOPMN >= 1.0) {                   // молот (4)
                    candleMaker.candleView = 241;                                           // размер молот(1)
                } else if (fb >= 0.1 && fb < 0.2 && centreMn <= 1.0 && centrOPMN >= 1.0) {
                    candleMaker.candleView = 242;                                           // размер молот (2)
                } else if (fb >= 0.2 && fb < 0.3 && centreMn <= 1.0 && centrOPMN >= 1.0) {
                    candleMaker.candleView = 243;                                           // размер молот (3)
                } else if (fb >= 0.3 && fb < 0.4 && centreMn <= 1.0 && centrOPMN >= 1.0) {
                    candleMaker.candleView = 244;                                           // размер молот (4)
                } else if (fb >= 0.4 && fb < 0.5 && centreMn <= 1.0 && centrOPMN >= 1.0) {
                    candleMaker.candleView = 245;                                           // размер молот (5)
                }
            }


            if (body >= 0) {                                                                   // положительный свеча (1)
                if (fb >= 0.05 && fb < 0.1 && centrePl <= 1.0 && centrOPPl >= 1.0) {                     // топор (5)
                    candleMaker.candleView = 151;                                           // размер топор(1)
                } else if (fb >= 0.1 && fb < 0.2 && centrePl <= 1.0 && centrOPPl >= 1.0) {
                    candleMaker.candleView = 152;                                           // размер топор (2)
                } else if (fb >= 0.2 && fb < 0.3 && centrePl <= 1.0 && centrOPPl >= 1.0) {
                    candleMaker.candleView = 153;                                           // размер топор (3)
                } else if (fb >= 0.3 && fb < 0.4 && centrePl <= 1.0 && centrOPPl >= 1.0) {
                    candleMaker.candleView = 154;                                           // размер топор (4)
                } else if (fb >= 0.4 && fb < 0.5 && centrePl <= 1.0 && centrOPPl >= 1.0) {
                    candleMaker.candleView = 155;                                           // размер топор (5)
                }
            } else {                                                                          // отрицательный свеча(1)
                if (fb >= 0.05 && fb < 0.1 && centreMn >= 1.0 && centrOPMN <= 1.0) {                   // топор (5)
                    candleMaker.candleView = 251;                                           // размер топор(1)
                } else if (fb >= 0.1 && fb < 0.2 && centreMn >= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 252;                                           // размер топор (2)
                } else if (fb >= 0.2 && fb < 0.3 && centreMn >= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 253;                                           // размер топор (3)
                } else if (fb >= 0.3 && fb < 0.4 && centreMn >= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 254;                                           // размер топор (4)
                } else if (fb >= 0.4 && fb < 0.5 && centreMn >= 1.0 && centrOPMN <= 1.0) {
                    candleMaker.candleView = 255;                                           // размер топор (5)
                }
            }


            result.add(candleMaker);
        }

        return result;
    }

    public ArrayList<CandleMaker> makeFuture(ArrayList<CandleMaker> cM, ArrayList<Stocks> sT) {
        ArrayList<CandleMaker> result = new ArrayList<>();
        for (int i = 0; i < cM.size(); i++) {
            for (int h = 0; h < sT.size(); h++) {
                if (h < (sT.size() - 6)) {
                    long x1 = cM.get(i).getDate().getTime();
                    long x2 = sT.get(h).getDate().getTime();
                    int y1 = cM.get(i).getTime();
                    int y2 = sT.get(h).getTime();


                    if (x1 == x2 && y1 == y2) {
                        CandleMaker candleMaker = cM.get(i);
                        double hPC1x1 = sT.get(h + 1).getHigh();
                        double hPC1x2 = sT.get(h).getClose();

                        double hPC1 = (hPC1x1 - hPC1x2) / hPC1x2;

                        double lPC1y1 = sT.get(h + 1).getLow();
                        double lPC1 = (lPC1y1 - hPC1x2) / hPC1x2;

                        double hPC2 = (sT.get(h + 2).getHigh() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double lPC2 = (sT.get(h + 2).getLow() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double hPC3 = (sT.get(h + 3).getHigh() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double lPC3 = (sT.get(h + 3).getLow() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double hPC4 = (sT.get(h + 4).getHigh() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double lPC4 = (sT.get(h + 4).getLow() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double hPC5 = (sT.get(h + 5).getHigh() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double lPC5 = (sT.get(h + 5).getLow() - sT.get(h).getClose()) / sT.get(h).getClose();
                        double cPC1 = (sT.get(h+1).getClose()-hPC1x2)/hPC1x2;
                        double cPC2 = (sT.get(h+2).getClose()-hPC1x2)/hPC1x2;
                        double cPC3 = (sT.get(h+3).getClose()-hPC1x2)/hPC1x2;
                        double cPC4 = (sT.get(h+4).getClose()-hPC1x2)/hPC1x2;
                        double cPC5 = (sT.get(h+5).getClose()-hPC1x2)/hPC1x2;
                        candleMaker.highPC = hPC1;
                        candleMaker.lowPC = lPC1;
                        candleMaker.highPC2 = hPC2;
                        candleMaker.lowPC2 = lPC2;
                        candleMaker.highPC3 = hPC3;
                        candleMaker.lowPC3 = lPC3;
                        candleMaker.highPC4 = hPC4;
                        candleMaker.lowPC4 = lPC4;
                        candleMaker.highPC5 = hPC5;
                        candleMaker.lowPC5 = lPC5;
                        candleMaker.closePC = cPC1;
                        candleMaker.closePC2 = cPC2;
                        candleMaker.closePC3 = cPC3;
                        candleMaker.closePC4 = cPC4;
                        candleMaker.closePC5 = cPC5;
                        result.add(candleMaker);
                        break;
                    }
                } else {
                    if (cM.get(i).getDate() == sT.get(h).getDate() &&
                            cM.get(i).getTime() == sT.get(h).getTime()) {
                        CandleMaker candleMaker = cM.get(i);
                        candleMaker.highPC2 = 0.0;
                        candleMaker.lowPC2 = 0.0;
                        candleMaker.highPC3 = 0.0;
                        candleMaker.lowPC3 = 0.0;
                        candleMaker.highPC4 = 0.0;
                        candleMaker.lowPC4 = 0.0;
                        candleMaker.highPC5 = 0.0;
                        candleMaker.lowPC5 = 0.0;
                        candleMaker.closePC = 0.0;
                        candleMaker.closePC2 = 0.0;
                        candleMaker.closePC3 = 0.0;
                        candleMaker.closePC4 = 0.0;
                        candleMaker.closePC5 = 0.0;
                        result.add(candleMaker);
                    }
                }
            }
        }
        return result;
    }
    public ArrayList<CandleMaker> makeFutureCode(ArrayList<CandleMaker> cM) {
        ArrayList<CandleMaker> result = new ArrayList<>();
        for (int i=0; i<cM.size(); i++){
            CandleMaker cm = cM.get(i);
            cm.closePC = cod(cm.closePC);
            cm.closePC2 = cod(cm.closePC2);
            cm.closePC3 = cod(cm.closePC3);
            cm.closePC4 = cod(cm.closePC4);
            cm.closePC5 = cod(cm.closePC5);
            cm.highPC = cod(cm.highPC);
            cm.highPC2 = cod(cm.highPC2);
            cm.highPC3 = cod(cm.highPC3);
            cm.highPC4 = cod(cm.highPC4);
            cm.highPC5 = cod(cm.highPC5);
            cm.lowPC = cod(cm.lowPC);
            cm.lowPC2 = cod(cm.lowPC2);
            cm.lowPC3 = cod(cm.lowPC3);
            cm.lowPC4 = cod(cm.lowPC4);
            cm.lowPC5 = cod(cm.lowPC5);
            result.add(cm);
        }
        return result;
    }


    private Double cod (double price){
        ArrayList<Double> max = new ArrayList<>();
        ArrayList<Double> min = new ArrayList<>();
        ArrayList<Double> code = new ArrayList<>();
        max.add(-99999999.0);
        min.add(-4.0);
        double x = -4.0;
        double y =0.5;
        for(int i = 1; i<20; i++){
            code.add((double) i);
            max.add(x);
            if(x<4.0) {
                min.add(x + y);
            }
            x= x+y;
            if(x==-1.0){
                y=0.4;
            }
            if(x==1.0){
                y=0.5;
            }
        }
        min.add(9999999.0);
        double result=0;
        for(int k = 0; k<min.size();k++){
            double prCl = price;
            if(prCl*100<=min.get(k) && prCl*100>max.get(k)){
                result = code.get(k);
                break;
            }
        }
        return result;
    }
}
