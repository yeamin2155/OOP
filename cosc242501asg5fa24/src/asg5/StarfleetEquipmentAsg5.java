// Asg 5 – COSC 2425-01– Professor McCurry
 // Implemented by - Ashabul Yeamin
package asg5;

public class StarfleetEquipmentAsg5 {
   private String name;
   private String description;

   // Parameterized Constructor
   public StarfleetEquipmentAsg5(String name, String description) {
       this.name = name;
       this.description = description;
   }

   // Getters and Setters
   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }

   public String getDescription() {
       return description;
   }

   public void setDescription(String description) {
       this.description = description;
   }

   // Override toString
   @Override
   public String toString() {
       return name + " - " + description;
   }
}
