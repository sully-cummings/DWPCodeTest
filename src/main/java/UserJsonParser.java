import org.json.simple.JsonObject;

public class UserJsonParser {

    public void UserJasonParser() {
        
    }

    public User buildUserFromJson(JsonObject json) {

        Location userLocation;
        User user;

        // Ensure city, lat and long values are correctly cast to String, Double and Double to create location obj
        userLocation = new Location(json.get("city").toString(), Double.parseDouble(json.get("latitude").toString()), Double.parseDouble(json.get("longitude").toString()));

        //Cast person json output to String to create person object
        user = new User(Integer.parseInt(json.get("id").toString()), userLocation, json.get("first_name").toString(), json.get("last_name").toString(), json.get("email").toString(), json.get("ip_address").toString());

        return user;
    }

}
