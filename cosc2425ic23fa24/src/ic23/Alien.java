package ic23;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Alien {

    private Set<String> locations;

    public Alien() {
        locations = new HashSet<>();
        locations.add("Medbay");
    }

    public void move(List<String> possibleLocations) {
        Random random = new Random();
        String newLocation = possibleLocations.get(random.nextInt(possibleLocations.size()));
        locations.clear();
        locations.add(newLocation);
    }

    public boolean isAtLocation(String location) {
        return locations.contains(location);
    }

    public Set<String> getLocations() {
        return locations;
    }
}
