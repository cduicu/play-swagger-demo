package utils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

/**
 * Created by cristiand on 2/27/2016.
 */
public class PetUtils {

    public static final String MESSAGE = "message";
    public static final String APPLICATION_JSON = "application/json";

    public static ObjectNode resultOk() {
        return Json.newObject().put("result", "OK");
    }
    public static ObjectNode resultError() {
        return Json.newObject().put("result", "ERROR");
    }

}
