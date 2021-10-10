import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class LocationDataFilter {

    private Location targetLocation;
    private double targetRadius;

     public  LocationDataFilter(Location targetLocation, Double radius) {
         this.targetLocation = targetLocation;
         this.targetRadius = radius;
    }

    /**
     * Create User objects from Array of Json data
     * @param data Json data from API call
     * @return users Array of User objects
     */
    private User[] createUsersFromJsonData(JsonArray data) {

        UserJsonParser userJsonParser;
        User[] users;
        int count;

        count = 0;
        users = new User[data.size()];

        for(JsonElement element : data){
            //Instantiate user for each json object
            JsonObject object = element.getAsJsonObject();
            User user = UserJsonParser.buildUserFromJson(object);
            users[count++] = user;
        }
        return users;

    }

    /**
     * Return all users registered as residents of target city or use matrix calculator class to filter results based on coordinates
     * @param data Array of Json user objects from API call
     * @param validUsers unique map of users that meet inclusion criteria
     * @param citySpecified users will not be filtered by coords if true
     */
    public HashMap<Integer,User> filterUsersByLocation(JsonArray data, HashMap<Integer,User> validUsers, boolean citySpecified) {

        DistanceMatrixCalculator distanceCalc;
        User[] users;
        int i;

        distanceCalc = new DistanceMatrixCalculator();
        i = 0;

        //Instantiate array of user objects from array of Json objects
        users = this.createUsersFromJsonData(data);

        while (i< users.length) {
            User user = users[i];
            if (citySpecified) {
                //Include all results as users live in target city
                validUsers.put(user.getiD(),user);
                i++;
                continue;
            }
            if (distanceCalc.inRangeOfTarget(user.getLocation(), targetLocation, targetRadius)) {
                //Include only users whose coordinates are inside search area
                validUsers.put(user.getiD(),user);
                i++;
                continue;
            }

            i++;

        }
        return validUsers;

    }

}