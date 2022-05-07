package omt.aduc8386.databaselesson;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import omt.aduc8386.databaselesson.view.RealmFragment;
import omt.aduc8386.databaselesson.view.RoomFragment;
import omt.aduc8386.databaselesson.view.SharedPreferencesFragment;

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
