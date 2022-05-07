package omt.aduc8386.databaselesson.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

@Entity(tableName = "USER_RESPONSE")
public class UserResponse extends RealmObject {

    @PrimaryKey
    private Integer page;
    @Ignore
    private Support support;
    private Integer total;
    @SerializedName("per_page")
    private Integer perPage;
    @SerializedName("total_pages")
    private Integer totalPages;
    @SerializedName("data")
    @Ignore
    private RealmList<User> users;

    public UserResponse() {
    }

    public RealmList<User> getUsers() {
        return users;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Support getSupport() {
        return support;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setUsers(RealmList<User> users) {
        this.users = users;
    }
}
