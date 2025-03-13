package lab9;

//Lab 9 – COSC 2425-<Appropriate Section> – Professor McCurry
//Implemented by - Yeamin & Evan

public class Spaceship { private String id; // Unique identifier for each spaceship
private int speed;
private int firepower;
private int hullIntegrity;

public Spaceship(String id, int speed, int firepower, int hullIntegrity) {
	this.id = id;
	this.speed = speed;
	this.firepower = firepower;
	this.hullIntegrity = hullIntegrity;
}

public String getId() {
	return id;
}

public int getSpeed() {
	return speed;
}

public int getFirepower() {
	return firepower;
}

public int getHullIntegrity() {
	return hullIntegrity;
}

@Override
public String toString() {
	return "Spaceship[ID: " + id + ", Speed: " + speed + ", Firepower: " + firepower + ", Hull Integrity: "
			+ hullIntegrity + "]";
}
}



