import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LocationDataFilterTest {

    private LocationDataFilter dataFilter;
    private TestData testData;
    private HashMap<Integer,User> validUsers;

    @BeforeEach
    void initObjects() {

        validUsers = new HashMap<>();
        testData = new TestData(true);
        dataFilter = new LocationDataFilter(testData.getCentreOfLondon(), 50.0);

    }

    @Test
    @DisplayName("")
    void testFilterUsersByLocation() {
        validUsers = dataFilter.filterUsersByLocation(testData.getUsers(),validUsers, false);
        for (User u: validUsers.values()){
            if (u != null)
            System.out.println(u.getFullName());
        }
    }

}
