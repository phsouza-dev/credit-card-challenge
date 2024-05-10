package main;

import models.CreditCard;
import models.Purchase;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int endTransaction = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o limite do cartão:");
        double cardLimit = Double.parseDouble(scanner.nextLine());
        System.out.println("-----------------------------------------------");

        CreditCard creditCard = new CreditCard(cardLimit);

        while (endTransaction == 1) {
            System.out.println("Digite a descrição da compra:");
            String purchaseDescription = scanner.nextLine();

            System.out.println("Digite o valor da compra:");
            double purchaseAmount = Double.parseDouble(scanner.nextLine());

            Purchase purchase = new Purchase(purchaseDescription, purchaseAmount);

            if (creditCard.setPurchase(purchase)) {
                System.out.println("\nCompra realizada!");
                System.out.println("\nDigite 0 para SAIR ou 1 para CONTINUAR");
            } else {
                System.out.println("Saldo insuficiente!");
                break;
            }

            endTransaction = Integer.parseInt(scanner.nextLine());

        }

        scanner.close();

        System.out.println("***********************************************");
        System.out.println("COMPRAS REALIZADAS");
        System.out.println("-----------------------------------------------");

        Collections.sort(creditCard.getPurchases());

        for (Purchase purchase: creditCard.getPurchases()) {
            System.out.println(purchase.getDescription() + " - " + purchase.getAmount());
        }

        System.out.println("-----------------------------------------------");

        System.out.println("Saldo: " + creditCard.getBalance());

        System.out.println("***********************************************");
    }
}