import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

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

        crumbsAndDoilies = new Location("London", 51.51234952905932, -0.1381059294314849);
        centreOfLondon = new Location("London",51.50735699315851, -0.12764836711676103);
        fortyNineMilesFromLondon = new Location ("Carlton",52.171098 , 0.33003330);
        provenGoodsCo = new Location("Newcastle", 54.96957208399909, -1.5799921004370676);

        kingCharlesI = new User(1,centreOfLondon,"King", "Charles I", "royalstatue@test.com","111.22.333.444");
        doctorPrincess = new User(2,fortyNineMilesFromLondon,"Doctor", "Princess", "pamhalpert@test.com","222.33.444.555");
        cupcakeGemma = new User(1,crumbsAndDoilies,"Cupcake", "Gemma", "cupcakegemma@test.com","333.44.555.666");
        theHomer = new User(2,provenGoodsCo,"Homer", "Doughnut", "provengoods@test.com","444.55.666.777");

        centreOfLondonJson = this.createTestJson(new JsonObject(),kingCharlesI);
        fortyNineMilesJson = this.createTestJson(new JsonObject(),doctorPrincess);
        crumbsAndDoiliesJson = this.createTestJson(new JsonObject(),cupcakeGemma);
        provenGoodsJson = this.createTestJson(new JsonObject(),theHomer);

        users = new JsonArray();
        users.add(centreOfLondonJson);
        users.add(fortyNineMilesJson);
        users.add(crumbsAndDoiliesJson);
        users.add(provenGoodsJson);

        londonUsers = new JsonArray();
        londonUsers.add(centreOfLondonJson);
        londonUsers.add(crumbsAndDoiliesJson);

    }

    public JsonObject createTestJson(JsonObject Json, User user) {
        Json.put("id", user.getiD());
        Json.put("first_name", user.getFirstName());
        Json.put("last_name", user.getSurname());
        Json.put("email", user.geteMail());
        Json.put("ip_address", user.getiPAddress());
        Json.put("city", user.getLocation().getCity());
        Json.put("latitude", user.getLocation().getLatitude());
        Json.put("longitude", user.getLocation().getLongitude());

        return Json;
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
