package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import kr.co.heepie.helpingmemorizingapp.db.Card;
import kr.co.heepie.helpingmemorizingapp.db.Folder;
import kr.co.heepie.helpingmemorizingapp.form.InputCardInfo;
import kr.co.heepie.helpingmemorizingapp.form.InputFolderInfo;

/**
 * Created by Hee_Ju.M on 2017-03-21.
 *
 * Role: show data_input_form and data input, delete, search
 */

public class DBManager {
    private static DBManager instance;
    private static Realm mRealm;
    private Intent intent;
    private Context context;

    // Singleton
    // initialize the instance
    public static synchronized DBManager getInstance() {
        try {
            mRealm = Realm.getDefaultInstance();

        } catch (Exception e) {

            // Get a Realm instance for this thread
            RealmConfiguration config = new RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
            mRealm = Realm.getInstance(config);

        }

        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void showFolderInfoActivity() {
        intent = new Intent(context, InputFolderInfo.class);
        context.startActivity(intent);
//        activity.startActivityForResult(intent, REQUEST_FOLDERDATA);
//        startActivityForResult(intent, REQUEST_FOLDERDATA);
    }

    public void showCardInfoActivity() {
        intent = new Intent(context, InputCardInfo.class);
//        startActivity(intent);
//        startActivityForResult(intent, REQUEST_CARDDATA);
    }

    public void searchData() {}

    public void testActivity() {}

    public void insertFolderData(String name, String description, String color){
        mRealm.beginTransaction();

        Folder f = new Folder(name);
        f.setDescription(description);
        f.setColor(color);
        mRealm.insertOrUpdate(f);

        mRealm.commitTransaction();
    }

    public void insertCardData(String name, String concept, String description){
        mRealm.beginTransaction();

        Card c = new Card(name);
        c.setConcept(concept);
        c.setDescription(description);
        mRealm.insertOrUpdate(c);

        mRealm.commitTransaction();
    }

}