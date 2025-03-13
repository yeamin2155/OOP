package lab8;

public class SpaceshipNavigationLab8_w_Handling {

    private static final int GALAXY_MAX_X = 1000;
    private static final int GALAXY_MAX_Y = 1000;
    private static final int GALAXY_MAX_Z = 1000;
    private static final int MAX_LOCATIONS = 10; // Maximum number of locations in the array

    private boolean warpDriveOnline = false;
    private int fuelLevel = 100;
    private int[] currentLocation = new int[3]; // Array to store current location (x, y, z)
    private int[][] locationHistory = new int[MAX_LOCATIONS][3]; // 2D array to store location history
    private int locationCount = 0; // Number of locations stored in the history

    public void startGame() {
        // Initialize systems first
        initializeSystems();

        // Run tests to catch various exceptions
        testWarpDriveOffline();
        testInvalidCoordinates();
        testInsufficientFuel();

        // Additional Valid Destinations for Testing
        try {
            setDestination(100, 50, 20);
            setDestination(300, 200, 100);
        } catch (InvalidCoordinatesException | InsufficientFuelException e) {
            System.err.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("Game over. Thank you for playing!");
    }

    private void initializeSystems() {
        // Initialize warp drive, set initial location, etc.
        warpDriveOnline = true;
        currentLocation[0] = 0;
        currentLocation[1] = 0;
        currentLocation[2] = 0;
    }

    private void testWarpDriveOffline() {
        try {
            engageWarpDrive(); // This should trigger WarpDriveOfflineException
        } catch (WarpDriveOfflineException e) {
            System.err.println("Caught WarpDriveOfflineException: " + e.getMessage());
        }
    }

    private void testInvalidCoordinates() {
        try {
            // Uncomment the line below to test setting an invalid destination
            setDestination(-10, 50, 20); // This should trigger InvalidCoordinatesException
        } catch (InvalidCoordinatesException e) {
            System.err.println("Caught InvalidCoordinatesException: " + e.getMessage());
        } catch (InsufficientFuelException e) {
            System.err.println("Caught InsufficientFuelException during Invalid Coordinates Test: " + e.getMessage());
        }
    }

    private void testInsufficientFuel() {
        try {
            // Uncomment the line below to test setting a far-off destination requiring more fuel than available
            setDestination(10000, 10000, 10000); // This should trigger InsufficientFuelException
        } catch (InsufficientFuelException e) {
            System.err.println("Caught InsufficientFuelException: " + e.getMessage());
        } catch (InvalidCoordinatesException e) {
            System.err.println("Caught InvalidCoordinatesException during Insufficient Fuel Test: " + e.getMessage());
        }
    }

    public void engageWarpDrive() throws WarpDriveOfflineException {
        if (!warpDriveOnline) {
            throw new WarpDriveOfflineException("Warp drive is offline. Please initialize.");
        }
        System.out.println("Warp drive engaged!");
    }

    public void setDestination(int x, int y, int z) throws InvalidCoordinatesException, InsufficientFuelException {
        if (x < 0 || y < 0 || z < 0 || x > GALAXY_MAX_X || y > GALAXY_MAX_Y || z > GALAXY_MAX_Z) {
            throw new InvalidCoordinatesException("Invalid coordinates. Please enter values within the galaxy boundaries.");
        }

        System.out.println("Setting destination to: " + x + ", " + y + ", " + z);
        int fuelConsumed = calculateFuelConsumption(x, y, z);

        if (fuelConsumed > fuelLevel) {
            throw new InsufficientFuelException("Insufficient fuel to reach destination.");
        }

        fuelLevel -= fuelConsumed;
        currentLocation[0] = x;
        currentLocation[1] = y;
        currentLocation[2] = z;

        if (locationCount < MAX_LOCATIONS) {
            locationHistory[locationCount][0] = x;
            locationHistory[locationCount][1] = y;
            locationHistory[locationCount][2] = z;
            locationCount++;
        } else {
            System.out.println("Location history is full!");
        }

        System.out.println("Destination set. Fuel remaining: " + fuelLevel);
    }

    private int calculateFuelConsumption(int x, int y, int z) {
        double distance = Math.sqrt(Math.pow(x - currentLocation[0], 2) + Math.pow(y - currentLocation[1], 2)
                + Math.pow(z - currentLocation[2], 2));
        int fuelConsumed = (int) Math.ceil(distance / 10);
        System.out.println("Fuel consumed for this jump: " + fuelConsumed);
        return fuelConsumed;
    }

    public static void main(String[] args) {
    	SpaceshipNavigationLab8_w_Handling game = new SpaceshipNavigationLab8_w_Handling();
        game.startGame(); // No try-catch needed here
    }

    // Custom Exception Classes
    class WarpDriveOfflineException extends Exception {
        public WarpDriveOfflineException(String message) {
            super(message);
        }
    }

    class InvalidCoordinatesException extends Exception {
        public InvalidCoordinatesException(String message) {
            super(message);
        }
    }

    class InsufficientFuelException extends Exception {
        public InsufficientFuelException(String message) {
            super(message);
        }
    }
}