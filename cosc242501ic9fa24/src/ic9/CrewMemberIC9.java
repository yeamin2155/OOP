// In-Class 9 – COSC 2425-<your section number> – Professor McCurry
// Implemented by: Ashabul Yeamin

package ic9;

public class CrewMemberIC9 {
	
	private static int totalCrewMembers = 0;
	
	private String name;
	private String rank;
	
	public CrewMemberIC9(String name, String rank) {
		this.name = name;  
		this.rank = rank;  
		totalCrewMembers++;
	}
	
	public String getName() {  
		return name;
	}
	
	public String getRank() {
		return rank;
	}
	
	public static int getTotalCrewMembers() {
		return totalCrewMembers;
	}
}
