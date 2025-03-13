// Asg 5 – COSC 2425-01– Professor McCurry
 // Implemented by - Ashabul Yeamin
package asg5;

import java.util.ArrayList;

public class AwayTeamMemberAsg5 {
   private String name;
   private int health;
   private String rank;
   private StarfleetRoles role;
   private ArrayList<StarfleetEquipmentAsg5> inventory;
   private static int totalMembers = 0;

   // Parameterized Constructor
   public AwayTeamMemberAsg5(String name, int health, String rank, StarfleetRoles role) {
       this.name = name;
       this.health = health;
       this.rank = rank;
       this.role = role;
       this.inventory = new ArrayList<>();
       totalMembers++;
   }

   // Getters and Setters
   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public int getHealth() {
       return health;
   }

   public void setHealth(int health) {
       this.health = health;
   }

   public String getRank() {
       return rank;
   }

   public void setRank(String rank) {
       this.rank = rank;
   }

   public StarfleetRoles getRole() {
       return role;
   }

   public void setRole(StarfleetRoles role) {
       this.role = role;
   }

   // Static method to get total members
   public static int getTotalMembers() {
       return totalMembers;
   }

   // Method to add an item to the inventory
   public void addItem(StarfleetEquipmentAsg5 item) {
       inventory.add(item);
   }

   // Method to print the inventory
   public void printInventory() {
       System.out.println("Inventory for " + name + ":");
       for (StarfleetEquipmentAsg5 item : inventory) {
           System.out.println(item);
       }
   }
  
   public ArrayList<StarfleetEquipmentAsg5> getInventory() {
       return inventory;
   }

   // Method for increase health
   public void increaseHealth(int amount) {
       health += amount;
   }

   // Method for decrease health
   public void decreaseHealth(int amount) {
       health -= amount;
   }

   // Override toString
   @Override
   public String toString() {
       return name + " (" + rank + ") - " + role + " - Health: " + health;
   }

   // Override equals method
   @Override
   public boolean equals(Object obj) {
       if (this == obj) return true;
       if (obj == null || getClass() != obj.getClass()) return false;
       AwayTeamMemberAsg5 that = (AwayTeamMemberAsg5) obj;
       return this.name.equals(that.name);
   }
}
