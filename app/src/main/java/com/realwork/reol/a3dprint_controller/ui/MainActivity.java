package com.realwork.reol.a3dprint_controller.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.realwork.reol.a3dprint_controller.R;
import com.realwork.reol.a3dprint_controller.ui.Adapter.ViewPagerAdapter;
import com.realwork.reol.a3dprint_controller.ui.base.BaseActivity;
import com.realwork.reol.a3dprint_controller.ui.fragment.MainFragment;
import com.realwork.reol.a3dprint_controller.ui.fragment.MoreModelFragment;
import com.realwork.reol.a3dprint_controller.ui.fragment.PrintFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bnv;
    @BindView(R.id.vp_main)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    List<Fragment> list = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setupData();
    }

    private void setupData() {
        list.add(new MoreModelFragment());
        list.add(new MainFragment());
        list.add(new PrintFragment());


        FragmentManager fm = getSupportFragmentManager();
        ViewPagerAdapter adapter = new ViewPagerAdapter(fm, list);
        viewPager.setAdapter(adapter);

        initPages();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bnv.setSelectedItemId(R.id.tab_more);
                        toolbar.setTitle("更多");
                        break;
                    case 1:
                        bnv.setSelectedItemId(R.id.tab_model);
                        toolbar.setTitle("模型");
                        break;
                    case 2:
                        bnv.setSelectedItemId(R.id.tab_print);
                        toolbar.setTitle("打印");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab_model:
                        viewPager.setCurrentItem(1, true);
                        break;
                    case R.id.tab_print:
                        viewPager.setCurrentItem(2, true);
                        break;
                    case R.id.tab_more:
                        viewPager.setCurrentItem(0, true);
                        break;
                }
                return true;
            }
        });
    }

    private void initPages() {
        viewPager.setCurrentItem(1);
        bnv.setSelectedItemId(R.id.tab_model);
        toolbar.setTitle("模型");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
