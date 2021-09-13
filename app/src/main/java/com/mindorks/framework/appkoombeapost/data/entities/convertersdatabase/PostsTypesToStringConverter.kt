package com.mindorks.framework.appkoombeapost.data.entities.convertersdatabase

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mindorks.framework.appkoombeapost.data.entities.*
import java.lang.reflect.Type
import java.util.*

class PostsTypesToStringConverter {


    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Post?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<Post?>?>() {}.type
        return gson.fromJson<List<Post?>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Post?>?): String? {
        return gson.toJson(someObjects)
    }
}
