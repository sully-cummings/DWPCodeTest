
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingleJsonParserTest {

    private JsonObject crumbsAndDoiliesJson;
    private JsonObject provenGoodsJson;
    private User cupcakeGemma;
    private User theHomer;
    private Location crumbsAndDoilies;
    private Location provenGoodsCo;
    private TestData testData;

    @BeforeEach
    void JsonObjectTest() {

        testData = new TestData();

        crumbsAndDoilies = new Location(51.51234952905932, -0.1381059294314849,"London");
        provenGoodsCo = new Location(54.96957208399909, -1.5799921004370676,"Newcastle");

        cupcakeGemma = new User(1,crumbsAndDoilies,"Cupcake", "Gemma", "cupcakegemma@test.com","111.22.333.444");
        theHomer = new User(2,provenGoodsCo,"Homer", "Doughnut", "provengoods@test.com","555.66.777.888");

        crumbsAndDoiliesJson = testData.createTestJson(new JsonObject(),cupcakeGemma);
        provenGoodsJson = testData.createTestJson(new JsonObject(),theHomer);

    }

    @Test
    @DisplayName("Json with London city should return true")
    void testGetCityFromJson() {
        assertEquals("London", crumbsAndDoiliesJson.get("city").getAsString(), "Test should return London for London location");
        assertNotEquals("London", provenGoodsJson.get("city").getAsString(), "Test should not return London for Newcastle location");
    }


}
