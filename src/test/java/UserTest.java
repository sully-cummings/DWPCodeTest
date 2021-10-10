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
    @DisplayName("")
    void testGetiD() {
        assertEquals(1,testUser.getiD());
        assertThrows(NullPointerException.class, () -> unInitUser.getiD());
    }

    @Test
    @DisplayName("")
    void testGetLocation() {
        Location testLoc;
        Location testLocNoCity;

        testLoc = new Location(41.668587885412926, -73.36475200152044,"Stars Hollow");
        testLocNoCity = new Location(41.668587885412926, -73.36475200152044);

        assertThrows(NullPointerException.class, () -> unInitUser.getLocation());

        assertEquals(testLoc.getLatitude(),testUser.getLocation().getLatitude());
        assertEquals(testLoc.getLongitude(),testUser.getLocation().getLongitude());
        assertEquals(testLoc.getCity(),testUser.getLocation().getCity());

        assertEquals(testLocNoCity.getLatitude(),testUser.getLocation().getLatitude());
        assertEquals(testLocNoCity.getLongitude(),testUser.getLocation().getLongitude());
        assertNotEquals(testLocNoCity.getCity(),testUser.getLocation().getCity());

    }

    @Test
    @DisplayName("")
    void testGetFirstName() {
        assertEquals("Lorelai",testUser.getFirstName());
        assertNotNull(testUser.getFirstName());
        assertThrows(NullPointerException.class, () -> unInitUser.getFirstName());

    }

    @Test
    @DisplayName("")
    void testGetSurname() {
        assertEquals("Gilmore",testUser.getSurname());
        assertNotNull(testUser.getSurname());
        assertThrows(NullPointerException.class, () -> unInitUser.getSurname());
    }

    @Test
    @DisplayName("")
    void testGetEMail() {
        assertEquals("l.gilmore@thedragonfly.com",testUser.geteMail());
        assertNotNull(testUser.geteMail());
        assertThrows(NullPointerException.class, () -> unInitUser.geteMail());
    }

    @Test
    @DisplayName("")
    void testGetiPAddress() {
        assertEquals("111.22.333.444",testUser.getiPAddress());
        assertNotNull(testUser.getiPAddress());
        assertThrows(NullPointerException.class, () -> unInitUser.getiPAddress());
    }

    @Test
    @DisplayName("")
    void testGetFullName() {
        assertEquals("Lorelai Gilmore",testUser.getFullName());
        assertNotNull(testUser.getFullName());
        assertThrows(NullPointerException.class, () -> unInitUser.getFullName());
    }

    @Test
    @DisplayName("")
    void testEquals() {
        assertEquals(duplicateUser,testUser);
        assertNotEquals(similarUser,testUser);
        assertThrows(NullPointerException.class, () -> unInitUser.equals(testUser));
    }


}
