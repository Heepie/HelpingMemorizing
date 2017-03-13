package kr.co.heepie.helpingmemorizingapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;
import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.db.user;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    private void init(){

        mRealm = Realm.getDefaultInstance();

        RealmResults<user> userList = getUserList();
        Log.i("log1", ">>>>>   userList.size :  " + userList.size()); // :0

        //유저 정보 데이터 DB 저장
        insertuserData();

        Log.i("log1", ">>>>>   userList.size :  " + userList.size()); // :1

    }


    private RealmResults<user> getUserList(){
        return mRealm.where(user.class).findAll();
    }


    private void insertuserData(){

        mRealm.beginTransaction();
        user user = mRealm.createObject(user.class);
        user.setName("Heepie");
        user.setAge(28);
        mRealm.commitTransaction();
    }
}
