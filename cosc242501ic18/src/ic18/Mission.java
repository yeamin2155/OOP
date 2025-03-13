package ic18;

public class Mission {
	
    private String name;
    private int completionTime; // in hours

    public Mission(String name, int completionTime) {
        this.name = name;
        this.completionTime = completionTime;
    }

    public String getName() {
        return name;
    }

    public int getCompletionTime() {
        return completionTime;
    }

    @Override
    public String toString() {
        return "Mission{name='" + name + "', completionTime=" + completionTime + " hours}";
    }

}
