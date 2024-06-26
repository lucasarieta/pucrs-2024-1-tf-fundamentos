package Donation;

import java.util.List;
import java.util.Scanner;

public class DonationMenu {
    private final DonationService donationService;


    public DonationMenu(DonationService donationService) {
        this.donationService = donationService;
    }

    public void show(Scanner scanner) {
        System.out.println("********** MENU **********");
        System.out.println("1 - Criar uma nova doação");
        System.out.println("2 - Listar doação pelo nome");
        System.out.println("3 - Adicionar quantidade à doação");
        System.out.println("4 - Retirar quantidade de doação");
        System.out.println("5 - Listar todas as doações com itens maiores que X");
        System.out.println("6 - Listar todas as doações");
        System.out.println("7 - Voltando");
        System.out.println("**************************");

        int option = scanner.nextInt();
        scanner.nextLine();
        handle(option, scanner);
    }

    public void handle(int option, Scanner scanner) {
        switch (option) {
            case 1:
                handleCreateDonation(scanner);
                break;
            case 2:
                handleSearchByName(scanner);
                break;
            case 3:
                handleAddQuantity(scanner);
                break;
            case 4:
                handleRemoveQuantity(scanner);
                break;
            case 5:
                handleSearchDonationsByAmount(scanner);
                break;
            case 6:
                handleListAllDonations();
                break;
            case 7:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    public void handleCreateDonation(Scanner scanner) {
        System.out.println("Digite o código da doação:");
        String code = scanner.nextLine();
        System.out.println("Digite o nome da doação:");
        String name = scanner.nextLine();
        System.out.println("Digite a quantidade da doação:");
        int amount = scanner.nextInt();

        this.donationService.create(code, name, amount);
        System.out.println("Doação criada com sucesso!");
    }

    public void handleSearchByName(Scanner scanner) {
        System.out.println("Digite o nome da doação:");
        String name = scanner.nextLine();

        Donation donation = this.donationService.searchByName(name);

        System.out.println(donation.toString());
    }

    public void handleAddQuantity(Scanner scanner) {
        System.out.println("Digite o código da doação:");
        String code = scanner.nextLine();
        System.out.println("Digite a quantidade a ser adicionada:");
        int quantity = scanner.nextInt();

        this.donationService.addQuantity(code, quantity);
        System.out.println("Você adicionou " + quantity + " à doação " + code);
    }

    public void handleRemoveQuantity(Scanner scanner) {
        System.out.println("Digite o código da doação:");
        String code = scanner.nextLine();
        System.out.println("Digite a quantidade a ser retirada:");
        int quantity = scanner.nextInt();

        this.donationService.removeQuantity(code, quantity);
        System.out.println("Você removeu " + quantity + " da doação " + code);
    }

    public void handleSearchDonationsByAmount(Scanner scanner) {
        System.out.println("Digite o valor mínimo:");
        int amount = scanner.nextInt();
        scanner.nextLine();

        List<Donation> donations = this.donationService.searchDonationsByAmount(amount);
        if (donations.isEmpty()) {
            System.out.println("Não há doações com valor maior ou igual a " + amount);
            return;
        }

        donations.forEach(donation -> {
            System.out.println(donation.toString());
        });
    }

    public void handleListAllDonations() {
        List<Donation> donations = this.donationService.donations;

        if (donations.isEmpty()) {
            System.out.println("Não há doações cadastradas.");
            return;
        }

        donations.forEach(donation -> {
            System.out.println(donation.toString());
        });
    }
}
