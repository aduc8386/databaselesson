package omt.aduc8386.databaselesson.data.api;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import omt.aduc8386.databaselesson.model.UserResponse;

@Dao
public interface UserResponseDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(UserResponse userResponse);

    @Query("SELECT * FROM USER_RESPONSE")
    List<UserResponse> getAll();
}
