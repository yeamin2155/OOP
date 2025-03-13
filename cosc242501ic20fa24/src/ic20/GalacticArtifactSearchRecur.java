package ic20;

import java.util.Scanner;

public class GalacticArtifactSearchRecur {

    public static void main(String[] args) {
        // Array of alien artifact names (alphabetically sorted)
        String[] artifacts = { "Aebix", "Affor", "Agrip", "Ahwon", "Aklar", "Alora", "Aptor", "Arbon", "Arxol", "Ascor",
                "Bactos", "Balor", "Belax", "Bervox", "Bifor", "Bilal", "Bolar", "Borex", "Borix", "Boton", "Calax",
                "Calor", "Cantor", "Caron", "Cebox", "Celar", "Ceptor", "Ceron", "Cilax", "Cilor", "Dalax", "Dalon",
                "Darox", "Daxor", "Delax", "Delon", "Derox", "Dexon", "Dilax", "Dilor", "Ebor", "Efor", "Egrin", "Ekal",
                "Ekor", "Elan", "Elara", "Eldon", "Elex", "Elon", "Falax", "Falon", "Farox", "Faxor", "Felax", "Felon",
                "Ferox", "Fexon", "Filax", "Filor", "Galor", "Gavor", "Gelan", "Geler", "Gella", "Gelo", "Gelor",
                "Geltor", "Gena", "Genor", "Habor", "Hador", "Halar", "Halon", "Haxor", "Helar", "Helon", "Herox",
                "Hexor", "Hilax", "Ibor", "Ifor", "Igrin", "Ikal", "Ikor", "Ilan", "Ilara", "Ildon", "Ilex", "Ilon",
                "Jalax", "Jalon", "Jarox", "Jaxor", "Jelax", "Jelon", "Jerox", "Jexon", "Jilax", "Jilor" };

        ArtifactSearcherRecur searcher = new ArtifactSearcherRecur(artifacts);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter the name of the artifact you want to search for (or 'q' to quit):");
            String targetArtifact = scanner.nextLine();

            if (targetArtifact.equalsIgnoreCase("q")) {
                break;
            }

            int result = searcher.binarySearch(targetArtifact);
            if (result != -1) {
                System.out.println("Artifact '" + targetArtifact + "' found at index " + result);
            } else {
                System.out.println("Artifact '" + targetArtifact + "' not found in the inventory.");
            }
        }

        scanner.close();
    }
}
