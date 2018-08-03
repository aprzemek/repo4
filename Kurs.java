public class Kurs {

    private String no;
    private String effectiveDate;
    private double bid;
    private double ask;


    public double getAsk() {
        return this.ask;
   }


    @Override
    public String toString() {
        return "Rate{" +
                "no='" + no + '\'' +
                ", effectiveDate='" + effectiveDate + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                '}';
    }
}

