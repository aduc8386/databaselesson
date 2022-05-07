package omt.aduc8386.databaselesson.controller.helper;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import omt.aduc8386.databaselesson.model.UserResponse;

public class RealmHelper {

    private Realm instance;

    public RealmHelper() {
        if(instance == null) {
            RealmConfiguration config = new RealmConfiguration.Builder()
                    .name(REALM_NAME)
                    .allowQueriesOnUiThread(true)
                    .allowWritesOnUiThread(true)
                    .build();
            instance = Realm.getInstance(config);
        }
    }

    public final String REALM_NAME = "REALM_NAME";

    public Realm getInstance() {
        return instance;
    }

    public void insertToRealm(UserResponse userResponse) {
        try{
            instance.executeTransaction(transactionRealm -> {
                transactionRealm.insert(userResponse);
                transactionRealm.commitTransaction();
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
