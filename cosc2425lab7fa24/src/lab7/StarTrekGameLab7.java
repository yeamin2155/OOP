package lab7;

public class StarTrekGameLab7 {
    CrewMemberLab7 yeet = new CrewMemberLab7(1, 3, 3, 100, 100, "Captain Yeeterson", "Torpedo");
    CrewMemberLab7 smooth = new CrewMemberLab7(2, 4, 4, 150, 150, "Private Smooth Brain", "Phaser");

    Klingon dumbGuy = new Klingon(3, 5, 5, "Dumb Guy", 50, 100);

    public StarTrekGameLab7() {
        smooth.attack(dumbGuy);
    }

    public static void main(String[] args) {
        new StarTrekGameLab7();
    }
}

