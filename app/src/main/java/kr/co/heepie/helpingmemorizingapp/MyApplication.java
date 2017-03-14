package kr.co.heepie.helpingmemorizingapp;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Hee_Ju.M on 2017-03-14.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
