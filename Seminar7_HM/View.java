package Seminar7_HM;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void menu() {
        System.out.println("===== Complex Calculator Menu =====");
        System.out.println("1. Sum");
        System.out.println("2. Multiply");
        System.out.println("3. Divide");
        System.out.println("0. Exit");
        System.out.println("===================================");
    }

    public int getUserChoice() {
        System.out.print("Input your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // очистка буфера
        return choice;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public double getRealPart() {
        System.out.print("Input real part of number: ");
        return scanner.nextDouble();
    }

    public double getImaginaryPart() {
        System.out.print("Input  imaginary part of number: ");
        return scanner.nextDouble();
    }

    public void closeScan() {
        scanner.close();
    }

}
