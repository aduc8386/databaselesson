package omt.aduc8386.databaselesson.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import omt.aduc8386.databaselesson.R;
import omt.aduc8386.databaselesson.model.User;

public class LoginActivity extends AppCompatActivity {

    public static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    public static final String USER = "USER";

    public List<User> users;

    private EditText edtUsername;
    private EditText edtPassword;
    private TextView tvLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm.init(this);

        bindView();
        users = new ArrayList<>();
        users.add(new User("Duc", "111"));
        users.add(new User("Thuy", "222"));
        users.add(new User("Huong", "333"));
        users.add(new User("Nhung", "444"));
        users.add(new User("Anh", "555"));

        String usersInDB = new Gson().toJson(users);

        SharedPreferences sharedPreferences = getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER, usersInDB);
        editor.apply();

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);

                String getUsers = sharedPreferences.getString(USER, "");
                User[] usersInDB = new Gson().fromJson(getUsers, User[].class);
                
                int count = 0;
                for(int i = 0; i < usersInDB.length; i++) {
                    if(usersInDB[i].getUserName().equals(username) && usersInDB[i].getPassword().equals(password)) {
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    } else count++;
                }
                if(count == usersInDB.length)
                    Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void bindView() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        tvLogin = findViewById(R.id.tv_login_button);
    }
}
