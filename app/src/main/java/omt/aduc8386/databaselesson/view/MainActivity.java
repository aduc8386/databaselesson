package omt.aduc8386.databaselesson.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import omt.aduc8386.databaselesson.R;
import omt.aduc8386.databaselesson.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Shared Preferences");
                    break;
                case 1:
                    tab.setText("Realm");
                    break;
                case 2:
                    tab.setText("Room");
                    break;
            }
        }).attach();

    }

    private void bindView() {
        viewPager2 = findViewById(R.id.vp_view_pager2);
        tabLayout = findViewById(R.id.tl_tab_layout);
    }
}