package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.db.DBHelper;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private DBHelper dbManager = DBHelper.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // For calling activities in non-activity class
        dbManager.setContext(this);

        Button checkBtn = (Button) findViewById(R.id.main_checkBtn);
        Button testBtn = (Button) findViewById(R.id.main_testBtn);
        Button crtFolderBtn = (Button) findViewById(R.id.main_crtFolderBtn);
        Button crtCardBtn = (Button) findViewById(R.id.main_crtCardBtn);


        checkBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", TAG + "CheckBtn Clicked");
                dbManager.searchData();
            }
        });

        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", TAG + "TestBtn Clicked");
                dbManager.testActivity();
            }
        });

        crtFolderBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", TAG + "crtFolderBtnBtn Clicked");
                dbManager.showFolderInfoActivity();
            }
        });

        crtCardBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", TAG + "crtCardBtnBtn Clicked");
                dbManager.showCardInfoActivity();
            }
        });
    }
}