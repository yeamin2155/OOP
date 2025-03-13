package ic21;

public class GalacticExploration {

    public static void main(String[] args) {
        // Create a new CargoHold object
        CargoHold cargoHold = new CargoHold();

        // Add initial items to the cargo hold
        cargoHold.addItem("Energy Cells");
        cargoHold.addItem("Medical Supplies");
        cargoHold.addItem("Artifacts");
        System.out.println("Initial cargo hold: " + cargoHold); 

        // Simulate an encounter where medical supplies are used
        String usedSupplies = cargoHold.getItem(1); // Get "Medical Supplies"
        System.out.println("Used: " + usedSupplies); 
        cargoHold.removeItem("Medical Supplies"); // Remove "Medical Supplies"
        System.out.println("Cargo hold after using supplies: " + cargoHold); 

        // Simulate finding new artifacts on a planet
        cargoHold.addItem("Rare Minerals");
        System.out.println("Cargo hold after finding minerals: " + cargoHold);

        // Check if the cargo hold is empty
        boolean isEmpty = cargoHold.isEmpty();
        System.out.println("Is the cargo hold empty? " + isEmpty);

        // Get the number of items in the cargo hold
        int cargoSize = cargoHold.getSize();
        System.out.println("Number of items in the cargo hold: " + cargoSize);

        // Check if the cargo hold contains energy cells
        boolean hasEnergyCells = cargoHold.contains("Energy Cells");
        System.out.println("Does the cargo hold contain energy cells? " + hasEnergyCells);

        // Simulate trading artifacts for fuel
        cargoHold.setItem(1, "Fuel Cells"); // Assuming "Artifacts" is at index 1
        System.out.println("Cargo hold after trading artifacts: " + cargoHold);

        // Print the cargo hold inventory
        cargoHold.printInventory();
    }
}
