package asg4;

import java.util.Random;

public class SolarSystem {
    public enum SectorType {
        EMPTY,RESOURCE,ALIEN
    }

    private SectorType[] solarSystemMap; 
    private int sectors; 

    // Constructor to initialize the solar system map
    public SolarSystem(int sectors) {
        this.sectors = sectors;
        solarSystemMap = new SectorType[sectors];
        initializeMap(); 
    }

    // Initialize the solar system with random sector types
    private void initializeMap() {
        Random random = new Random();
        for (int i = 0; i < sectors; i++) {
            int sectorType = random.nextInt(3); // 0, 1, or 2
            switch (sectorType) {
                case 0:
                    solarSystemMap[i] = SectorType.EMPTY;
                    break;
                case 1:
                    solarSystemMap[i] = SectorType.RESOURCE;
                    break;
                case 2:
                    solarSystemMap[i] = SectorType.ALIEN;
                    break;
            }
        }
    }

    // Getter for SectorType at a specific sector position
    public SectorType getSectorType(int position) {
        if (position >= 0 && position < sectors) {
            return solarSystemMap[position];
        } else {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        }
    }

    public int getSectors() {
        return sectors;
    }
}
