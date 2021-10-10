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
    @DisplayName("Users will be filtered if city specified in routine call")
    void testFilterUsersByLocation() {

        // Only users in and around London will be valid as using co-ordinates to filter when citySpecified is false
        validUsers = dataFilter.filterUsersByLocation(testData.getUsers(),validUsers, false);
        for (User u: validUsers.values()){
            if (u != null)
            System.out.println(u.getFullName());
        }

        //Empty map
        validUsers.clear();
        System.out.println("\n");

        // All users will be valid as no filtering applied when citySpecified is true
        validUsers = dataFilter.filterUsersByLocation(testData.getUsers(),validUsers, true);
        for (User u: validUsers.values()){
            if (u != null)
                System.out.println(u.getFullName());
        }

        //Empty map
        validUsers.clear();
        System.out.println("\n");

        // All London users will be valid as using co-ordinates to filter when citySpecified is false
        validUsers = dataFilter.filterUsersByLocation(testData.getLondonUsers(),validUsers, false);
        for (User u: validUsers.values()){
            if (u != null)
                System.out.println(u.getFullName());
        }

        //Empty map
        validUsers.clear();
        System.out.println("\n");

        // All London users will be valid as no filtering applied when citySpecified is true
        validUsers = dataFilter.filterUsersByLocation(testData.getLondonUsers(),validUsers, true);
        for (User u: validUsers.values()){
            if (u != null)
                System.out.println(u.getFullName());
        }

        //Empty map
        validUsers.clear();
        System.out.println("\n");


    }

}
