import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User testUser;
    private User duplicateUser;
    private User similarUser;
    private User unInitUser;

    @BeforeEach
    void initUser() {
        testUser = new User(1, new Location(41.668587885412926, -73.36475200152044,"Stars Hollow"),"Lorelai","Gilmore","l.gilmore@thedragonfly.com","111.22.333.444");
        duplicateUser = new User(1, new Location(41.668587885412926, -73.36475200152044,"Stars Hollow"),"Lorelai","Gilmore","l.gilmore@thedragonfly.com","111.22.333.444");
        similarUser = new User(1, new Location(41.668587885412926, -73.36475200152044,"Stars Hollow"),"Rory","Gilmore","l.gilmore@thedragonfly.com","111.22.333.444");
    }

    @Test
    @DisplayName("IDe should be correctly returned when not null")
    void testGetiD() {
        assertEquals(1,testUser.getiD());
        assertThrows(NullPointerException.class, () -> unInitUser.getiD());
    }

    @Test
    @DisplayName("Locations correctly returned when not null")
    void testGetLocation() {
        Location testLoc;
        Location testLocNoCity;

        testLoc = new Location(41.668587885412926, -73.36475200152044,"Stars Hollow");
        testLocNoCity = new Location(41.668587885412926, -73.36475200152044);

        assertThrows(NullPointerException.class, () -> unInitUser.getLocation());

        //Only lat and lon are considered when comparing location objects
        assertEquals(testLoc, testUser.getLocation());
        assertEquals(testLocNoCity, testUser.getLocation());

    }

    @Test
    @DisplayName("First name should be correctly returned when not null")
    void testGetFirstName() {
        assertEquals("Lorelai",testUser.getFirstName());
        assertNotNull(testUser.getFirstName());
        assertThrows(NullPointerException.class, () -> unInitUser.getFirstName());
    }

    @Test
    @DisplayName("Surname should be correctly returned when not null")
    void testGetSurname() {
        assertEquals("Gilmore",testUser.getSurname());
        assertNotNull(testUser.getSurname());
        assertThrows(NullPointerException.class, () -> unInitUser.getSurname());
    }

    @Test
    @DisplayName("Email address should be correctly returned when not null")
    void testGetEMail() {
        assertEquals("l.gilmore@thedragonfly.com",testUser.geteMail());
        assertNotNull(testUser.geteMail());
        assertThrows(NullPointerException.class, () -> unInitUser.geteMail());
    }

    @Test
    @DisplayName("IP Address should be correctly returned when not null")
    void testGetiPAddress() {
        assertEquals("111.22.333.444",testUser.getiPAddress());
        assertNotNull(testUser.getiPAddress());
        assertThrows(NullPointerException.class, () -> unInitUser.getiPAddress());
    }

    @Test
    @DisplayName("First and last names should be concatenated with space between")
    void testGetFullName() {
        assertEquals("Lorelai Gilmore",testUser.getFullName());
        assertNotNull(testUser.getFullName());
        assertThrows(NullPointerException.class, () -> unInitUser.getFullName());
    }

    @Test
    @DisplayName("Overridden equals method - objects are the same if all data members are the same")
    void testEquals() {
        //Two distinct objects with identical data members
        assertThrows(NullPointerException.class, () -> unInitUser.equals(testUser));
        assertEquals(duplicateUser,testUser);

        //Two distinct objects with differing data members
        assertNotEquals(similarUser,testUser);
    }


}
