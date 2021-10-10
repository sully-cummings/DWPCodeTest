
import com.google.gson.JsonArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//TODO Do stuff with this one

public class JsonFilterTest {

    private JsonFilter filteredJson;
    private TestData testData;
    private JsonArray users;
    private JsonArray londonUsers;

    @BeforeEach
    void JsonObjectTest() {

        testData = new TestData(true);
        filteredJson = new JsonFilter();
        users = testData.getUsers();
        londonUsers = testData.getLondonUsers();

    }

    @Test
    @DisplayName("")
    void testUsersArrayContents() {
      System.out.println(users);
      System.out.println(londonUsers);
    }

    @Test
    @DisplayName("")
    void testGetNamesFromJson() {

        String[] userNames =  filteredJson.getAllStringValuesFromKey(users, "first_name");
        String[] londonUserNames = filteredJson.getAllStringValuesFromKey(londonUsers, "first_name");

        System.out.println(Arrays.toString(userNames));
        System.out.println(Arrays.toString(londonUserNames));
    }

    @Test
    @DisplayName("Json with London city should return true")
    void testFilterDataByKeyValue() {
        assertEquals(londonUsers, filteredJson.filterStringDataByKeyValue(users, "city","London"), "User array should match london users when filtered by city of London");
        assertNotEquals(londonUsers, filteredJson.filterStringDataByKeyValue(users, "city","Newcastle"), "User array should not match london users when filtered by city of Newcastle");
        assertNotEquals(users, filteredJson.filterStringDataByKeyValue(users, "city","London"), "User array should change when filtered by city of London");
    }

}
