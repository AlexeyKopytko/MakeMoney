package analise;

import java.util.ArrayList;

public class AllDiapasons implements Comparable<AllDiapasons> {
    private Double highDiapasons;
    private Double lowDiapasons;
    private Double amount;

    public AllDiapasons(Double highDiapasons, Double lowDiapasons) {
        this.highDiapasons = highDiapasons;
        this.lowDiapasons = lowDiapasons;
        this.amount=0.0;
    }

    public Double getHighDiapasons() {
        return highDiapasons;
    }

    public void setHighDiapasons(Double highDiapasons) {
        this.highDiapasons = highDiapasons;
    }

    public Double getLowDiapasons() {
        return lowDiapasons;
    }

    public void setLowDiapasons(Double lowDiapasons) {
        this.lowDiapasons = lowDiapasons;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public static ArrayList<AllDiapasons> diapasons(){
        ArrayList<AllDiapasons> result = new ArrayList<>();
        for (Double i=-5.0; i<=5.0; i = i+0.01){
            for (Double k=-5.0; k<=5.0; k = k+0.01){

                AllDiapasons allDiapasons = new AllDiapasons(i,k);
                result.add(allDiapasons);
            }
        }
        return result;
    }

    @Override
    public int compareTo(AllDiapasons o) {
        return o.getAmount().compareTo(this.getAmount());
    }
}
