package Bank.application;

import Bank.model.entities.Account;
import ExceptionSoluxan.model.exeception.DomainException;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe os dados da conta");
        System.out.print("Numero: ");
        int number = sc.nextInt();
        System.out.print("Titular: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Saldo inicial: ");
        double balance = sc.nextDouble();
        System.out.print("limite de saque: ");
        double withdrawLimit = sc.nextDouble();
        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Informe uma quantidade para sacar: ");
        double amount = sc.nextDouble();

        try {
            acc.withDraw(amount);
            System.out.printf("Novo saldo: %.2f%n", acc.getBalance());
        }
        catch (DomainException e) {
            System.out.println(e.getMessage());
        }
    }
}
