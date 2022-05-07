package omt.aduc8386.databaselesson.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import io.realm.RealmObject;

@Entity(tableName = "SUPPORT")
public class Support extends RealmObject {

    @PrimaryKey(autoGenerate = true)
    private Integer id;

    private Integer userResponseId;

    private String url;
    private String text;

    public Integer getUserResponseId() {
        return userResponseId;
    }

    public void setUserResponseId(Integer userResponseId) {
        this.userResponseId = userResponseId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
