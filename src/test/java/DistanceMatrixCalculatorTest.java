import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceMatrixCalculatorTest {

    private DistanceMatrixCalculator matrix;
    private Location crumbsAndDoilies;
    private Location FortyNineMilesFromLondon;
    private Location FiftyMilesFromLondon;
    private Location FiftyOneMilesFromLondon;
    private Location centreOfLondon;
    private Location unknownLondonCoords;


    @BeforeEach
    void createTestLocations() {
        matrix = new DistanceMatrixCalculator();
        crumbsAndDoilies = new Location( 51.51234952905932, -0.1381059294314849,"London");
        FortyNineMilesFromLondon = new Location (51.468659 , -1.2719679,"Hermitage");
        FiftyMilesFromLondon = new Location (52.126004 , -0.73730767,"Emberton");
        FiftyOneMilesFromLondon = new Location(51.567577 , -1.2870593,"Chilton");
        centreOfLondon = new Location(51.50735699315851, -0.12764836711676103,"London");
        unknownLondonCoords = new Location( 51.51234952905932, -0.1381059294314849,"London");
    }

    @Test
    @DisplayName("London location should return true")
    void testIsTargetCity() {
        assertEquals(true, matrix.isTargetCity(crumbsAndDoilies, centreOfLondon), "London location should return true when London is target city");
        assertEquals(false, matrix.isTargetCity(FortyNineMilesFromLondon, centreOfLondon), "Non London location should return false when London is target city");
    }

    @Test
    @DisplayName("Locations within specified range should return true")
    void testInRangeOfTarget(){
        assertEquals(true,matrix.inRangeOfTarget(crumbsAndDoilies, centreOfLondon,50) );
        assertEquals(true,matrix.inRangeOfTarget(FortyNineMilesFromLondon,  centreOfLondon,50) );
      // assertEquals(true,matrix.inRangeOfTarget(FiftyMilesFromLondon,  centreOfLondon,50) );
        assertEquals(true,matrix.inRangeOfTarget(centreOfLondon,  centreOfLondon,50) );
        assertEquals(false,matrix.inRangeOfTarget(FiftyOneMilesFromLondon,  centreOfLondon,50) );

        assertThrows(NullPointerException.class, () -> matrix.inRangeOfTarget(null, centreOfLondon,50));

        assertThrows(NullPointerException.class, () -> matrix.inRangeOfTarget(crumbsAndDoilies, null,50));

        matrix.inRangeOfTarget(crumbsAndDoilies, centreOfLondon,0);
        matrix.inRangeOfTarget(crumbsAndDoilies, centreOfLondon,-50);

    }

}
