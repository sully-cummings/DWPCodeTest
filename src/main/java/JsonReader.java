import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonReader {

    public JsonReader() {

    }

    private void connectToAPI(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int responseCode = connection.getResponseCode();

        if (responseCode != 200)
            throw new RuntimeException(("HttpResponseCode: " + responseCode));


    }

    private String getJsonFromAPI(URL url) throws IOException {

        StringBuilder jsonAsString;

        this.connectToAPI(url);
        Scanner scanner = new Scanner(url.openStream());

        jsonAsString = new StringBuilder();

        while (scanner.hasNext()) {
          jsonAsString.append(scanner.nextLine());
        }

        scanner.close();

        return jsonAsString.toString();
    }

    public JsonArray buildJsonArray(URL url) throws IOException {
        JsonArray validUsers = null;
        String jsonAsString;

        jsonAsString =  this.getJsonFromAPI(url);

        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(jsonAsString);

        if(jsonTree.isJsonArray()) {
            validUsers = jsonTree.getAsJsonArray();
        }

       return validUsers;

    }

}
