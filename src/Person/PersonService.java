package Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class PersonService {
    public List<Person> people;

    public PersonService() {
        this.people = new ArrayList<>();
    }

    public void create(String name, String document, String email, String phone) {
        if (this.hasSomeoneWithTheSameDocument(document)) {
            System.out.println("Já existe uma pessoa com este CPF.");
            return;
        }

        Person person = new Person(name, document, email, phone);
        people.add(person);
    }

    public boolean hasSomeoneWithTheSameDocument(String document) {
        return people.stream().anyMatch(person -> person.getDocument().equals(document));
    }

    public String getPeople() {
        StringBuilder people = new StringBuilder();

        for (Person person : this.people) {
            people.append(person.toString());
        }

        return people.toString();
    }

    public Optional<Person> getByDocument(String document) {
        return people.stream().filter(person -> person.getDocument().equals(document)).findFirst();
    }

    public List<Person> orderByDocument() {
        people.sort(Comparator.comparing((Person person) -> person.getDocument()));
        return people;
    }

    public List<Person> orderByName() {
        people.sort(Comparator.comparing((Person person) -> person.getName()));
        return people;
    }

    public void updateEmailByDocument(String document, String email) {
        Optional<Person> person = getByDocument(document);

        if (person.isPresent()) {
            person.get().setEmail(email);
        }
    }

    public void addDonation(String document, String donationCode, double donationAmount) {
        Optional<Person> person = getByDocument(document);

        if (person.isPresent()) {
            person.get().addDonation(donationCode, donationAmount);
        }
    }
}
