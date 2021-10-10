import org.json.simple.JsonArray;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

public class JsonReaderTest {

    private LocationDataFilter locFilter;
    private Location centreOfLondon;
    User[] validUsers;

    @BeforeEach
    void APIReaderTest() {

        centreOfLondon = new Location("London",51.50735699315851, -0.12764836711676103);
        locFilter = new LocationDataFilter(centreOfLondon,50.0);

    }

    @Test
    @DisplayName("")
    void testBuildJsonArray() throws IOException, ParseException {
        JsonArray array;
        JsonReader reader;
        URL url;


        url = new URL("https://bpdts-test-app.herokuapp.com/users");

        reader = new JsonReader();

        array = reader.buildJsonArray(url);
        locFilter.filterUsersByLocation(array);

        for (User u : validUsers) {
            if (u != null)
                System.out.println(u.getFullName());
        }
    }


}
