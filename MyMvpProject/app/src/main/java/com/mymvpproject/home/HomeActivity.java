package com.mymvpproject.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mymvpproject.R;
import com.mymvpproject.home.landing.LandingFragment;
import com.mymvpproject.home.user.UserFragment;

/**
 * Created by cl-macmini-86 on 10/14/17.
 */

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, HomeView {

    private DrawerLayout drawer_layout;
    private TextView tvHome, tvNewRequest;
    private RelativeLayout rlMenu;
    private HomePresenter homePresenter;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    }

    private void init() {

        rlMenu = (RelativeLayout) findViewById(R.id.rlMenu);
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvNewRequest = (TextView) findViewById(R.id.tvNewRequest);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        homePresenter = new HomePresenterImpl(this);


        tvNewRequest.setOnClickListener(this);
        tvHome.setOnClickListener(this);
        rlMenu.setOnClickListener(this);
        drawerToggleListener();

    }

    @Override
    public void onClick(final View view) {

        switch (view.getId()) {
            case R.id.rlMenu:
                drawer_layout.openDrawer(Gravity.START);
                break;

            case R.id.tvHome:
                drawer_layout.closeDrawer(Gravity.START);
                homePresenter.homeIsClicked();

                break;

            case R.id.tvNewRequest:
                drawer_layout.closeDrawer(Gravity.START);
                homePresenter.userIsClicked();

                break;
        }
    }

    /**
     * Close keyboard when drawer open
     */
    private void drawerToggleListener() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer_layout
                , R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(final View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(final View drawerView) {
                super.onDrawerOpened(drawerView);
//                KeyboardUtil.hideKeyboard(HomeActivity.this);
            }
        };

        drawer_layout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void openHomeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, new LandingFragment()).commit();
    }

    @Override
    public void openUserFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, new UserFragment()).commit();
    }
}
