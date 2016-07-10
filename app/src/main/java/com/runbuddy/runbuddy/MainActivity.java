package com.runbuddy.runbuddy;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.runbuddy.runbuddy.Login.LoginActivity;
import com.runbuddy.runbuddy.Login.ShareLogin.RegisterPage;
import com.runbuddy.runbuddy.view.ChangeIconColor;
import com.runbuddy.runbuddy.widgets.DetailActivity;
import com.runbuddy.runbuddy.widgets.RecyclerViewAdapter;
import com.runbuddy.runbuddy.widgets.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, RecyclerViewAdapter.OnItemClickListener {

    public static final String AVATAR_URL = "http://lorempixel.com/200/200/people/1/";

    private static List<ViewModel> items = new ArrayList<>();

    static {
        for (int i = 1; i <= 20; i++) {
            items.add(new ViewModel("User:" + i, "http://www.voyager2511.top/temp_file/images/" + i + ".jpg"));//http://lorempixel.com/500/500/animals/
        }
    }

    private DrawerLayout drawerLayout;
    private View content;
    private RecyclerView recyclerView;
    private NavigationView navigationView;

    private ViewPager mViewPager;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private String[] title = {"Home","Found","Account","Mine"};
    //private MyFragmentPagerAdapter mAdapter;
    private List<ChangeIconColor> mTabIndicators = new ArrayList<ChangeIconColor>();

    private ActionBar actionBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        setupDrawerLayout();
        //initFab();


        //content = findViewById(R.id.content);

        //final ImageView avatar = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.avatar);
        //Picasso.with(this).load(AVATAR_URL).transform(new CircleTransform()).into(avatar);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            setRecyclerAdapter(recyclerView);
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Feeback Action", Snackbar.LENGTH_LONG)
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

        View headerView = navigationView.getHeaderView(0);
        ImageView circleView = (ImageView) headerView.findViewById(R.id.CircleImageView);

        if (RegisterPage.isShareLogin_success_flag() == true) {
            circleView.setImageURI(Uri.parse(RegisterPage.getUse_picturePath()));
        }

        circleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent login_intent = new Intent(getApplicationContext(), LoginActivity.class);
                //startActivity(login_intent);
                Intent login_intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivityForResult(login_intent, 1);
            }
        });


    }

    @Override
    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        setRecyclerAdapter(recyclerView);
        recyclerView.scheduleLayoutAnimation();
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
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
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


    private void setupDrawerLayout() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                Snackbar.make(content, menuItem.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });


    }


    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void setRecyclerAdapter(RecyclerView recyclerView) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(items);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
    }


    private void initFab() {
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(content, "FAB Clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(View view, ViewModel viewModel) {
        //Toast.makeText(MainActivity.this, "回调成功", Toast.LENGTH_SHORT).show();
        DetailActivity.navigate(this, view.findViewById(R.id.image), viewModel);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                Toast.makeText(MainActivity.this, "回调成功", Toast.LENGTH_SHORT).show();
                switch (requestCode) {
                    case RegisterPage.INTENT_USR_PICTURE:
                        Toast.makeText(MainActivity.this, "回调成功_2", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }


    }

    private void initView(){
        //mViewPager = (ViewPager)findViewById()
    }



}
