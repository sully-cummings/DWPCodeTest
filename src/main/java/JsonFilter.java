

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Iterator;

public class JsonFilter {

    public  JsonFilter() {

    }

    public String[] getAllStringValuesFromKey(JsonArray data, String key) {

        String[] dataValues;
        int count;

        count = 0;
        dataValues = new String[data.size()];

        for(JsonElement element : data){
            JsonObject object = element.getAsJsonObject();
            dataValues[count++] = object.get(key).getAsString();
        }

        return dataValues;
    }

    public JsonArray filterStringDataByKeyValue(JsonArray data, String key, String value ) {

        JsonArray filteredData;

        filteredData = new JsonArray();

        for(JsonElement element : data){
            JsonObject object = element.getAsJsonObject();
            if (object.get(key).getAsString().equals(value))
                filteredData.add(object);
        }

        return filteredData;
    }

}
