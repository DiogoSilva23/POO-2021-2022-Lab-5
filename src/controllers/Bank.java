package controllers;

import models.Account;
import models.CashflowRate;
import models.Client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Client> clients = new HashMap<>();
    private Map<String, Account> accounts = new HashMap<>();
    private Collection<CashflowRate> rates = new ArrayList<>();
    private long numAccounts = 0L;

    public Bank() {
        rates.add(new CashflowRate(0.42));
    }

    public boolean hasClient(final String clientId, final String clientIdType) {
        return clients.containsKey(clientId);
    }

    private static String getKey(final String clientId, final String clientIdType) {
        return clientIdType + clientId;
    }

    public void createClient(final String clientId, final String clientIdType, final String birthday, final String email,
                             final String phoneNumber, final String clientName, final String address) {
        final var client = new Client(clientId, clientIdType, birthday, email, address,
                phoneNumber, clientName);
        clients.put(getKey(clientIdType, clientId), client);
    }

    public void changeClient(final String clientId, final String clientIdType, final String birthday, final String email,
                             final String phoneNumber, final String clientName, final String address) {
        final var client = clients.get(getKey(clientId, clientIdType));
        client.setBirthday(birthday);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setName(clientName);
        client.setAddress(address);
    }

    public Collection<Client> getClients() {
        return clients.values();
    }

    public boolean hasClients() {
        return !clients.isEmpty();
    }

    public String createAccount(final String clientId, final String clientIdType, final boolean allowDebt, final double amount) {
        final var client = clients.get(getKey(clientId, clientIdType));
        String accountId = "" + numAccounts++;
        final var account = new Account(accountId, client, allowDebt, amount);
        accounts.put(accountId, account);
        return accountId;
    }

    public boolean isAmountValid(final double amount, final boolean allowDebt) {
        return false;
    }

    public boolean hasAccount(final String accountId) {
        return false;
    }

    public void shareAccount(final String clientId, final String clientIdType, final String accountId, final String sharedClientId, final String sharedClientIdType) {
    }

    public boolean isCashflowAllowed(final String accountId, final double amount) {
        return false;
    }

    public void registerCashflow(final String clientId, final String clientIdType, final String accountId, final double amount) {

    }

    public boolean isAuthorized(final String clientId, final String clientIdType, final String accountId) {
        return false;
    }

    public Collection<Client> getAccountClients(final String accountId) {
        return null;
    }

    public boolean accountAllowsDebt(final String accountId) {
        return false;
    }

    public double getAccountBalance(final String accountId) {
        return 0;
    }

    public void save(String filename) {
        try {
            final var fileOutputStream = new FileOutputStream(filename);
            final var objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println("Ficheiro inexistente.");
        } catch(IOException ioe) {
            System.out.println("Erro na gravação de objetos.");
        }
    }

    public static Bank load(String filename) throws FileNotFoundException {
        FileInputStream fileInputStream = null;
        fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch(IOException e) {
            e.printStackTrace();
        }
        Object obj = null;
        try {
            obj = objectInputStream.readObject();
        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Bank) obj;
    }
}
