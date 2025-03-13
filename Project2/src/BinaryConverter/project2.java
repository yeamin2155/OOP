package BinaryConverter;

import java.util.Scanner;

public class project2 {

    public static int signedMagnitude(String binary) {
        int sign = binary.substring(0, 1).equals("1") ? -1 : 1; 
        int magnitude = Integer.parseInt(binary.substring(1), 2);
        return sign * magnitude;
    }

    public static int onesComplement(String binary) {
        int sign = binary.substring(0, 1).equals("1") ? -1 : 1;
        if (sign == -1) {
            String flipped = "";
            for (int i = 1; i < binary.length(); i++) {
                flipped += (binary.substring(i, i + 1).equals("0")) ? "1" : "0";
            }
            return -Integer.parseInt(flipped, 2);
        }
        return Integer.parseInt(binary.substring(1), 2);
    }

    public static int twosComplement(String binary) {
        int sign = binary.substring(0, 1).equals("1") ? -1 : 1;
        if (sign == -1) {
            String flipped = "";
            for (int i = 1; i < binary.length(); i++) {
                flipped += (binary.substring(i, i + 1).equals("0")) ? "1" : "0";
            }
            return -(Integer.parseInt(flipped, 2) + 1);
        }
        return Integer.parseInt(binary.substring(1), 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an 8-bit binary number: ");
        String binary = scanner.nextLine();

        if (binary.length() != 8 || !binary.matches("[01]+")) {
            System.out.println("Invalid input! Please enter exactly 8 binary digits.");
            return;
        }

        System.out.println("Signed Magnitude: " + signedMagnitude(binary));
        System.out.println("One's Complement: " + onesComplement(binary));
        System.out.println("Two's Complement: " + twosComplement(binary));

        scanner.close();
    }
}
