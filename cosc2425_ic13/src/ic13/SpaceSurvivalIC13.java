package ic13;

public class SpaceSurvivalIC13 { 
    public static void main(String[] args) {
        SurvivorIC13 survivor = new SurvivorIC13("Ripley", 100, 5);
        ParasiticAlienIC13 alien = new ParasiticAlienIC13("Xenomorph", 80, 3);

        System.out.println("---- Character Information ----");
        System.out.println(survivor); 
        System.out.println();
        System.out.println(alien); // Using toString()
        System.out.println();

        System.out.println("---- Combat Start ----");
        survivor.attack(alien);
        System.out.println();
        alien.attack(survivor);
        System.out.println();

        System.out.println(survivor); // Using toString()
        System.out.println();
        System.out.println(alien); // Using toString()
    }
}
