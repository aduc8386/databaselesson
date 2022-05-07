package omt.aduc8386.databaselesson.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SharedPreferencesFragment();
            case 1:
                return new RealmFragment();
            case 2:
                return new RoomFragment();
            default:
                return new SharedPreferencesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
