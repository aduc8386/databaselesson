package omt.aduc8386.databaselesson.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import omt.aduc8386.databaselesson.FullUserAdapter;
import omt.aduc8386.databaselesson.data.api.AppService;
import omt.aduc8386.databaselesson.helper.RealmHelper;
import omt.aduc8386.databaselesson.model.UserResponse;
import omt.aduc8386.databaselesson.R;
import omt.aduc8386.databaselesson.model.Support;
import omt.aduc8386.databaselesson.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RealmFragment extends Fragment {

    private TextView tvPage;
    private TextView tvPerPage;
    private TextView tvTotal;
    private TextView tvTotalPages;
    private TextView tvSupportUrl;
    private TextView tvSupportText;
    private RecyclerView rcvInnerObject;

    public RealmFragment() {
        super(R.layout.fragment_realm);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);

        callApi();
    }

    private void bindView(View view) {
        tvPage = view.findViewById(R.id.tv_page_from_api);
        tvPerPage = view.findViewById(R.id.tv_per_page_from_api);
        tvTotal = view.findViewById(R.id.tv_total_from_api);
        tvTotalPages = view.findViewById(R.id.tv_total_pages_from_api);
        rcvInnerObject = view.findViewById(R.id.rcv_user_list);
        tvSupportUrl = view.findViewById(R.id.tv_support_url);
        tvSupportText = view.findViewById(R.id.tv_support_text);
    }

    private void callApi() {

        AppService.init().getUsers().enqueue(new Callback<UserResponse>() {

            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, Response<UserResponse> response) {

                Toast.makeText(getContext(), "API called success", Toast.LENGTH_SHORT).show();

                UserResponse userResponse = response.body();

                RealmHelper realmHelper = new RealmHelper();

                realmHelper.insertToRealm(userResponse);

                UserResponse userResponseInRealm = realmHelper.getInstance().where(UserResponse.class).findFirst();
                showUserResponse(userResponseInRealm);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getContext(), "API called fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("DefaultLocale")
    private void showUserResponse(UserResponse userResponse) {
        if (userResponse != null) {
            tvPage.setText(String.format("%d", userResponse.getPage()));
            tvPerPage.setText(String.format("%d", userResponse.getPerPage()));
            tvTotal.setText(String.format("%d", userResponse.getTotal()));
            tvTotalPages.setText(String.format("%d", userResponse.getTotalPages()));
            List<User> user = userResponse.getUsers();
            FullUserAdapter fullUserAdapter = new FullUserAdapter(user);
            rcvInnerObject.setAdapter(fullUserAdapter);
            rcvInnerObject.setLayoutManager(new LinearLayoutManager(getContext()));
            Support support = userResponse.getSupport();
            tvSupportUrl.setText(support.getUrl());
            tvSupportText.setText(support.getText());
        }
    }
}

