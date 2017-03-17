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

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

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

        RealmResults List = getList(new Folder());
        Log.i("Heepie", "# userList.size :  " + List.size()); // :0

        insertFolderData();

        Log.i("Heepie", "# userList.size :  " + List.size()); // :1
         usr = List.first();

        Log.i("Heepie", "# userName: " + usr.getName() + " userAge: " + usr.getAge());


        RealmResults<user> userList = getUserList();
        Log.i("Heepie", "# userList.size :  " + userList.size()); // :0

        insertuserData();

        Log.i("Heepie", "# userList.size :  " + userList.size()); // :1
        user usr = userList.first();

        Log.i("Heepie", "# userName: " + usr.getName() + " userAge: " + usr.getAge());

        deleteuserData();
    }

    private <T extends Component> RealmResults getList(T parm) {
        return mRealm.where(T.class).findAll();


    }


    private RealmResults<user> getUserList(){
        return mRealm.where(user.class).findAll();
    }

    private void insertFolderData() {
        mRealm.beginTransaction();
        Folder folder = mRealm.createObject(Folder.class);
        folder.setName("Test_01");
        folder.setDate("2017-03-16");
        folder.setDescription("This is the folder for a test.");
        folder.setColor("Green");
        mRealm.commitTransaction();
    }

    private void deleteData() {
        mRealm.beginTransaction();
        RealmResults<Component> List = mRealm.where(Component.class).findAll();
        List.deleteAllFromRealm();
        mRealm.commitTransaction();
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
