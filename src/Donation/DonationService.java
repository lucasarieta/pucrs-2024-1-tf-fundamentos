package Donation;

import java.util.ArrayList;
import java.util.List;

public class DonationService {
    public List<Donation> donations;

    public DonationService() {
        this.donations = new ArrayList<>();
    }

    public void create(String code, String name, int amount) {
        if (this.isDonationCodeAlreadyInUse(code)) {
            throw new IllegalArgumentException("Já existe uma doação com este código.");
        }

        if (this.isDonationNameAlreadyInUse(name)) {
            throw new IllegalArgumentException("Já existe uma doação com este nome.");
        }

        Donation donation = new Donation(code, name, amount);
        donations.add(donation);
    }

    public boolean isDonationCodeAlreadyInUse(String code) {
        return donations.stream().anyMatch(donation -> donation.getCode().equals(code));
    }

    public boolean isDonationNameAlreadyInUse(String name) {
        return donations.stream().anyMatch(donation -> donation.getName().equals(name));
    }

    public Donation searchByName(String name) {
        return donations.stream().filter(donation -> donation.getName().equals(name)).findFirst().orElse(null);
    }

    public void addQuantity(String code, int amount) {
        Donation donation = donations.stream().filter(d -> d.getCode().equals(code)).findFirst().orElse(null);

        if (donation == null) {
            throw new IllegalArgumentException("Doação não encontrada.");
        }

        donation.setAmount(donation.getAmount() + amount);
    }

    public void removeQuantity(String code, int amount) {
        Donation donation = donations.stream().filter(d -> d.getCode().equals(code)).findFirst().orElse(null);

        if (donation == null) {
            throw new IllegalArgumentException("Doação não encontrada.");
        }

        donation.setAmount(donation.getAmount() - amount);
    }

    public List<Donation> searchDonationsByAmount(int amount) {
        return donations.stream().filter(donation -> donation.getAmount() >= amount).toList();
    }
}
