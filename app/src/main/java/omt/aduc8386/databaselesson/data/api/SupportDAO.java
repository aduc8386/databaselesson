package omt.aduc8386.databaselesson.data.api;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import omt.aduc8386.databaselesson.model.Support;

@Dao
public interface SupportDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Support support);

    @Query("SELECT * FROM SUPPORT")
    List<Support> getAll();
}
