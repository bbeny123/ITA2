package pl.beny;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = getInput();

        System.exit(0);
    }

    private static int getInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Wprowadz liczbe do faktoryzacji (>1): ");
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 1) {
                    return number;
                }
            } else {
                scanner.next();
                System.out.println("Zly input! Sprobuj ponownie!");
            }
        }
    }

    private static void printResult(int number, List<Integer> factors) {
        System.out.printf("%d = ", number);
        factors.stream().findFirst().ifPresent(System.out::print);
        factors.stream().skip(1).forEach(factor -> System.out.printf(" x %d", factor));
        System.out.println("");
    }

}
