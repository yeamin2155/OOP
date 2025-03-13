package AlgoTrader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class marketdatafetcher {
    private static final String API_KEY = "YOUR_ALPHA_VANTAGE_KEY";
    private static final String BASE_URL = "https://www.alphavantage.co/query?";

    public static double getStockPrice(String symbol) {
        try {
            String urlString = BASE_URL + "function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=5min&apikey=" + API_KEY;
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONObject json = new JSONObject(response.toString());
            JSONObject timeSeries = json.getJSONObject("Time Series (5min)");
            String latestTime = timeSeries.keys().next();
            return timeSeries.getJSONObject(latestTime).getDouble("4. close");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
