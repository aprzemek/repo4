import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {

            KalkulatorWalut userInput = new KalkulatorWalut();
            System.out.println(userInput.getAvgRate());
            userInput.ileZa100PLN(userInput.getWaluta());

    }


}