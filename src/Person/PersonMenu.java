package Person;

import Donation.DonationService;

import java.util.Scanner;

public class PersonMenu {

    private final PersonService personService;
    private final DonationService donationService;

    public PersonMenu(PersonService personService, DonationService donationService) {
        this.personService = personService;
        this.donationService = donationService;
    }

    public void show(Scanner scanner) {
        System.out.println("********** PESSOAS **********");
        System.out.println("1 - Criar uma nova pessoa");
        System.out.println("2 - Listar todas as pessoas");
        System.out.println("3 - Buscar pessoa por CPF");
        System.out.println("4 - Ordenar pessoas por CPF");
        System.out.println("5 - Ordenar pessoas por nome");
        System.out.println("6 - Atualizar e-mail por CPF");
        System.out.println("7 - Adicionar doação à pessoa");
        System.out.println("8 - Voltar");
        System.out.println("**************************");
        System.out.println("Digite a opção que deseja:");

        int option = scanner.nextInt();
        scanner.nextLine();
        handle(option, scanner);
    }

    private void handle(int option, Scanner scanner) {
        switch (option) {
            case 1:
                handleCreatePerson(scanner);
                break;
            case 2:
                System.out.println(this.personService.getPeople());
                break;
            case 3:
                handleSearchByDocument(scanner);
                break;
            case 4:
                System.out.println(this.personService.orderByDocument());
                break;
            case 5:
                System.out.println(this.personService.orderByName());
                break;
            case 6:
                handleUpdateEmail(scanner);
                break;
            case 7:
                handleAddDonation(scanner);
                break;
            case 8:
                System.out.println("Voltando...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void handleCreatePerson(Scanner scanner) {
        System.out.println("Digite o nome:");
        String name = scanner.nextLine();
        System.out.println("Digite o CPF:");
        String document = scanner.nextLine();
        System.out.println("Digite o e-mail:");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String phone = scanner.nextLine();

        this.personService.create(name, document, email, phone);
        System.out.println("Pessoa criada com sucesso!");
    }

    private void handleSearchByDocument(Scanner scanner) {
        System.out.println("Digite o CPF:");
        String document = scanner.nextLine();
        System.out.println(this.personService.getByDocument(document));
    }

    private void handleUpdateEmail(Scanner scanner) {
        System.out.println("Digite o CPF:");
        String documentToUpdate = scanner.nextLine();
        System.out.println("Digite o novo e-mail:");
        String emailToUpdate = scanner.nextLine();
        this.personService.updateEmailByDocument(documentToUpdate, emailToUpdate);
    }

    public void handleAddDonation(Scanner scanner) {
        System.out.println("Digite o CPF da pessoa:");
        String document = scanner.nextLine();
        System.out.println("Digite o código da doação:");
        String donationCode = scanner.nextLine();
        System.out.println("Digite a quantidade da doação:");
        int donationAmount = scanner.nextInt();

        if (this.personService.getByDocument(document).isEmpty()) {
            System.out.println("Pessoa não encontrada.");
            return;
        }

        if (this.donationService.canAddDonation(donationCode, donationAmount)) {
            System.out.println("Doação não encontrada ou quantidade insuficiente.");
            return;
        }

        this.personService.addDonation(document, donationCode, donationAmount);
    }
}
