package omt.aduc8386.databaselesson;

import static android.media.CamcorderProfile.get;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import omt.aduc8386.databaselesson.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users) {
        this.users = users;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView username;
        private TextView password;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.tv_username);
            password = itemView.findViewById(R.id.tv_password);
        }
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View userView = inflater.inflate(R.layout.item_share_preferences, parent, false);

        return new MyViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        User user = users.get(position);

        holder.username.setText(user.getUserName());
        holder.password.setText(user.getPassword());
    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }
}
