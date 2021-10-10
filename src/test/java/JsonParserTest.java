
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {

    private JsonObject crumbsAndDoiliesJson;
    private JsonObject provenGoodsJson;
    private JsonObject nonDWPUserJson;
    private User cupcakeGemma;
    private User theHomer;
    private Location crumbsAndDoilies;
    private Location provenGoodsCo;
    private TestData testData;


    @BeforeEach
    void initObjects() {

        testData = new TestData();

        crumbsAndDoilies = new Location(51.51234952905932, -0.1381059294314849,"London");
        provenGoodsCo = new Location(54.96957208399909, -1.5799921004370676,"Newcastle");

        cupcakeGemma = new User(1,crumbsAndDoilies,"Cupcake", "Gemma", "cupcakegemma@test.com","111.22.333.444");
        theHomer = new User(2,provenGoodsCo,"Homer", "Doughnut", "provengoods@test.com","555.66.777.888");

        crumbsAndDoiliesJson = testData.createUserTestJson(new JsonObject(),cupcakeGemma);
        provenGoodsJson = testData.createUserTestJson(new JsonObject(),theHomer);

        nonDWPUserJson = new JsonObject();
        nonDWPUserJson = testData.createTestJson(nonDWPUserJson);

    }

    @Test
    @DisplayName("Json with London city should return true")
    void testGetCityFromJson() {
        assertEquals("London", crumbsAndDoiliesJson.get("city").getAsString(), "Test should return London for London location");
        assertNotEquals("London", provenGoodsJson.get("city").getAsString(), "Test should not return London for Newcastle location");
    }

    @Test
    @DisplayName("Valid User object intantiated from Json valid for this program")
    void buildUserFromJson() {

        assertEquals(cupcakeGemma, UserJsonParser.buildUserFromJson(crumbsAndDoiliesJson));
        assertNull(UserJsonParser.buildUserFromJson(nonDWPUserJson));

        //Null pointer exception handled when Json invalid for this program is provided
        assertDoesNotThrow( () -> {
            UserJsonParser.buildUserFromJson(nonDWPUserJson); });

    }
}
