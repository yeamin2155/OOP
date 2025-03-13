package ic21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CargoHold {

    private List<String> items;

    public CargoHold() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public String getItem(int index) {
        return items.get(index);
    }

    public void setItem(int index, String item) {
        items.set(index, item);
    }

    public int getSize() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean contains(String item) {
        return items.contains(item);
    }

    public void printInventory() {
        Iterator<String> iterator = items.iterator();
        System.out.print("Cargo hold contains: ");
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cargo hold contains: ");
        for (String item : items) {
            sb.append(item).append(", ");
        }
        if (!items.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
