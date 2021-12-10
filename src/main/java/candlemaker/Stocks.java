package candlemaker;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stocks {
    private Date date;
    private Integer time;
    private Double open;
    private Double high;
    private Double low;
    private Double close;
    private Double volume;
    private Double ema;
    private Double plusDM;
    private Double minusDM;
    private Double trueRange;
    private Double plusDI;
    private Double minusDI;
    private Double indicatorADX;

    public Stocks() {
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPlusDM() {
        return plusDM;
    }

    public void setPlusDM(Double plusDM) {
        this.plusDM = plusDM;
    }

    public Double getMinusDM() {
        return minusDM;
    }

    public void setMinusDM(Double minusDM) {
        this.minusDM = minusDM;
    }

    public Double getTrueRange() {
        return trueRange;
    }

    public void setTrueRange(Double trueRange) {
        this.trueRange = trueRange;
    }

    public Double getPlusDI() {
        return plusDI;
    }

    public void setPlusDI(Double plusDI) {
        this.plusDI = plusDI;
    }

    public Double getMinusDI() {
        return minusDI;
    }

    public void setMinusDI(Double minusDI) {
        this.minusDI = minusDI;
    }

    public Double getIndicatorADX() {
        return indicatorADX;
    }

    public void setIndicatorADX(Double indicatorADX) {
        this.indicatorADX = indicatorADX;
    }

    public Double getEma() {
        return ema;
    }

    public void setEma(Double ema) {
        this.ema = ema;
    }

    public Date getDate() {
        return date;
    }

    public Integer getTime() {
        return time;
    }

    public Double getOpen() {
        return open;
    }

    public Double getLow() {
        return low;
    }

    public Double getHigh() {
        return high;
    }

    public Double getClose() {
        return close;
    }

    public Double getVolume() {
        return volume;
    }

    public void createStocks(String s) throws ParseException {
       String[] mas = s.split(";");
       this.date = new SimpleDateFormat("yyyyMMdd").parse(mas[2]);
       this.time = Integer.parseInt(mas[3]);
       this.open = Double.parseDouble(mas[4]);
       this.high = Double.parseDouble(mas[5]);
       this.low = Double.parseDouble(mas[6]);
       this.close = Double.parseDouble(mas[7]);
       this.volume = Double.parseDouble(mas[8]);
       this.ema = 0.0;
       this.plusDM = 0.0;
       this.minusDM = 0.0;
       this.trueRange = 0.0;
       this.plusDI = 0.0;
       this.minusDI = 0.0;
       this.indicatorADX = 0.0;
    }
}
