import java.util.Objects;

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

        fullName = firstName + " " + surname;

        return fullName;
    }

    /**
     * Overridden equals method to ensure data members are used to measure equality
     * @param obj User object to be compared with this
     * @return boolean result of comparing all data members of this and obj
     */
    @Override
    public boolean equals(Object obj) {

        if (obj == this)
            return true;

        // Check if obj is an instance of User
        if (!(obj instanceof User u))
            return false;

        // typecast obj to User so that we can compare data members

        // Compare the data members and return accordingly
        return iD == u.iD &&
                (location == u.location || (location != null && location.equals(u.getLocation()))) &&
                (Objects.equals(surname, u.surname) || (surname != null && surname.equals(u.getSurname()))) &&
                (Objects.equals(firstName, u.firstName) || (firstName != null && firstName.equals(u.getFirstName()))) &&
                (Objects.equals(eMail, u.eMail) || (eMail != null && eMail.equals(u.geteMail()))) &&
                (Objects.equals(iPAddress, u.iPAddress) || (iPAddress != null && iPAddress.equals(u.getiPAddress())));
    }

}
