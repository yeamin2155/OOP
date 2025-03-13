// Asg 5 – COSC 2425-01– Professor McCurry
 // Implemented by - Ashabul Yeamin
package asg5;

public class StarTrekGameAsg5 {
    public static void main(String[] args) {
        // Create away team members
        AwayTeamMemberAsg5 kirk = new AwayTeamMemberAsg5("Kirk", 100, "Captain", StarfleetRoles.CAPTAIN);
        AwayTeamMemberAsg5 spock = new AwayTeamMemberAsg5("Spock", 90, "Commander", StarfleetRoles.SCIENCE_OFFICER);
        AwayTeamMemberAsg5 mccoy = new AwayTeamMemberAsg5("McCoy", 80, "Lieutenant", StarfleetRoles.MEDICAL_OFFICER);

        // Create equipment
        StarfleetEquipmentAsg5 phaser = new StarfleetEquipmentAsg5("Phaser", "Energy weapon");
        StarfleetEquipmentAsg5 tricorder = new StarfleetEquipmentAsg5("Tricorder", "Scans for data");
        StarfleetEquipmentAsg5 medicalKit = new StarfleetEquipmentAsg5("Medical Kit", "First aid and medical tools");

        // Create mission
        AwayMissionAsg5 mission = new AwayMissionAsg5();
        mission.addTeamMember(kirk);
        mission.addTeamMember(spock);
        mission.addTeamMember(mccoy);

        mission.addEquipment(phaser);
        mission.addEquipment(tricorder);
        mission.addEquipment(medicalKit);

        // Assign equipment
        mission.assignEquipment(kirk, phaser);
        mission.assignEquipment(spock, tricorder);
        mission.assignEquipment(mccoy, medicalKit);

        // Test collaboration
        mission.exchangeEquipment(kirk, spock, phaser);

        // Print team info
        System.out.println(kirk);
        System.out.println(spock);
        System.out.println(mccoy);

        // Test toString methods for equipment
        System.out.println(phaser);
        System.out.println(tricorder);
        System.out.println(medicalKit);

            }
}
