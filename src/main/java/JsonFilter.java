import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

import java.util.Iterator;

public class JsonFilter {

    public  JsonFilter() {

    }

    public Object[] getAllValuesForKey(JsonArray data, String key) {

        Object[] dataValues;
        int count;

        count = 0;
        dataValues = new String[data.size()];

        Iterator i = data.stream().iterator();

        while (i.hasNext()) {
            JsonObject object = (JsonObject) i.next();
            dataValues[count++] = object.get(key);
        }

        return dataValues;
    }

    public JsonArray filterDataByKeyValue(JsonArray data, String key, Object value ) {

        JsonArray filteredData;
        int count;

        count = 0;
        filteredData = new JsonArray();

        Iterator i = data.stream().iterator();

        while (i.hasNext()) {
            JsonObject object = (JsonObject) i.next();
            if (object.get(key).equals(value))
                filteredData.add(object);
        }

        return filteredData;
    }

}
