import java.util.ArrayList;
import java.util.Date;

public class ElementaryInfomation {
    private Date date;
    private Integer time;
    private Double openCH;
    private Double closeCH;
    private Double volumeCH;
    private Double candleBody;
    private Double candleFull;
    private Double candlePlus;
    private Double candleMinus;



    private Double rounding(Double d){
        double k = d;
        int s1 = (int) k;
        double s2  = (d-s1)*100;
        int s3 = (int) Math.round(s2);
        return (double) s3/100+(double) s1;
    }

    public Date getDate() {
        return date;
    }

    public Integer getTime() {
        return time;
    }

    public Double getOpenCH() {
        return openCH;
    }

    public Double getCloseCH() {
        return closeCH;
    }

    public Double getVolumeCH() {
        return volumeCH;
    }

    public Double getCandleBody() {
        return candleBody;
    }

    public Double getCandleFull() {
        return candleFull;
    }

    public Double getCandlePlus() {
        return candlePlus;
    }

    public Double getCandleMinus() {
        return candleMinus;
    }

    public ArrayList<ElementaryInfomation> counting (ArrayList<Stocks> stocks){
        ArrayList<ElementaryInfomation> eInfomations = new ArrayList<>();
        for(int i=1; i<stocks.size();i++){
            ElementaryInfomation e = new ElementaryInfomation();
            e.date = stocks.get(i).getDate();
            e.time = stocks.get(i).getTime();
            e.openCH = rounding(((stocks.get(i-1).getClose()-stocks.get(i).getOpen())/stocks.get(i-1).getClose()));
            e.closeCH = rounding(((stocks.get(i).getClose()-stocks.get(i-1).getClose())/stocks.get(i-1).getClose()));
            e.volumeCH = rounding(((stocks.get(i).getVolume()-stocks.get(i-1).getVolume())/stocks.get(i-1).getVolume()));
            e.candleBody = rounding(((stocks.get(i).getClose()-stocks.get(i).getOpen())/stocks.get(i).getClose()));
            e.candleFull = rounding(((stocks.get(i).getHigh()-stocks.get(i).getLow())/stocks.get(i).getClose()));
            if(rounding(((stocks.get(i).getClose()-stocks.get(i).getOpen())/stocks.get(i).getClose()))<=0){
                e.candlePlus = rounding(((stocks.get(i).getClose()-stocks.get(i).getLow())/stocks.get(i).getClose()));
            }
            else{
                e.candleMinus = rounding(((stocks.get(i).getHigh()-stocks.get(i).getOpen())/stocks.get(i).getClose()));
            }
            if(rounding(((stocks.get(i).getClose()-stocks.get(i).getOpen())/stocks.get(i).getClose()))>0){
                e.candlePlus = rounding(((stocks.get(i).getHigh()-stocks.get(i).getClose())/stocks.get(i).getClose()));
            }
            else{
                e.candleMinus = rounding(((stocks.get(i).getOpen()-stocks.get(i).getLow())/stocks.get(i).getClose()));
            }
            eInfomations.add(e);
        }
        return eInfomations;
    }
}
