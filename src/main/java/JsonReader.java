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

    /**
     * Connect to specified API and throw error if response is not 200
     * @param url address to connect to
     * @throws IOException if connection fails
     * @throws RuntimeException if response from URL is not 200
     */
    private void connectToAPI(URL url) throws IOException {

        HttpURLConnection connection;
        int responseCode;

        connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            responseCode = connection.getResponseCode();

        if (responseCode != 200)
            //Do not continue with program
            throw new RuntimeException(("HttpResponseCode: " + responseCode));

    }

    /**
     * Create string from Json API response
     * @param url API address
     * @return String API json response as String
     */
    private String getJsonFromAPI(URL url) throws IOException {

        StringBuilder jsonAsString;

        this.connectToAPI(url);

        Scanner scanner = new Scanner(url.openStream());
        jsonAsString = new StringBuilder();

        while (scanner.hasNext()) {
            //Build json string
          jsonAsString.append(scanner.nextLine());
        }

        scanner.close();

        return jsonAsString.toString();
    }

    /**
     * Populate Json Array from API response
     * @param url API address
     * @return validUsers
     */
    public JsonArray buildJsonArray(URL url) throws IOException {

        JsonArray users;
        JsonElement jsonTree;
        String jsonAsString;
        boolean isValidJson;

        users = null;
        jsonTree = null;
        isValidJson = false;

        //Get string of API Json response
        jsonAsString = this.getJsonFromAPI(url);
        JsonParser parser = new JsonParser();

        try {
            //If string is not in expected json format, exception will be thrown
            jsonTree = parser.parse(jsonAsString);
            isValidJson = true;
        } catch (Throwable e) {
            //Handle and null will be returned
            System.out.println("Exception: " + e);
        }

        if (isValidJson && jsonTree.isJsonArray())
            //Convert to Json Array
            users = jsonTree.getAsJsonArray();

        return users;

    }

}
