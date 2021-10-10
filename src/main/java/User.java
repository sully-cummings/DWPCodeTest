public class User {
    private int iD;
    private Location location;
    private String firstName;
    private String surname;
    private String eMail;
    private String iPAddress;

    //Constructor
    public User(int iD, Location loc, String firstName, String surname, String eMail, String iPAdd) {
        this.iD = iD;
        this.location = loc;
        this.firstName = firstName;
        this.surname = surname;
        this.eMail = eMail;
        this.iPAddress = iPAdd;
    }

    public int getiD() {
        return iD;
    }

    public Location getLocation() {
        return location;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String geteMail() {
        return eMail;
    }

    public String getiPAddress() {
        return iPAddress;
    }

    public String getFullName() {

        String fullName;

        fullName = firstName + "" + surname;

        return fullName;
    }
}
