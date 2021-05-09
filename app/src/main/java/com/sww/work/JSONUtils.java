package com.sww.work;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Rex.Wei on 2018/11/16.
 *
 * @author 韦玉庭 weiyuting
 */
public class JSONUtils {

    private static final Gson gson = createGSON();

    @NonNull
    public static JSONObject copyJSONObject(JSONObject obj) {
        final JSONObject copy = new JSONObject();

        if (obj == null || obj.length() == 0) {
            return copy;
        }

        try {
            Iterator<String> keyIterator = obj.keys();
            while (keyIterator.hasNext()) {
                final String key = keyIterator.next();
                copy.putOpt(key, obj.opt(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return copy;
    }

    @NonNull
    public static void copyJSONObject(JSONObject target, JSONObject source) {
        if (target == null || source == null || source.length() == 0) {
            return;
        }

        try {
            Iterator<String> keyIterator = source.keys();
            while (keyIterator.hasNext()) {
                final String key = keyIterator.next();
                target.putOpt(key, source.opt(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    @Nullable
    public static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        } else if (superclass instanceof ParameterizedType) {
            final ParameterizedType parameterized = (ParameterizedType) superclass;
            return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
        }
        return null;
    }

    public static JsonElement getJsonElement(String json) {
        return new JsonParser().parse(json);
    }

    @Nullable
    public static <T> T getSafeObject(String json, Type typeOfT) {
        if (json == null || typeOfT == null) {
            return null;
        }
        try {
            return fromJson(json, typeOfT);
        } catch (Exception e) {
            return null;
        }
    }

    @Nullable
    public static <K, V> Map<K, V> jsonToMapSafe(String json, TypeToken<Map<K, V>> typeToken) {
        try {
            return gson.fromJson(json, typeToken.getType());
        } catch (Exception e) {
            return null;
        }
    }

    @NonNull
    public static JSONObject parseJSONObjectNonNull(@Nullable String json) {
        JSONObject jsonObject = parseJSONObject(json);
        if (jsonObject == null) {
            jsonObject = new JSONObject();
        }
        return jsonObject;
    }

    @Nullable
    public static JSONObject parseJSONObject(@Nullable String json) {
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        try {
            return new JSONObject(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    @SafeVarargs
    public static JSONObject safeJson(Pair<String, Object>... elements) {
        JSONObject jsonObject = new JSONObject();
        for (Pair<String, Object> element : elements) {
            try {
                jsonObject.put(element.first, element.second);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    @NonNull
    public static JSONObject safeJson(Map<String, ?> map) {
        if (map != null) {
            try {
                return createJSONObject(map);
            } catch (Exception e) {
            }
        }
        return new JSONObject();
    }

    @NonNull
    public static JSONObject createJSONObject(Map<String, ?> map) throws Exception {
        final JSONObject jsonObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                jsonObject.putOpt(entry.getKey(), entry.getValue());
            }
        }
        return jsonObject;
    }

    @NonNull
    public static String safeJsonString(Map<String, ?> map) {
        return safeJson(map).toString();
    }

    private static Gson createGSON() {
        return new GsonBuilder().setLenient().create();
    }
}
