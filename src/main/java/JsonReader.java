import org.json.simple.JSONValue;
import org.json.simple.JsonArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonReader {


    private void connectToAPI(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();

        if (responseCode != 200)
            throw new RuntimeException(("HttpResponseCode: " + responseCode));


    }

    private String getJsonFromAPI(URL url) throws IOException {

        String jsonAsString = null;

        this.connectToAPI(url);
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
            jsonAsString += scanner.nextLine();
        }

        scanner.close();

        return jsonAsString;
    }

    public JsonArray buildJsonArray(URL url) throws IOException {
        JsonArray validUsers = null;
        
        return validUsers;

    }
}
