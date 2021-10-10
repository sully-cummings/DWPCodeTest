import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import java.nio.file.attribute.AclEntryType;
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

        Iterator i = data.stream().iterator();

        while (i.hasNext()) {
            //Create user obj from Json obj
            User user = userJsonParser.buildUserFromJson((JsonObject) i.next());
            users[count++] = user;
        }
        return users;
    }

    public User[] filterUsersByLocation(JsonArray data) {
        DistanceMatrixCalculator distanceCalc;
        User[] users;
        User[] validUsers;
        int i;

        distanceCalc = new DistanceMatrixCalculator();
        i = 0;
        validUsers = new User[data.size()];

        users = this.createUsersFromJsonData(data);

        while (i< users.length) {
            User user = users[i];
            if (distanceCalc.isTargetCity(user.getLocation(), targetLocation)) {
                validUsers[i++] = user;
                continue;
            }
            if (distanceCalc.inRangeOfTarget(user.getLocation(), targetLocation, targetRadius)) {
                validUsers[i++] = user;
                continue;
            }

            i++;

        }
        return validUsers;

    }


}