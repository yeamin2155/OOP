package ic9;

public class StarshipBridgeIC9 {
	public static void main(String[] args) {  
		
		CrewMemberIC9 krik = new CrewMemberIC9("James T. Kirk", "Captain"); 
		CrewMemberIC9 spock = new CrewMemberIC9("Spock", "Science Officer");
		
		System.out.println(krik.getName() + ": " + krik.getRank());
		System.out.println("Total Crew Members: " + CrewMemberIC9.getTotalCrewMembers());		
	}
}
