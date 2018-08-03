import java.util.ArrayList;

public class    RootObject {
    private String table;
    private String currency;
    private String code;
    private ArrayList<Kurs> rates;


public ArrayList<Kurs> getRates() {
        return this.rates;
   }

    @Override
    public String toString() {
        return "RootObject{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
