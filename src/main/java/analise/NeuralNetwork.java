package analise;


import candlemaker.CandleMaker;

import java.util.ArrayList;

public class NeuralNetwork {
    private ArrayList<Integer> candle = new ArrayList<>();
    private ArrayList<Integer> adx = new ArrayList<>();
    private Integer codeClosePrice1 = 0;

    public ArrayList<Integer> getCandle() {
        return candle;
    }

    public ArrayList<Integer> getAdx() {
        return adx;
    }

    public Integer getCodeClosePrice1() {
        return codeClosePrice1;
    }

    public static ArrayList<NeuralNetwork> neuralNetworks(ArrayList<CandleMaker> candleMakers){
        ArrayList<NeuralNetwork> result = new ArrayList<>();
        ArrayList<Double> max = new ArrayList<>();
        ArrayList<Double> min = new ArrayList<>();
        ArrayList<Integer> code = new ArrayList<>();
        max.add(-99999999.0);
        min.add(-4.0);
        double x = -4.0;
        double y =0.5;
        for(int i = 1; i<20; i++){
            code.add(i);
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

        for (int i=15;i<candleMakers.size()-1;i++){
            NeuralNetwork neuralNetwork =new NeuralNetwork();
            for (int j=i;j>=i-15;j--){
                int q = candleMakers.get(j).getCandleView();
                neuralNetwork.candle.add(q);
                q = Integer.parseInt(candleMakers.get(j).getCodeADX());
                neuralNetwork.adx.add(q);
            }
            int cCP1=0;
            for(int k = 0; k<min.size();k++){
                double prCl = candleMakers.get(i).getClosePC();

                  if(prCl*100<=min.get(k) && prCl*100>max.get(k)){
                      cCP1=code.get(k);
                      break;
                  }


            }
            neuralNetwork.codeClosePrice1=cCP1;
            result.add(neuralNetwork);
        }
        return result;
    }




}
