package models;

public class Account {
    private final Client client;
    private final boolean allowDebt;
    private final String id;
    private double balance;

    public Account(final String id, final Client client, final boolean allowDebt, final double amount) {
        this.id = id;
        this.client = client;
        this.allowDebt = allowDebt;
        this.balance = amount;
    }
}
