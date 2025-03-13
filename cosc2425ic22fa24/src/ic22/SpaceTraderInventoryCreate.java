package ic22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SpaceTraderInventoryCreate {

    public static void main(String[] args) {

        // Number of trade goods to create
        int numItems = 100000; // Start with 10,000, test with 100,000 and 1,000,000 later

        // Create a list to store trade goods (using ArrayList)
        List<TradeGood> arrayListInventory = new ArrayList<>();

        // Record start time for ArrayList
        long startTime = System.currentTimeMillis();

        // Create a large number of trade goods and add to ArrayList
        for (int i = 0; i < numItems; i++) {
            arrayListInventory.add(generateTradeGood());
        }

        // Record end time for ArrayList
        long endTime = System.currentTimeMillis();

        // Calculate and print the time taken for ArrayList
        long arrayListTime = endTime - startTime;
        System.out.println("Time taken for ArrayList: " + arrayListTime + " milliseconds");

        // Create a list to store trade goods (using LinkedList)
        List<TradeGood> linkedListInventory = new LinkedList<>();

        // Record start time for LinkedList
        startTime = System.currentTimeMillis();

        // Create a large number of trade goods and add to LinkedList
        for (int i = 0; i < numItems; i++) {
            linkedListInventory.add(generateTradeGood());
        }

        // Record end time for LinkedList
        endTime = System.currentTimeMillis();

        // Calculate and print the time taken for LinkedList
        long linkedListTime = endTime - startTime;
        System.out.println("Time taken for LinkedList: " + linkedListTime + " milliseconds");
    }

    // Method to generate a random TradeGood object
    private static TradeGood generateTradeGood() {
        Random random = new Random();
        String name = "Good-" + random.nextInt(1000);
        double price = random.nextDouble() * 1000;
        int quantity = random.nextInt(100);
        return new TradeGood(name, price, quantity);
    }
}
