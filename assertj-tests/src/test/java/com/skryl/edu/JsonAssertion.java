package com.skryl.edu;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Skryl D.V. on 2023-07-05
 */
public class JsonAssertion {

    @Test
    void testJsonKey() {
        JsonObject json = new JsonObject();
        json.addProperty("one", "plus");
        json.addProperty("two", "minus");
        JsonObject result = new JsonObject();
        result.add("result", json);
        assertThat(result.keySet()).contains("result");
    }

    @Test
    void testEntireJsonObject() {
        JsonObject json = new JsonObject();
        json.addProperty("one", "plus");
        json.addProperty("two", "minus");
        JsonObject result = new JsonObject();
        result.add("result", json);
        assertThat(result.toString()).isEqualTo("{\"result\":{\"one\":\"plus\",\"two\":\"minus\"}}");
    }
}
