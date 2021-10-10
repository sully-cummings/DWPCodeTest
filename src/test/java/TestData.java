import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TestData {

    private JsonArray users;
    private JsonArray londonUsers;

    private JsonObject crumbsAndDoiliesJson;
    private JsonObject centreOfLondonJson;
    private JsonObject fortyNineMilesJson;
    private JsonObject provenGoodsJson;

    private Location crumbsAndDoilies;
    private Location centreOfLondon;
    private Location fortyNineMilesFromLondon;
    private Location provenGoodsCo;

    private User cupcakeGemma;
    private User kingCharlesI;
    private User doctorPrincess;
    private User theHomer;


    public TestData(boolean createAllData) {

        this.createTestData();

    }

    public TestData() {

    }

        private void createTestData() {

        crumbsAndDoilies = new Location( 51.51234952905932, -0.1381059294314849,"London");
        centreOfLondon = new Location(51.50735699315851, -0.12764836711676103,"London");
        fortyNineMilesFromLondon = new Location (52.171098 , 0.33003330,"Carlton");
        provenGoodsCo = new Location(54.96957208399909, -1.5799921004370676,"Newcastle");

        kingCharlesI = new User(1,centreOfLondon,"King", "Charles I", "royalstatue@test.com","111.22.333.444");
        doctorPrincess = new User(2,fortyNineMilesFromLondon,"Doctor", "Princess", "pamhalpert@test.com","222.33.444.555");
        cupcakeGemma = new User(3,crumbsAndDoilies,"Cupcake", "Gemma", "cupcakegemma@test.com","333.44.555.666");
        theHomer = new User(4,provenGoodsCo,"Homer", "Doughnut", "provengoods@test.com","444.55.666.777");

        centreOfLondonJson = this.createUserTestJson(new JsonObject(),kingCharlesI);
        fortyNineMilesJson = this.createUserTestJson(new JsonObject(),doctorPrincess);
        crumbsAndDoiliesJson = this.createUserTestJson(new JsonObject(),cupcakeGemma);
        provenGoodsJson = this.createUserTestJson(new JsonObject(),theHomer);

        users = new JsonArray();
        users.add(centreOfLondonJson);
        users.add(fortyNineMilesJson);
        users.add(crumbsAndDoiliesJson);
        users.add(provenGoodsJson);

        londonUsers = new JsonArray();
        londonUsers.add(centreOfLondonJson);
        londonUsers.add(crumbsAndDoiliesJson);

    }

    public JsonObject createUserTestJson(JsonObject Json, User user) {
        Json.addProperty("id", user.getiD());
        Json.addProperty("first_name", user.getFirstName());
        Json.addProperty("last_name", user.getSurname());
        Json.addProperty("email", user.geteMail());
        Json.addProperty("ip_address", user.getiPAddress());
        Json.addProperty("city", user.getLocation().getCity());
        Json.addProperty("latitude", user.getLocation().getLatitude());
        Json.addProperty("longitude", user.getLocation().getLongitude());

        return Json;
    }

    public JsonObject createTestJson(JsonObject json) {
        json.addProperty("name", "frank");
        json.addProperty("job", "developer");

        return json;
    }

    public JsonArray getUsers() {
        return users;
    }

    public JsonArray getLondonUsers() {
        return londonUsers;
    }

    public Location getCentreOfLondon() {
        return centreOfLondon;
    }

}
