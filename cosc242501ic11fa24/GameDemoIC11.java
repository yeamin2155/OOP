package ic11;

public class GameDemoIC11 {
    public static void main(String[] args) {
        AstronautIC11 astronaut = new AstronautIC11("Captain Picard", 100, "Captain");
        AlienIC11 alien = new AlienIC11("Xenomorph", 150, "Hostile");

        System.out.println("Astronaut: " + astronaut.name + " (" + astronaut.health + " health)");
        astronaut.attack();

        System.out.println("Alien: " + alien.name + " (" + alien.health + " health)");
        alien.attack();
    }

}
