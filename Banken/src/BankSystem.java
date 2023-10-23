import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BankSystem {
    private Map<Integer, Account> accounts;
    private FileEncryptor fileEncryptor;

    public BankSystem() {
        this.accounts = new HashMap<>();
        this.fileEncryptor = new FileEncryptor();
    }

    public void createAccount(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Kontonumret är redan taget.");
        } else {
            Account account = new Account(accountNumber);
            accounts.put(accountNumber, account);
            System.out.println("Konto skapat framgångsrikt.");
        }
    }

    public void login(int accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            Account account = accounts.get(accountNumber);
            System.out.println("Inloggning lyckades. Välkommen till meny B.");
            account.showMenuB();
        } else {
            System.out.println("Kontot finns inte.");
        }
    }

    public void saveAccountsToFile() {
        try {
            fileEncryptor.encryptToFile(accounts, "accounts.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAccountsFromFile() {
        try {
            accounts = fileEncryptor.decryptFromFile("accounts.dat");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


 public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        bankSystem.loadAccountsFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Visa meny A");
            System.out.println("2. Avsluta");
            int choice = scanner.nextInt();
            if (choice == 1) {
                System.out.println("1. Skapa konto");
                System.out.println("2. Logga in på konto");
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.println("Ange kontonummer:");
                    int accountNumber = scanner.nextInt();
                    bankSystem.createAccount(accountNumber);
                } else if (option == 2) {
                    System.out.println("Ange kontonummer:");
                    int accountNumber = scanner.nextInt();
                    bankSystem.login(accountNumber);
                }
            } else if (choice == 2) {
                bankSystem.saveAccountsToFile();
                break;
            }
        }

        scanner.close();
    }
        }

