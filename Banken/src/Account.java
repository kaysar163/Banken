import java.io.Serializable;
import java.util.Scanner;

class Account implements Serializable {
    private double balance;

    public Account(int accountNumber) {
        this.balance = 0.0;
    }

    public void showMenuB() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("1. Ta ut pengar");
                System.out.println("2. Sätt in pengar");
                System.out.println("3. Visa saldo");
                System.out.println("4. Logga ut");
                System.out.println("5. Ange krypteringsalternativ"); // New option for encryption
                int choice = scanner.nextInt();

                if (choice == 1) {
                    System.out.println("Ange belopp att ta ut:");
                    double amount = scanner.nextDouble();
                    if (amount > balance) {
                        System.out.println("Otillräckligt saldo.");
                    } else {
                        balance -= amount;
                        System.out.println("Uttag lyckades. Nya saldo: " + balance);
                    }
                } else if (choice == 2) {
                    System.out.println("Ange belopp att sätta in:");
                    double amount = scanner.nextDouble();
                    balance += amount;
                    System.out.println("Insättning lyckades. Nya saldo: " + balance);
                } else if (choice == 3) {
                    System.out.println("Aktuellt saldo: " + balance);
                } else if (choice == 4) {
                    break;
                } else if (choice == 5) {
                    System.out.println("Ange krypteringsmetod (1 för AES, 2 för RSA):");
                    int encryptionChoice = scanner.nextInt();
                    if (encryptionChoice == 1) {
                        // Call the method for AES encryption here
                        System.out.println("Du valde AES-kryptering.");
                    } else if (encryptionChoice == 2) {
                        // Call the method for RSA encryption here
                        System.out.println("Du valde RSA-kryptering.");
                    } else {
                        System.out.println("Ogiltigt val.");
                    }
                }
            }
        }
    }
}