package omt.aduc8386.databaselesson.controller.helper;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import omt.aduc8386.databaselesson.model.Support;
import omt.aduc8386.databaselesson.model.User;
import omt.aduc8386.databaselesson.model.UserResponse;
import omt.aduc8386.databaselesson.model.dao.SupportDAO;
import omt.aduc8386.databaselesson.model.dao.UserDAO;
import omt.aduc8386.databaselesson.model.dao.UserResponseDAO;

@Database(entities = {UserResponse.class, User.class, Support.class}, version = 1, exportSchema = false)
public abstract class RoomHelper extends RoomDatabase {
    public abstract UserResponseDAO userResponseDAO();
    public abstract UserDAO userDAO();
    public abstract SupportDAO supportDAO();

    private static RoomHelper instance;

    public static final String ROOM_DATABASE = "ROOM_DATABASE";

    public synchronized static RoomHelper getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), RoomHelper.class, ROOM_DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
