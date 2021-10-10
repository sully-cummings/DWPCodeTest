import com.google.gson.JsonArray;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class Process {

    private static HashMap<Integer,User> validUsers;
    private static LocationDataFilter locFilter;

    public static void main(String[] args) throws IOException {

        validUsers = new HashMap<>();
        locFilter = new LocationDataFilter(centreOfRadiusLocation(),50.0);
        getAllLondonUsersFromAPI();
        printLondonUsers();
    }

    private static Location centreOfRadiusLocation() {
        Location centreOfLondon;

        //Centre of London is defined as King Charles I statue, Trafalgar Square
        centreOfLondon = new Location(51.50735699315851, -0.12764836711676103,"London");

        return centreOfLondon;
    }

    private static void getAllLondonUsersFromAPI() throws IOException {
        URL url;

        //Get all users living in London
        url = new URL("https://bpdts-test-app.herokuapp.com/city/London/users");
        getUsersFromAPI(url,true);

        //Get all users whose current coordinates are within defined distance from central location
        url = new URL("https://bpdts-test-app.herokuapp.com/users");
        getUsersFromAPI(url,false);
    }

    private static void getUsersFromAPI(URL url, boolean isCityNamedInCall) throws IOException {

        JsonArray array;
        JsonReader reader;
        User[] londonUsers;

        reader = new JsonReader();

        //Get users currently within 50 miles of London
        array = reader.buildJsonArray(url);
        validUsers = locFilter.filterUsersByLocation(array,validUsers,isCityNamedInCall);

    }

    private static void printLondonUsers() {

        System.out.println("*** The total number of people who are listed as either living in London," +
                "\nor whose current coordinates are within 50 miles of London is " + validUsers.size() + " ***");
        for (User u : validUsers.values()) {
            if (u != null)
                System.out.println(u.getFullName());
        }
    }
}
