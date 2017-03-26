package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.util.Log;

import io.realm.Realm;
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

public class DBManager extends Activity {
    static final int REQUEST_FOLDERDATA = 1;
    static final int REQUEST_CARDDATA = 2;
    private Realm mRealm;
    private Intent intent;
    private Context context;
    private Activity activity;

    DBManager(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
    }

    public void showFolderInfoActivity() {
        intent = new Intent(context, InputFolderInfo.class);
//        context.startActivity(intent);
        activity.startActivityForResult(intent, REQUEST_FOLDERDATA);

//        startActivityForResult(intent, REQUEST_FOLDERDATA);
    }

    public void showCardInfoActivity() {
        intent = new Intent(context, InputCardInfo.class);
//        startActivity(intent);
//        startActivityForResult(intent, REQUEST_CARDDATA);
    }

    public void searchData() {}

    public void testActivity() {}

    private void insertFolderData(String name, String description, String color){
        mRealm.beginTransaction();

        Folder f = new Folder(name);
        f.setDescription(description);
        f.setColor(color);
        mRealm.insertOrUpdate(f);

        mRealm.commitTransaction();
    }

    private void insertCardData(String name, String concept, String description){
        mRealm.beginTransaction();

        Card c = new Card(name);
        c.setConcept(concept);
        c.setDescription(description);
        mRealm.insertOrUpdate(c);

        mRealm.commitTransaction();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("Heepie", "onActivity OK!");
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
            case REQUEST_FOLDERDATA:
//                insertFolderData(data.getStringExtra("name"),
//                                 data.getStringExtra("description"),
//                                 data.getStringExtra("color"));
                Log.i("Heepie", "Result OK!");
            case REQUEST_CARDDATA:


            }
        }
    }

/*
         * To check DB
         */
        /*
        try{
            mRealm = Realm.getDefaultInstance();

        }catch (Exception e){

            // Get a Realm instance for this thread
            RealmConfiguration config = new RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
            mRealm = Realm.getInstance(config);

        }

        Folder f = new Folder("Root");
        f.setDescription("This is the Root Folder");
        f.add(new Card("Design Pattern"));
        f.add(new Card("Codeton"));

        Set<Card> set = f.getSet();
        Iterator<Card> iter = set.iterator();

        while(iter.hasNext()) {
            Card c = iter.next();
            Log.i("Heepie", "Folder: " + f.getName() + "Card: " + c.getName());

        }

        RealmResults<Folder> folderList = getFolderList();
        RealmResults<Card> cardList = getCardList();

        Log.i("Heepie", "FolderList Size: " + folderList.size() + "  CardList Size: " + cardList.size());

        insertFolderData("Root", "This is Root Folder");
        insertCardData("Design Pattern", "Singleton Pattern", "This is the pattern to make only one instance");

        Log.i("Heepie", "FolderList Size: " + folderList.size() + "  CardList Size: " + cardList.size());

        Log.i("Heepie", "Folder Name: " + folderList.where().findFirst().getName() + "  CardList Size: " + folderList.where().findFirst().getDescription());



    private RealmResults<Folder> getFolderList() {
        return mRealm.where(Folder.class).findAll();
    }

    private RealmResults<Card> getCardList() {
        return mRealm.where(Card.class).findAll();
    }


    private void insertFolderData(String name, String description){
        mRealm.beginTransaction();
        Folder f = mRealm.createObject(Folder.class);
        f.setName(name);
        f.setDescription(description);
        mRealm.commitTransaction();
    }

    private void insertCardData(String name, String concept, String description){
        mRealm.beginTransaction();
        Card c = mRealm.createObject(Card.class);
        c.setName(name);
        c.setConcept(concept);
        c.setDescription(description);
        mRealm.commitTransaction();
    }
    */
}