package omt.aduc8386.databaselesson;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import omt.aduc8386.databaselesson.model.User;

public class FullUserAdapter extends RecyclerView.Adapter<FullUserAdapter.MyViewHolder> {

    private List<User> users;
    private Context context;

    public FullUserAdapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View userView = inflater.inflate(R.layout.item_realm, parent, false);

        context = parent.getContext();
        return new FullUserAdapter.MyViewHolder(userView);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = users.get(position);

        holder.tv_id.setText(String.format("%d", user.getId()));
        holder.tv_last_name.setText(user.getLastName());
        holder.tv_first_name.setText(user.getFirstName());
        holder.tv_email.setText(user.getEmail());

        Glide.with(context)
                .load(user.getAvatar())
                .centerCrop()
                .into(holder.iv_avatar);

    }

    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_id;
        private TextView tv_first_name;
        private TextView tv_last_name;
        private TextView tv_email;
        private ImageView iv_avatar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_first_name = itemView.findViewById(R.id.tv_first_name);
            tv_last_name = itemView.findViewById(R.id.tv_last_name);
            tv_email = itemView.findViewById(R.id.tv_email);
            iv_avatar = itemView.findViewById(R.id.iv_avatar);
        }
    }

}
