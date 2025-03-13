package asg6;

//Asg 6 – COSC 2425-01 – Professor McCurry
//Implemented by - Ashabul Yeamin


import java.util.ArrayList;

public class SpaceCombatSimulator {
    public static void main(String[] args) {
        ArrayList<Spaceship> fleet = new ArrayList<>();
        
        // Instantiate Fighter and Cruiser objects
        Fighter fighter1 = new Fighter("Falcon", 100, 50, 20, 3);
        Cruiser cruiser1 = new Cruiser("Defender", 120, 60, 30);
        
        fleet.add(fighter1);
        fleet.add(cruiser1);

        // Display initial status
        for (Spaceship spaceship : fleet) {
            System.out.println(spaceship);
        }

        // Simulate combat
        fighter1.launchMissile(cruiser1); 
        cruiser1.fireBeamWeapon(fighter1); 

        // Display status after actions
        for (Spaceship spaceship : fleet) {
            System.out.println(spaceship);
        }
    }
}
