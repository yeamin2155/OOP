package asg6;

//Asg 6 – COSC 2425-01 – Professor McCurry
//Implemented by - Ashabul Yeamin

public class Cruiser extends Spaceship {
    private int beamWeaponRange;

    public Cruiser(String name, int hullStrength, int shieldStrength, int beamWeaponRange) {
        super(name, hullStrength, shieldStrength);
        this.beamWeaponRange = beamWeaponRange;
    }

    @Override
    public void fireWeapon(Spaceship target) {
        System.out.println(name + " fires primary weapon at " + target.name);
        target.takeDamage(10); // default damage for primary weapon
    }

    public void fireBeamWeapon(Spaceship target) {
        System.out.println(name + " fires beam weapon at " + target.name);
        target.takeDamage(beamWeaponRange);
    }

    @Override
    public String toString() {
        return "Cruiser: " + name + " | Hull Strength: " + hullStrength + " | Shield Strength: " + shieldStrength + " | Beam Weapon Range: " + beamWeaponRange;
    }
}

