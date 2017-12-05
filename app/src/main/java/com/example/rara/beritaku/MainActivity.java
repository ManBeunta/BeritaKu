package com.example.rara.beritaku;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rara.beritaku.Fragment.Berita;
import com.example.rara.beritaku.Fragment.Kategori;
import com.example.rara.beritaku.Fragment.User;
import com.example.rara.beritaku.MenuDrawer.About;
import com.example.rara.beritaku.MenuDrawer.Pendahuluan;
import com.example.rara.beritaku.MenuDrawer.Profile;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ViewPager vPager;
    TabLayout Tabs;
    Context c ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vPager = (ViewPager)findViewById(R.id.vPager);
        Tabs = (TabLayout)findViewById(R.id.Tabs);

        setupViewPager(vPager);
        Tabs.setupWithViewPager(vPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setupViewPager(ViewPager vPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        // Menambahkan fragment yang akan di tampilkan
        adapter.addFragment(new Kategori(), "Menu Kategori");
        adapter.addFragment(new Berita(), "Menu Berita");
        adapter.addFragment(new User(), "User");
        vPager.setAdapter(adapter);
    }
    // Adapter ViewPager
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        // Membuat list Fragment yang akan di tampilkan
        private final List<Fragment> fragmentList = new ArrayList<>();
        // list nama dari Fragment
        private final List<String>nameList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm){
            super(fm);
        }
        //get data fragment
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        // menghitung jumlah tabs yang akan di tampilkan
        @Override
        public int getCount() {
            return fragmentList.size();
        }
        // methode menambah fragment yang akan di tampilkan
        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            nameList.add(title);
        }
        //menampilkan nama dari tebs
        @Override
        public CharSequence getPageTitle(int posision){
            return nameList.get(posision);
        }
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

        if (id == R.id.Profile) {
            startActivity(new Intent(getApplicationContext(), Profile.class));
        } else if (id == R.id.Pendahuluan) {
            startActivity(new Intent(getApplicationContext(), Pendahuluan.class));
        } else if (id == R.id.About) {
            startActivity(new Intent(getApplicationContext(), About.class));
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
