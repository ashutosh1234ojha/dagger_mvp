package com.mymvpproject;

import android.app.Application;
import android.content.Context;

import com.mymvpproject.dagger.AppComponent;
import com.mymvpproject.dagger.AppModule;
import com.mymvpproject.dagger.DaggerAppComponent;

import io.paperdb.Paper;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public class MyApplication extends Application {

    private static MyApplication myApplication;
    private AppComponent appComponent;

    /**
     * @return instance of MyApplication
     */
    public static MyApplication getApplication() {
        return myApplication;
    }

    /**
     * Getter to access Singleton instance
     *
     * @return instance of MyApplication
     */
    public static Context getAppContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
        Paper.init(this);
//        Foreground.init(this);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/SanFranciscoDisplay-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        appComponent = initDagger(this);
        // Setup singleton instance
        myApplication = this;

//        //leak canary
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            return;
//        }
//        LeakCanary.install(this);
//        // Normal app init code...

//        try {
//            PackageInfo info = getPackageManager().getPackageInfo("com.Act2ImpactFund", PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.v("HashKey", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(MyApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
