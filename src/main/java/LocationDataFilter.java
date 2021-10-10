

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.nio.file.attribute.AclEntryType;
import java.util.HashMap;
import java.util.Iterator;

public class LocationDataFilter {

    private Location targetLocation;
    private double targetRadius;

     public  LocationDataFilter(Location targetLocation, Double radius) {
         this.targetLocation = targetLocation;
         this.targetRadius = radius;
    }

    private User[] createUsersFromJsonData(JsonArray data) {

        UserJsonParser userJsonParser;
        User[] users;
        int count;

        count = 0;
        userJsonParser = new UserJsonParser();
        users = new User[data.size()];

        for(JsonElement element : data){
            JsonObject object = element.getAsJsonObject();
            User user = userJsonParser.buildUserFromJson(object);
            users[count++] = user;
        }
        return users;

    }

    public HashMap<Integer,User> filterUsersByLocation(JsonArray data, HashMap<Integer,User> validUsers, boolean citySpecified) {
        DistanceMatrixCalculator distanceCalc;
        User[] users;
        int i;

        distanceCalc = new DistanceMatrixCalculator();
        i = 0;

        users = this.createUsersFromJsonData(data);

        while (i< users.length) {
            User user = users[i];
            if (citySpecified) {
                validUsers.put(user.getiD(),user);
                i++;
                continue;
            }
            if (distanceCalc.inRangeOfTarget(user.getLocation(), targetLocation, targetRadius)) {
                validUsers.put(user.getiD(),user);
                i++;
                continue;
            }

            i++;

        }
        return validUsers;

    }

}