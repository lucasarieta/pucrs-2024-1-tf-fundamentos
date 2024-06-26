import Donation.DonationMenu;
import Donation.DonationService;
import Person.PersonMenu;
import Person.PersonService;

import java.util.Scanner;

public class Main {
    public static PersonService personService;
    public static DonationService donationService;

    public static void main(String[] args) {
        personService = new PersonService();
        donationService = new DonationService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                showMenu(scanner);
            } catch(Exception e) {
               break;
            }
        }
    }

    public static void showMenu(Scanner scanner) {
        System.out.println("********** PESSOAS **********");
        System.out.println("1 - Pessoas");
        System.out.println("2 - Doações");
        System.out.println("3 - Sair");
        System.out.println("**************************");
        System.out.println("Digite a opção que deseja:");
        int option = scanner.nextInt();
        scanner.nextLine();
        handle(option, scanner);
    }

    public static void handle(int option, Scanner scanner) {
        PersonMenu personMenu = new PersonMenu(personService);
        DonationMenu donationMenu = new DonationMenu(donationService);

        switch (option) {
            case 1:
                personMenu.show(scanner);
                break;
            case 2:
                donationMenu.show(scanner);
                break;
            case 3:
                System.out.println("Saindo...");
                scanner.close();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}