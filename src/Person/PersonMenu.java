package Person;

import java.util.Scanner;

public class PersonMenu {

    private final PersonService personService;

    public PersonMenu(PersonService personService) {
        this.personService = personService;
    }

    public void show(Scanner scanner) {
        System.out.println("********** PESSOAS **********");
        System.out.println("1 - Criar uma nova pessoa");
        System.out.println("2 - Listar todas as pessoas");
        System.out.println("3 - Buscar pessoa por documento");
        System.out.println("4 - Ordenar pessoas por documento");
        System.out.println("5 - Ordenar pessoas por nome");
        System.out.println("6 - Atualizar e-mail por documento");
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
        System.out.println("Digite o documento:");
        String document = scanner.nextLine();
        System.out.println("Digite o e-mail:");
        String email = scanner.nextLine();
        System.out.println("Digite o telefone:");
        String phone = scanner.nextLine();

        this.personService.create(name, document, email, phone);
        System.out.println("Pessoa criada com sucesso!");
    }

    private void handleSearchByDocument(Scanner scanner) {
        System.out.println("Digite o documento:");
        String document = scanner.nextLine();
        System.out.println(this.personService.getByDocument(document));
    }

    private void handleUpdateEmail(Scanner scanner) {
        System.out.println("Digite o documento:");
        String documentToUpdate = scanner.nextLine();
        System.out.println("Digite o novo e-mail:");
        String emailToUpdate = scanner.nextLine();
        this.personService.updateEmailByDocument(documentToUpdate, emailToUpdate);
    }

    public void handleAddDonation(Scanner scanner) {
        System.out.println("Digite o documento da pessoa:");
        String document = scanner.nextLine();
        System.out.println("Digite o código da doação:");
        String donationCode = scanner.nextLine();
        System.out.println("Digite a quantidade da doação:");
        int donationAmount = scanner.nextInt();
        this.personService.addDonation(document, donationCode, donationAmount);
    }
}
