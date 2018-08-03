import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class KalkulatorWalut {

    private Scanner scanner;
    private String waluta;


    public void setWaluta(String waluta) {
        this.waluta = waluta;
    }

    public String getWaluta() {
        return waluta;
    }

    public String getInput(){
        scanner = new Scanner(System.in);
        System.out.println("Podaj jedną z walut - 1. USD, 2. EUR. 3. GBP, 4. CHF");
        String waluta = scanner.next();
        scanner.close();
        setWaluta(waluta);
        return waluta;
    }

    public double getAvgRate() throws IOException{
        String input = getInput();
        return sendRequest(input);
    }
    public double sendRequest(String input) throws IOException {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/c/" + input + "?format=json");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Chrome");
        Scanner scanner = new Scanner(connection.getInputStream());
        String stream = scanner.nextLine();
        Gson gson = new Gson();
        RootObject obj = gson.fromJson(stream, RootObject.class);
        ArrayList<Kurs> rates = obj.getRates();
        scanner.close();
        return rates.get(0).getAsk();
    }
    public void ileZa100PLN(String input) throws IOException {
        double result = (double) Math.round((100 / sendRequest(input)) * 100) / 100;
        System.out.println("Za 100 PLN otrzymasz: " + result + " " + input.toUpperCase());
    }
}






