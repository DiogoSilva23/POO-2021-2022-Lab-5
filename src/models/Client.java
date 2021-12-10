package models;

public class Client {
    private final String clientId;
    private final String clientIdType;
    private String birthday;
    private String email;
    private String address;
    private String phoneNumber;
    private String clientName;

    public Client(final String clientId, final String clientIdType, final String birthday, final String email, final String address, final String phoneNumber, final String clientName) {
        this.clientId = clientId;
        this.clientIdType = clientIdType;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.clientName = clientName;
    }

    public String getId() {
        return null;
    }

    public String getIdTypeSymbol() {
        return null;
    }

    public String getName() {
        return null;
    }

    public String getBirthday() {
        return null;
    }

    public String getEmail() {
        return null;
    }

    public String getPhoneNumber() {
        return null;
    }

    public String getAddress() {
        return null;
    }

    public void setBirthday(final String birthday) {
    }

    public void setEmail(final String email) {
    }

    public void setPhoneNumber(final String phoneNumber) {
    }

    public void setName(final String clientName) {
    }

    public void setAddress(final String address) {
    }
}
