package Donation;

public class Donation {
    private String code, name;
    private int amount;

    public Donation(String code, String name, int amount) {
        this.code = code;
        this.name = name;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;

        if (this.amount <= 0) {
            this.amount = 0;
        }
    }

    public String toString() {
        return "Code: " + code + "\nName: " + name + "\nAmount: " + amount + "\n";
    }
}
