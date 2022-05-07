package omt.aduc8386.databaselesson.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import omt.aduc8386.databaselesson.R;
import omt.aduc8386.databaselesson.helper.SharedPreferencesHelper;
import omt.aduc8386.databaselesson.model.User;
import omt.aduc8386.databaselesson.UserAdapter;

public class SharedPreferencesFragment extends Fragment {

    private RecyclerView recyclerView;

    public SharedPreferencesFragment() {
        super(R.layout.fragment_shared_preferences);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);

//        SharedPreferences sharedPreferences = getContext().getSharedPreferences(LoginActivity.MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String usersJson = SharedPreferencesHelper.getInstance(getContext()).getString(SharedPreferencesHelper.USER, "");
        Gson gson = new Gson();

        List<User> users = Arrays.asList(gson.fromJson(usersJson, User[].class));
        UserAdapter userAdapter = new UserAdapter(users);

        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void bindView(View view) {
        recyclerView = view.findViewById(R.id.rv_shared_preferences);
    }
}
