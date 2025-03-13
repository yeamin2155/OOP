package asg2Test;

import asg2.Astronaut;
import asg2.Alien;
import java.util.Random;
import java.util.Scanner;

public class SpaceAdventure {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random dice = new Random();

        // Create an astronaut
        Astronaut astronaut = new Astronaut("Buzz", 100, 10);
        System.out.println("The adventure begins!\n");

        boolean continueMission = true;

        while (continueMission && astronaut.isStillBreathing()) {
        	
            // Randomly assign a new alien with a random level
            Alien alien = new Alien("Zorgon", 80, 8);
            
            System.out.println("You encounter an alien!\n");
            
            alien.displayStatus();  
            
            //Ask astronaut if Astronaut want to engage or retreat
            System.out.println("Do you want to engage or retreat? (Enter 'engage' or 'retreat'):");
            String action = scanner.nextLine();
            
          //Display astronaut's current status
            if (action.equalsIgnoreCase("retreat")) {
            	
                astronaut.displayStatus();
                
                System.out.println( "Mission ended! The astronaut has retreated.\n" );
                break;
            }

         // Astronaut's turn to attack
            while (alien.isOperational() && astronaut.isStillBreathing()) {
            	
                int astronautRoll = dice.nextInt(6) + 1;
                int astronautAttack = astronautRoll * astronaut.getLaserPower();
                
                alien.absorbDamage(astronautAttack);
                System.out.println( "Astronaut rolls: " + astronautRoll);
                System.out.println( "Astronaut attack damage: " + astronautAttack);
                alien.displayStatus();

                if (!alien.isOperational()) {
                    System.out.println( "The alien has been defeated!\n" );

                    // Astronaut gains experience and space credits
                    int earnedCredits = alien.dropSpaceCredits();
                    int earnedExperience = alien.grantExperience();
                    astronaut.accumulateCredits(earnedCredits);
                    astronaut.accumulateExperience(earnedExperience);

                    System.out.println( "Astronaut earned " + earnedCredits + " space credits and " +
                            earnedExperience + " experience points.\n" );
                    break;
                }

                // Alien's turn to attack
                
                int alienRoll = dice.nextInt(6) + 1;
                int alienAttack = alienRoll * alien.getLaserPower();
                astronaut.adjustHealth(-alienAttack);
                
                System.out.println( "Alien rolls: " + alienRoll );
                System.out.println( "Alien attack damage: " + alienAttack );
                astronaut.displayStatus();

                if (!astronaut.isStillBreathing()) {
                    System.out.println( "The astronaut has been defeated!\n" );
                    break;
                }
            }

            // After battle, ask if the astronaut wants to continue or end
            if (astronaut.isStillBreathing()) {
                System.out.println( "Do you want to continue the mission or end it? (Enter 'continue' or 'end'):" );
                String continueChoice = scanner.nextLine();
                if (continueChoice.equalsIgnoreCase( "end" )) {
                    System.out.println( "Mission ended! The astronaut returns safely." );
                    continueMission = false;
                }
            }
        }

        if (!astronaut.isStillBreathing()) {
            System.out.println("Mission failed. The astronaut is no longer breathing.");
        }

        System.out.println("The adventure ends!");
        scanner.close();
    }
}
