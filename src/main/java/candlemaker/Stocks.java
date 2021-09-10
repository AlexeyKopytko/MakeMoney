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

    public Stocks() {
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
    }
}
