import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.net.URL;

public class CurrencyConverter {

    public static void main(String[] args) throws IOException {

        HashMap<Integer, String> currencyCodes = new HashMap<>();

        // Add currency codes
        currencyCodes.put(1, "USD");
        currencyCodes.put(2, "BRL"); // Brazilian Real
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "HKD"); // Hong Kong Dollar
        currencyCodes.put(5, "INR"); // Indian Rupee

        Integer from, to;
        String fromCode, toCode;
        double amount;

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter!");

        System.out.println("Currency Converting FROM?");
        System.out.println("1:USD (US Dollar)\t 2:BRL (Brazilian Real)\t 3:EUR (Euro)\t 4:HKD (Hong Kong Dollar)\t 5:INR (Indian Rupee)");
        from = sc.nextInt();
        while (from < 1 || from > 5) {
            System.out.println("Please select a valid currency (1-5)");
            System.out.println("1:USD (US Dollar)\t 2:BRL (Brazilian Real)\t 3:EUR (Euro)\t 4:HKD (Hong Kong Dollar)\t 5:INR (Indian Rupee)");
            from = sc.nextInt();
        }
        fromCode = currencyCodes.get(from);

        System.out.println("Currency Converting TO?");
        System.out.println("1:USD (US Dollar)\t 2:BRL (Brazilian Real)\t 3:EUR (Euro)\t 4:HKD (Hong Kong Dollar)\t 5:INR (Indian Rupee)");
        to = sc.nextInt();
        while (to < 1 || to > 5) {
            System.out.println("Please select a valid currency (1-5)");
            System.out.println("1:USD (US Dollar)\t 2:BRL (Brazilian Real)\t 3:EUR (Euro)\t 4:HKD (Hong Kong Dollar)\t 5:INR (Indian Rupee)");
            to = sc.nextInt();
        }
        toCode = currencyCodes.get(to);

        System.out.println("Amount you wish to convert?");
        amount = sc.nextFloat();

        // Corrigir a chamada do método sendHttpGETRequest
        sendHttpGETRequest(fromCode, toCode, amount);

        System.out.println("Thank you for using the currency converter!");
    }

    // Corrigir a assinatura do método sendHttpGETRequest
    private static void sendHttpGETRequest(String fromCode, String toCode, double amount) throws IOException {

        DecimalFormat f = new DecimalFormat("0.00");
        String GET_URL = "https://api.exchangerate-api.com/v4/latest/" + fromCode;
        URL url = new URL(GET_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Imprima a resposta completa para depuração
            System.out.println("API Response: " + response.toString());

            JSONObject obj = new JSONObject(response.toString());
            Double exchangeRate = obj.getJSONObject("rates").getDouble(toCode);
            System.out.println(obj.getJSONObject("rates"));
            System.out.println(exchangeRate); // keep for debugging
            System.out.println();
            System.out.println(f.format(amount) + " " + fromCode + " = " + f.format(amount * exchangeRate) + " " + toCode);

        } else {
            System.out.println("GET request failed with response code: " + responseCode);
            BufferedReader errorStream = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
            StringBuilder errorResponse = new StringBuilder();
            String errorLine;
            while ((errorLine = errorStream.readLine()) != null) {
                errorResponse.append(errorLine);
            }
            errorStream.close();
            System.out.println("Error response: " + errorResponse.toString());
        }
    }
}
