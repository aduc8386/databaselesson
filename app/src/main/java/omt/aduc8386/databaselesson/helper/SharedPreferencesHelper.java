package omt.aduc8386.databaselesson.helper;


import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {

    public static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    public static final String USER = "USER";

    private static SharedPreferences instance;

    public static SharedPreferences getInstance(Context context) {
        if (instance == null)
            instance = context.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return instance;
    }
}
