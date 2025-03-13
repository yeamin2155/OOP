package AlgoTrader;

import java.util.List;

public class movingaveragestrategy {
    public static String determineAction(List<Double> prices, int shortWindow, int longWindow) {
        if (prices.size() < longWindow) return "HOLD";

        double shortAvg = prices.subList(prices.size() - shortWindow, prices.size()).stream().mapToDouble(a -> a).average().orElse(0);
        double longAvg = prices.subList(prices.size() - longWindow, prices.size()).stream().mapToDouble(a -> a).average().orElse(0);

        if (shortAvg > longAvg) return "BUY";
        else if (shortAvg < longAvg) return "SELL";
        return "HOLD";
    }
}
