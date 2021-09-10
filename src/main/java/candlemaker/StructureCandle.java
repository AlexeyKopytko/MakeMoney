package candlemaker;

import java.util.ArrayList;

public class StructureCandle {
    private int secondParam;
    private int firstParam;

    private int allCases;
    private int upCases;
    private double addiction;

    public int getSecondParam() {
        return secondParam;
    }

    public int getFirstParam() {
        return firstParam;
    }

    public int getAllCases() {
        return allCases;
    }

    public int getUpCases() {
        return upCases;
    }

    public double getAddiction() {
        return addiction;
    }

    public ArrayList<StructureCandle> structureCandels(ArrayList<AnaliseCandle> analiseCandles){
        ArrayList<StructureCandle> structureCandles = new ArrayList<>();
        structureCandles.add(new StructureCandle());

        for (int i=0; i<analiseCandles.size(); i++){
            StructureCandle structureCandle = new StructureCandle();
            structureCandle.firstParam = analiseCandles.get(i).getUnicCandle();
            structureCandle.secondParam = analiseCandles.get(i).getUnicPrivCandle();
            int count = 0;
            for (int j=0; j<structureCandles.size();j++){
                if(structureCandle.firstParam==structureCandles.get(j).firstParam &&
                        structureCandle.secondParam==structureCandles.get(j).secondParam){
                    structureCandle.allCases=structureCandles.get(j).allCases+analiseCandles.get(i).getCountNextCandle();
                    structureCandle.upCases = structureCandles.get(j).upCases;
                    if(analiseCandles.get(i).getNextCandle()<200){
                        structureCandle.upCases = structureCandles.get(j).upCases+analiseCandles.get(i).getCountNextCandle();
                    }
                    structureCandles.set(j,structureCandle);
                }
                else{
                    count++;
                    if(count==structureCandles.size()){
                        structureCandle.allCases=analiseCandles.get(i).getCountNextCandle();
                        if(analiseCandles.get(i).getNextCandle()<200){
                            structureCandle.upCases = analiseCandles.get(i).getCountNextCandle();
                        }
                        structureCandles.add(structureCandle);
                        break;
                    }
                }
            }
        }

        for(int i=0; i<structureCandles.size();i++){
            StructureCandle structureCandle = new StructureCandle();
            structureCandle = structureCandles.get(i);
            double x = (double) structureCandles.get(i).upCases;
            double y = (double)structureCandles.get(i).allCases;
            structureCandle.addiction = x/ y;
            structureCandles.set(i,structureCandle);
        }

        return structureCandles;
    }
}
