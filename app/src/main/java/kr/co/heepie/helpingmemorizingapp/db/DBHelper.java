package kr.co.heepie.helpingmemorizingapp.db;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Iterator;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import kr.co.heepie.helpingmemorizingapp.form.InputCardInfo;
import kr.co.heepie.helpingmemorizingapp.form.InputFolderInfo;

/**
 * Created by Hee_Ju.M on 2017-03-21.
 *
 * Role: show data_input_form and data input, delete, search
 */

public class DBHelper {
    private static DBHelper instance;
    private static Realm mRealm;
    private Intent intent;
    private Context context;

    private StringBuilder path = new StringBuilder("");

    // Singleton Pattern
    // initialize the instance
    public static synchronized DBHelper getInstance() {
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
            instance = new DBHelper();
        }
        return instance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void showFolderInfoActivity() {
        intent = new Intent(context, InputFolderInfo.class);
        context.startActivity(intent);
    }

    public void showCardInfoActivity() {
        intent = new Intent(context, InputCardInfo.class);
        context.startActivity(intent);
    }

    // Show Folder's Name hierarchically
    public Object[] searchAllFolderData() {

        // Get all folder info
        RealmResults<Component> result = mRealm.where(Component.class)
                                               .equalTo("componentType", "Folder")
                                               .findAll();

        // Print logs
        for (Component f:result) {
            Log.i("Heepie", f.getName() + " " + f.getDescription());
        }

        return result.toArray();
    }

    public void testActivity() {}

    public void insertFolderData(String name, String description){
        mRealm.beginTransaction();

        Component f = Component.ComponentBuilder
                               .startBuild()
                               .setType("Folder")
                               .setName(name)
                               .setDescription(description)
                               .finishBuild();

        mRealm.insertOrUpdate(f);
        mRealm.commitTransaction();
    }

    public void insertCardData(String name, String description){
        mRealm.beginTransaction();

        Component c = Component.ComponentBuilder
                               .startBuild()
                               .setType("Card")
                               .setName(name)
                               .setDescription(description)
                               .finishBuild();

        mRealm.insertOrUpdate(c);
        mRealm.commitTransaction();
    }


    public static void fullScan(Component component) {
        Log.i("Heepie", component.getClass() + "|" + component.getName());
        if (component.getComponentType() == "Folder") {
            for(Component i:component.getList()) {
                fullScan(i);
            }
        }
    }

}