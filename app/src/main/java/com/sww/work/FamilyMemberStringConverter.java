package com.sww.work;

import android.text.TextUtils;
import android.util.Log;

import androidx.room.TypeConverter;

import com.google.gson.reflect.TypeToken;

/**
 * Created by Rex.Wei on 2020-08-30
 *
 * @author 韦玉庭
 */
public final class FamilyMemberStringConverter {

    private static final String TAG = "ObjectStringConverter";

    @TypeConverter
    public static FamilyMember convertToObject(String value) {
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        try {
            return JSONUtils.fromJson(value, new TypeToken<FamilyMember>() {
            }.getType());
        } catch (Exception e) {
            Log.e(TAG, "fail to convertToObject," + e.getMessage());
        }
        return null;
    }

    @TypeConverter
    public static String convertToString(FamilyMember obj) {
        if (obj == null) {
            return null;
        }
        return JSONUtils.toJson(obj);
    }

}
