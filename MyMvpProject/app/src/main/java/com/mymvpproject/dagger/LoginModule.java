package com.mymvpproject.dagger;

import com.mymvpproject.login.LoginInteractor;
import com.mymvpproject.login.LoginInteractorImpl;
import com.mymvpproject.login.LoginPresenter;
import com.mymvpproject.login.LoginPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ashutosh Ojha on 12/8/17.
 */
@Module
public class LoginModule {
    @Provides
    @Singleton
    LoginInteractor provideLoginInteractor( ){
        return new LoginInteractorImpl();
    }

    @Provides
    @Singleton
    LoginPresenter provideLoginPresenter(LoginInteractor loginInteractor){
        return new LoginPresenterImpl(loginInteractor);
    }
}
