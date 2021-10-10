import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LocationDataFilterTest {

    private LocationDataFilter dataFilter;
    private TestData testData;
    private User[] validUsers;

    @BeforeEach
    void LocationDataFilterTest() {

        testData = new TestData(true);
        dataFilter = new LocationDataFilter(testData.getCentreOfLondon(), 50.0);

    }

    @Test
    @DisplayName("")
    void testFilterUsersByLocation() {
        validUsers = dataFilter.filterUsersByLocation(testData.getUsers());
        for (User u: validUsers){
            if (u != null)
            System.out.println(u.getFullName());
        }
    }

}
