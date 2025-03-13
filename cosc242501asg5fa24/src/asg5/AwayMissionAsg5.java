// Asg 5 – COSC 2425-01– Professor McCurry
 // Implemented by - Ashabul Yeamin
package asg5;
import java.util.ArrayList;
public class AwayMissionAsg5 {
   private ArrayList<AwayTeamMemberAsg5> team;
   private ArrayList<StarfleetEquipmentAsg5> equipmentList;
   // Constructor
   public AwayMissionAsg5() {
       team = new ArrayList<>();
       equipmentList = new ArrayList<>();
   }
   // Method to add a team member
   public void addTeamMember(AwayTeamMemberAsg5 member) {
       team.add(member);
   }
   // Method to add equipment
   public void addEquipment(StarfleetEquipmentAsg5 equipment) {
       equipmentList.add(equipment);
   }
   // Demonstrate aggregation: assign equipment to a team member
   public void assignEquipment(AwayTeamMemberAsg5 member, StarfleetEquipmentAsg5 equipment) {
       member.addItem(equipment);
   }
   // Team member collaboration: exchange equipment
   public void exchangeEquipment(AwayTeamMemberAsg5 giver, AwayTeamMemberAsg5 receiver, StarfleetEquipmentAsg5 equipment) {
       if (giver.getInventory().contains(equipment)) {
           giver.getInventory().remove(equipment);
           receiver.addItem(equipment);
           System.out.println(giver.getName() + " gave " + equipment.getName() + " to " + receiver.getName());
       }
   }
}
