import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.MalformedJsonException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class JsonReader {

    public JsonReader() {

    }

    private void connectToAPI(URL url) throws IOException {

        HttpURLConnection connection;
        int responseCode;

        connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            responseCode = connection.getResponseCode();

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
        JsonArray validUsers;
        JsonElement jsonTree;
                String jsonAsString;
        boolean isValidJson;

         validUsers = null;
         jsonTree =null;
                jsonAsString =  this.getJsonFromAPI(url);
        isValidJson = false;

        JsonParser parser = new JsonParser();

        try {
             jsonTree = parser.parse(jsonAsString);
            isValidJson = true;
        } catch (Throwable e) {
            System.out.println("Exception: " + e);
        }

            if (isValidJson && jsonTree.isJsonArray())
                validUsers = jsonTree.getAsJsonArray();


       return validUsers;

    }

}
