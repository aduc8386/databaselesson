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

import java.util.List;

import omt.aduc8386.databaselesson.R;
import omt.aduc8386.databaselesson.controller.api.AppService;
import omt.aduc8386.databaselesson.controller.helper.RoomHelper;
import omt.aduc8386.databaselesson.model.Support;
import omt.aduc8386.databaselesson.model.User;
import omt.aduc8386.databaselesson.model.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RoomFragment extends Fragment {

    private TextView tvPage;
    private TextView tvPerPage;
    private TextView tvTotal;
    private TextView tvTotalPages;
    private TextView tvSupportUrl;
    private TextView tvSupportText;
    private RecyclerView rcvInnerObject;

    public RoomFragment() {
        super(R.layout.fragment_room);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView(view);

        callApi();
    }

    private void callApi() {
        AppService.init().getUsers().enqueue(new Callback<UserResponse>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Toast.makeText(getContext(), "API called success", Toast.LENGTH_SHORT).show();

                UserResponse userResponse = response.body();
                List<User> users = userResponse.getUsers();

                for(User user : users) {
                    user.setUserResponseId(1);
                }

                Support support = userResponse.getSupport();
                support.setUserResponseId(1);

                RoomHelper roomHelper = RoomHelper.getInstance(getContext());

                roomHelper.userResponseDAO().insert(userResponse);
                roomHelper.userDAO().insert(users);
                roomHelper.supportDAO().insert(support);

                showUserResponse(roomHelper);

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getContext(), "API called fail", Toast.LENGTH_SHORT).show();
            }
        });
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

    @SuppressLint("DefaultLocale")
    public void showUserResponse(RoomHelper roomHelper) {
        if (roomHelper.userResponseDAO().getAll() != null && roomHelper.supportDAO().getAll() != null && roomHelper.userDAO().getAll() != null) {

            UserResponse userResponse = roomHelper.userResponseDAO().getAll().get(0);
            Support support = roomHelper.supportDAO().getAll().get(0);
            List<User> user = roomHelper.userDAO().getAll();

            tvPage.setText(String.format("%d", userResponse.getPage()));
            tvPerPage.setText(String.format("%d", userResponse.getPerPage()));
            tvTotal.setText(String.format("%d", userResponse.getTotal()));
            tvTotalPages.setText(String.format("%d", userResponse.getTotalPages()));
            FullUserAdapter fullUserAdapter = new FullUserAdapter(user);
            rcvInnerObject.setAdapter(fullUserAdapter);
            rcvInnerObject.setLayoutManager(new LinearLayoutManager(getContext()));
            tvSupportUrl.setText(support.getUrl());
            tvSupportText.setText(support.getText());
        }
    }
}
