package application;

import model.entities.Account;
import model.exceptions.DomainExceptions;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Account account = new Account();

        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            account.setNumber(sc.nextInt());
            System.out.print("Holder: ");
            sc.nextLine();
            account.setHolder(sc.nextLine());
            System.out.print("Initial balance: ");
            account.deposit(sc.nextDouble());
            System.out.print("Withdraw limit: ");
            account.setWithdrawLimit(sc.nextDouble());

            System.out.println();

            System.out.print("Enter amount for withdraw: ");
            account.withdraw(sc.nextDouble());
            System.out.println("New Balance: " + String.format("%.2f",account.getBalance()));
        }
        catch (DomainExceptions e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

    }
}