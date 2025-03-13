package inclass12;

public class GameDemoIC12 {

    public static void main(String[] args) {
        CharacterIC12[] characters = new CharacterIC12[2];
        characters[0] = new AstronautIC12("Commando Riker", 100, "Number 1");
        characters[1] = new AlienIC12("Xenomorph", 150, "Hostile");
        
        for (CharacterIC12 character : characters) {
            System.out.println(character.getName() + " (" + character.getHealth() + " health)");
            character.attack();
        }
    }
}

