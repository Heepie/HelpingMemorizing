package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.db.Card;
import kr.co.heepie.helpingmemorizingapp.db.Folder;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Realm mRealm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button checkBtn = (Button)findViewById(R.id.main_checkBtn);
        Button testBtn = (Button)findViewById(R.id.main_testBtn);
        Button crtFolderBtn = (Button)findViewById(R.id.main_crtFolderBtn);
        Button crtCardBtn = (Button)findViewById(R.id.main_crtCardBtn);

        checkBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "CheckBtn Clicked");

            }
        });

        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "TestBtn Clicked");
            }
        });

        crtFolderBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "crtFolderBtnBtn Clicked");
            }
        });

        crtCardBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie","crtCardBtnBtn Clicked");
            }
        });












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
*/
    }

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
}