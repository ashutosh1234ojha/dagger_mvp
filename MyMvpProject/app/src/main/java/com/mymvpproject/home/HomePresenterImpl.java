package com.mymvpproject.home;

/**
 * Created by Ashutosh Ojha on 11/24/17.
 */

public class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;

    public HomePresenterImpl(HomeView homeView) {

        this.homeView = homeView;
    }

    @Override
    public void homeIsClicked() {

        homeView.openHomeFragment();
    }

    @Override
    public void userIsClicked() {
        homeView.openUserFragment();
    }
}
