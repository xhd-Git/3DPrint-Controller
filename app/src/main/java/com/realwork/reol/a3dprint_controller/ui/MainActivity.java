package com.realwork.reol.a3dprint_controller.ui;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

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

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bnv;
    @BindView(R.id.vp_main)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    List<Fragment> list = new ArrayList<>(3);

    private int selectedId = 0;
    private AlertDialog dialog;

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
                        bnv.setSelectedItemId(R.id.tab_favorite);
                        toolbar.setTitle(R.string.bottom_nav_favorite);
                        break;
                    case 1:
                        bnv.setSelectedItemId(R.id.tab_model);
                        toolbar.setTitle(R.string.bottom_nav_model);
                        break;
                    case 2:
                        bnv.setSelectedItemId(R.id.tab_print);
                        toolbar.setTitle(R.string.bottom_nav_print);
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
                    case R.id.tab_favorite:
                        viewPager.setCurrentItem(0, true);
                        break;
                }
                return true;
            }
        });


        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }
            @Override
            public void onDrawerOpened(View drawerView) {
                selectedId = 0;
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                switch (selectedId){
                    case R.id.nav_local:
                        startActivity(new Intent(MainActivity.this, ImportModelAct.class));
                        break;
                    case R.id.nav_history:
                        startActivity(new Intent(MainActivity.this, PrintHistoryAct.class));
                        break;
                    case R.id.nav_downloadManager:
                        startActivity(new Intent(MainActivity.this, DownloadManageAct.class));
                        break;
                    case R.id.nav_setting:
                        startActivity(new Intent(MainActivity.this, SettingAct.class));
                        break;
                    case R.id.nav_share:
                        break;
                    case R.id.nav_report:
                        startActivity(new Intent(MainActivity.this, ReportAct.class));
                        break;
                    case R.id.nav_about:
                        dialog = builder.setTitle("关于")
                                .setMessage("毕业设计作品\n\n" + "可能有各种bug，但我知道这是个好app")
                                .setCancelable(true)
                                .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).create();
                        dialog.show();
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onDrawerStateChanged(int newState) {
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

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
            selectedId = 0;
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

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        selectedId = item.getItemId();
        return true;
    }
}
