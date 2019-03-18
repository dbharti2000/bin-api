package utils;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;

public class JsonReader {

    public static JsonElement getJsonBody() throws IOException {

        return new JsonParser().parse(readStringFromFile("request.json"));

    }

    public static String readStringFromFile(String jsonFile) throws IOException {
        return Resources.toString(JsonReader.class.getClassLoader().getResource(jsonFile), Charsets.UTF_8);

    }
}
