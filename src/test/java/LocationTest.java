import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LocationTest {

    private Location crumbsAndDoilies;
    private Location provenGoods;
    private Location centreOfLondon;

    @BeforeEach
    void createTestLocations() {
        crumbsAndDoilies = new Location( 51.51234952905932, -0.1381059294314849,"London");
        provenGoods = new Location( 54.96957208399909, -1.5799921004370676,"Newcastle");
        centreOfLondon = new Location(51.50735699315851, -0.12764836711676103,"Unknown");
    }

    @Test
    @DisplayName("London co-ordinates should return true")
    void testGetLocation() {
        assertEquals("London", crumbsAndDoilies.getLocation(51.51234952905932, -0.1381059294314849));
        assertEquals("Newcastle", provenGoods.getLocation(54.96957208399909, -1.5799921004370676));
        //TODO Test unknown city value
    }



}
