package analise;

import java.util.ArrayList;

public class AllDiapasons implements Comparable<AllDiapasons> {
    private Double highDiapasons;
    private Double lowDiapasons;
    private Double sizeDiaposons;
    private Double amount;

    public AllDiapasons(Double highDiapasons, Double lowDiapasons) {
        if(highDiapasons>=0) {
            this.highDiapasons = highDiapasons - 0.0001;
        }
        else {
            this.highDiapasons = highDiapasons - 0.0001;
        }
        if(lowDiapasons<=0) {
            this.lowDiapasons = lowDiapasons + 0.0001;
        }
        else{
            this.lowDiapasons = lowDiapasons + 0.0001;
        }
        this.sizeDiaposons = this.highDiapasons-this.lowDiapasons;
        this.amount=0.0;
    }

    public Double getSizeDiaposons() {
        return sizeDiaposons;
    }

    public void setSizeDiaposons(Double sizeDiaposons) {
        this.sizeDiaposons = sizeDiaposons;
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
        Double un1 = this.amount;
        Double un2 = o.amount;
        Double fC = un1-un2;
        if (fC!=0){
            return un2.compareTo(un1);
        }
        return o.sizeDiaposons.compareTo(this.sizeDiaposons);
    }
}
