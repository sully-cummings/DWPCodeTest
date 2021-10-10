import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class LocationTest {

    private Location crumbsAndDoilies;
    private Location provenGoods; //Uninitialised location
    private Location unKnownLondonLoc;

    @BeforeEach
    void createTestLocations() {
        crumbsAndDoilies = new Location( 51.51234952905932, -0.1381059294314849,"London");
        unKnownLondonLoc = new Location(51.51234952905932, -0.1381059294314849);
    }

    @Test
    @DisplayName("City value should be correctly returned when not null")
    void testGetCity() {
        assertEquals("London",crumbsAndDoilies.getCity());
        assertNotEquals(unKnownLondonLoc.getCity(),crumbsAndDoilies.getCity());
        assertThrows(NullPointerException.class, () -> provenGoods.getCity());
    }

    @Test
    @DisplayName("Latitude value should be correctly returned when not null")
    void testGetLatitude() {
        assertEquals(51.51234952905932,crumbsAndDoilies.getLatitude());
        assertThrows(NullPointerException.class, () -> provenGoods.getLatitude());
    }

    @Test
    @DisplayName("Longitude value should be correctly returned when not null")
    void testLongitude() {
        assertEquals(-0.1381059294314849,crumbsAndDoilies.getLongitude());
        assertThrows(NullPointerException.class, () -> provenGoods.getLongitude());
        //City name not required for locations to be the same
        assertEquals(crumbsAndDoilies,unKnownLondonLoc);
    }



}
