package controllers;

import models.Client;

import java.io.*;
import java.util.Collection;

public class Bank {
    public boolean hasClient(final String clientId, final String clientIdType) { return false; }

    public void createClient(final String clientId, final String clientIdType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {

    }

    public void changeClient(final String clientId, final String clientIdType, final String birthday, final String email, final String phoneNumber, final String clientName, final String address) {

    }

    public Collection<Client> getClients() {
        return null;
    }

    public boolean hasClients() {
        return false;
    }

    public String createAccount(final String clientId, final String clientIdType, final boolean allowDebt, final double amount) { return null; }

    public boolean isAmountValid(final double amount, final boolean allowDebt) {
        return false;
    }

    public boolean hasAccount(final String accountId) {
        return false;
    }

    public void shareAccount(final String clientId, final String clientIdType, final String accountId, final String sharedClientId, final String sharedClientIdType) {}

    public boolean isCashflowAllowed(final String accountId, final double amount){ return false; }

    public void registerCashflow(final String clientId, final String clientIdType, final String accountId, final double amount){

    }
    public boolean isAuthorized(final String clientId, final String clientIdType, final String accountId) { return false; }

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
        return (Bank)obj;
    }
}
