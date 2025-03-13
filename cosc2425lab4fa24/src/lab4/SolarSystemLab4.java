package lab4;

import java.util.Random;

public class SolarSystemLab4 {
	private LocationType [][] solarSystemMap;
	public enum LocationType {
		EMPTY, RESOURCE, ALIEN
		
	}
	
	
   private int rows, columns ;
   
    public SolarSystemLab4(int rows, int columns) {
    	this.rows = rows;
    	this.columns = columns;
    
    	solarSystemMap = new LocationType [rows][columns];
    	
    	initializeSolarSystem();
    }
    
    private void initializeSolarSystem() {
    	
    	Random random = new Random();
    			
    	for (int i=0; i<rows;i++) {
    	for (int j=0; j<columns;j++){
    		int randomVal = random.nextInt(3);
    		solarSystemMap [i][j]= LocationType.values()[randomVal];
    	}
    	}
    	}
  
    public LocationType getLocationType(int row, int column) {
    	if (row >=0  && row < rows && columns >=0 && column<columns) {
    		return solarSystemMap [row][column];
    	} else {
    		return LocationType.EMPTY;
    	}
    } 
}
    
    
    
    
    
    
    
	