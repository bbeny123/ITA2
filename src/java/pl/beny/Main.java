package pl.beny;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("INPUT NUMBERS TO CALCULATE: ");
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        System.out.println("SUMMATION " + numbers + " = " + Calculator.add(numbers));
        System.exit(0);
    }

}
