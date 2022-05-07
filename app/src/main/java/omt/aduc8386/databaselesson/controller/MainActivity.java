package omt.aduc8386.databaselesson.controller;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import omt.aduc8386.databaselesson.R;
import omt.aduc8386.databaselesson.view.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabLayout tlDatabases;
    private ViewPager2 vpDatabases;
    private ViewPagerAdapter vpaDatabases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();

        vpaDatabases = new ViewPagerAdapter(this);
        vpDatabases.setAdapter(vpaDatabases);

        new TabLayoutMediator(tlDatabases, vpDatabases, (tab, position) -> {
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
        vpDatabases = findViewById(R.id.vp_view_pager2);
        tlDatabases = findViewById(R.id.tl_tab_layout);
    }
}