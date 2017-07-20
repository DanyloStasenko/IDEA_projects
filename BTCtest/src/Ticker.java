
import java.io.IOException;
import java.net.URL;

public class Ticker {

    private double mid;
    private double bid;
    private double ask;
    private double lastPrice;
    private double low;
    private double high;
    private double volume;

    public Ticker() throws IOException{
        initializeFields();
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void initializeFields() {
        try{
            ObjectMapper mapper = new ObjectMapper();
            Ticker temp = mapper.readValue(new URL("https://api.bitfinex.com/v1/pubticker/btcusd"), Ticker.class);

            mid = temp.getMid();
            bid = temp.getBid();
            ask = temp.getAsk();
            lastPrice = temp.getLastPrice();
            low = temp.getLow();
            high = temp.getHigh();
            volume = temp.getVolume();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "TickerService{" +
                "mid=" + mid +
                ", bid=" + bid +
                ", ask=" + ask +
                ", lastPrice=" + lastPrice +
                ", low=" + low +
                ", high=" + high +
                ", volume=" + volume +
                '}';
    }

}