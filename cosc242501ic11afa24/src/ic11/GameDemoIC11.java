package ic11;

public class GameDemoIC11a {
    public static void main(String[] args) {
        AstronautIC11a astronaut = new AstronautIC11a("Captain Picard", 100, "Captain");
        AlienIC11a alien = new AlienIC11a("Xenomorph", 150, "Hostile");

        System.out.println("Astronaut: " + astronaut.name + " (" + astronaut.health + " health)");
        astronaut.attack();

        System.out.println("Alien: " + alien.name + " (" + alien.health + " health)");
        alien.attack();
    }

}
