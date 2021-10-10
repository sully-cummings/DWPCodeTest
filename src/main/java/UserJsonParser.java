import com.google.gson.JsonObject;

public class UserJsonParser {

    public void UserJasonParser() {
        
    }

    public User buildUserFromJson(JsonObject json) {

        Location userLocation;
        User user;

        // Ensure city, lat and long values are correctly cast to String, Double and Double to create location obj
        userLocation = new Location(json.get("latitude").getAsDouble(), json.get("longitude").getAsDouble());

        //Cast person json output to String to create person object
        user = new User(Integer.parseInt(json.get("id").getAsString()), userLocation, json.get("first_name").getAsString(), json.get("last_name").getAsString(), json.get("email").getAsString(), json.get("ip_address").getAsString());

        return user;
    }

}
