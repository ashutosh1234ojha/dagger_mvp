package com.mymvpproject.dagger;

import com.mymvpproject.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ashutosh Ojha on 12/5/17.
 */
@Singleton
@Component(modules = {AppModule.class,LoginModule.class})
public interface AppComponent {
    void inject(LoginActivity target);
//    void inject(LoginPresenterImpl target);
}
