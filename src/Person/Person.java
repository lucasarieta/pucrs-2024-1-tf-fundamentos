package Person;

public class Person {
    private String name, document, email, phone, donations;

    public Person(String name, String document, String email, String phone) {
        this.name = name;
        this.document = document;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Nome: " + name + "\nCPF: " + document + "\nEmail: " + email + "\nTelefone: " + phone + "\nDonations: " + donations  + "\n";
    }

    public void addDonation(String donationCode, double amount) {
        this.donations += donationCode + " - " + amount + "x\n";

        System.out.println("Doação adicionada: " + donationCode + " - " + amount);
    }
}