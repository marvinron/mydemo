package com.maviron.spring.springdemo.until;


import com.alibaba.fastjson.JSONObject;

public class JsonFlattener {
    /**
     * 将json处理成.结构
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        String jsonString = "{" +
                "\"id\": \"2c9dcc0d-2dc902-4527-ad915-4307222b4b28f9301099295\"," +
                "\"imp\": {" +
                "\"bidfloor\": \"100\"," +
                "\"ext\": {" +
                "\"stagid\": \"30000771\"," +
                "\"platform\": 2," +
                "\"tag\": \"90\"" +
                "}" +
                "}" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        //JSONObject jsonObject = new JSONObject(jsonString);
        flattenJson(jsonObject, "");
    }

    private static void flattenJson(JSONObject jsonObject, String parentKey) {
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);

            if (value instanceof JSONObject) {
                // If the value is another JSONObject, recursively flatten it
                flattenJson((JSONObject) value, parentKey + key + ".");
            } else {
                // Otherwise, print the key and value in key.key.key format
                System.out.println(parentKey + key + ": " + value);
            }
        }
    }

    /**
     * 将.结构处理成json
     */
    public static void test() {
        JSONObject json = new JSONObject();
        String property = "value.app.oaid";
        String value = "12312312";

        String[] keys = property.split("\\.");
        JSONObject temp = json;

        for (int i = 0; i < keys.length - 1; i++) {
            if (!temp.containsKey(keys[i])) {
                temp.put(keys[i], new JSONObject());
            }
            temp = temp.getJSONObject(keys[i]);
        }
        temp.put(keys[keys.length - 1], value);

        System.out.println(json.toString());
    }
}
