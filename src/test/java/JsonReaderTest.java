
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    private JsonArray array;
    private JsonReader reader;

    @BeforeEach
    void initObjects() {

        reader = new JsonReader();
        array = new JsonArray();

    }

    /**
     * Create valid Json String
     * @return testJson populated Json string
     */
    String buildTestJson() {

        String testJson;

        testJson = """
                [
                  {
                    "id": 135,
                    "first_name": "Mechelle",
                    "last_name": "Boam",
                    "email": "mboam3q@thetimes.co.uk",
                    "ip_address": "113.71.242.187",
                    "latitude": -6.5115909,
                    "longitude": 105.652983
                  },
                  {
                    "id": 396,
                    "first_name": "Terry",
                    "last_name": "Stowgill",
                    "email": "tstowgillaz@webeden.co.uk",
                    "ip_address": "143.190.50.240",
                    "latitude": -6.7098551,
                    "longitude": 111.3479498
                  },
                  {
                    "id": 520,
                    "first_name": "Andrew",
                    "last_name": "Seabrocke",
                    "email": "aseabrockeef@indiegogo.com",
                    "ip_address": "28.146.197.176",
                    "latitude": "27.69417",
                    "longitude": "109.73583"
                  },
                  {
                    "id": 658,
                    "first_name": "Stephen",
                    "last_name": "Mapstone",
                    "email": "smapstonei9@bandcamp.com",
                    "ip_address": "187.79.141.124",
                    "latitude": -8.1844859,
                    "longitude": 113.6680747
                  },
                  {
                    "id": 688,
                    "first_name": "Tiffi",
                    "last_name": "Colbertson",
                    "email": "tcolbertsonj3@vimeo.com",
                    "ip_address": "141.49.93.0",
                    "latitude": 37.13,
                    "longitude": -84.08
                  },
                  {
                    "id": 794,
                    "first_name": "Katee",
                    "last_name": "Gopsall",
                    "email": "kgopsallm1@cam.ac.uk",
                    "ip_address": "203.138.133.164",
                    "latitude": 5.7204203,
                    "longitude": 10.901604
                  }
                ]""";

        return testJson;
    }

    /**
     * Create Json Array from Json test string
     * @return testDataArray populated Json Array
     */
    JsonArray buildTestJsonArray() {

        JsonArray testDataArray;
        JsonParser parser;
        JsonElement jsonTree;
        String testJson;

        testDataArray = new JsonArray();
        parser = new JsonParser();

        testJson = this.buildTestJson();

        jsonTree = parser.parse(testJson);

        if (jsonTree.isJsonArray()) {
            testDataArray = jsonTree.getAsJsonArray();
        }

        return testDataArray;
    }

    @Test
    @DisplayName("Json Array will be correctly returned when URL provided is valid and creates valid Json for this program")
    void testBuildJsonArray() throws IOException {

        JsonArray testArray;
        URL validURL;

        //Will not allow null URL value
        assertThrows(NullPointerException.class, () -> reader.buildJsonArray(null));

        //Exception when response is no 200
        URL badResponseURL = new URL("https://news.bbc.co.uk/%");
        assertThrows(RuntimeException.class, () -> reader.buildJsonArray(badResponseURL));

        //Catches exception when Json invald for this program
        URL incorrectURL = new URL("https://news.bbc.co.uk");
        assertDoesNotThrow( () -> {
            reader.buildJsonArray(incorrectURL);  });
        //Ensure null is returned
        assertNull(reader.buildJsonArray(incorrectURL));

        //Create array of only London residents
        testArray = buildTestJsonArray();
        //Get users registered as living in London
        validURL = new URL("https://bpdts-test-app.herokuapp.com/city/London/users");
        array = reader.buildJsonArray(validURL);

        assertEquals(testArray, array);

    }

    @Test
    @DisplayName("Stand alone test to support unique ID assumption")
    void testAllIDsUnique() throws IOException {
        JsonArray array;
        JsonReader reader;
        HashMap<Integer, String> uniqueUsers;
        URL url;

        reader = new JsonReader();
        uniqueUsers = new HashMap<>();
        url = new URL("https://bpdts-test-app.herokuapp.com/users");

        //Get JsonArray from API response
        array = reader.buildJsonArray(url);

        for (JsonElement element : array) {
            //Use map to confirm presence of duplicates
            JsonObject object = element.getAsJsonObject();
            uniqueUsers.put(object.get("id").getAsInt(), object.get("last_name").getAsString());
        }

        //How to list people living in London and current near london is based on the below assumption
        assertEquals(array.size(), uniqueUsers.size(), "Each user should have unique ID number");

    }


}
