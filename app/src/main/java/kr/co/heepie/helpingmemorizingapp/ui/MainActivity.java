package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.db.user;
import kr.co.heepie.helpingmemorizingapp.frame.Component;
import kr.co.heepie.helpingmemorizingapp.frame.Folder;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            mRealm = Realm.getDefaultInstance();

        }catch (Exception e){

            // Get a Realm instance for this thread
            RealmConfiguration config = new RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
            mRealm = Realm.getInstance(config);

        }
        init();
    }

    private void init(){

        RealmResults<Component> List = getComponentList();



        RealmResults<user> userList = getUserList();
        Log.i("Heepie", "# userList.size :  " + userList.size()); // :0

        insertuserData();

        Log.i("Heepie", "# userList.size :  " + userList.size()); // :1
        user usr = userList.first();

        Log.i("Heepie", "# userName: " + usr.getName() + " userAge: " + usr.getAge());

        deleteuserData();
    }

    private RealmResults<Component> getComponentList() {
        return mRealm.where(Component.class).findAll();
    }


    private RealmResults<user> getUserList(){
        return mRealm.where(user.class).findAll();
    }

    private void insertComponentData() {
        mRealm.beginTransaction();
        Component component = mRealm.createObject(Folder.class);
        

    }


    private void insertuserData(){

        mRealm.beginTransaction();
        user usr = mRealm.createObject(user.class);
        usr.setName("Heepie");
        usr.setAge(28);
        mRealm.commitTransaction();
    }

    private void deleteuserData(){

        mRealm.beginTransaction();
        RealmResults<user> userList = mRealm.where(user.class).findAll();
        userList.deleteAllFromRealm();
        mRealm.commitTransaction();
    }
}
