package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import kr.co.heepie.helpingmemorizingapp.R;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    DBManager dbManager = new DBManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button checkBtn = (Button) findViewById(R.id.main_checkBtn);
        Button testBtn = (Button) findViewById(R.id.main_testBtn);
        Button crtFolderBtn = (Button) findViewById(R.id.main_crtFolderBtn);
        Button crtCardBtn = (Button) findViewById(R.id.main_crtCardBtn);

        checkBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "CheckBtn Clicked");
                dbManager.searchData();
            }
        });

        testBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "TestBtn Clicked");
                dbManager.testActivity();
            }
        });

        crtFolderBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "crtFolderBtnBtn Clicked");
                dbManager.showFolderInfoActivity();
            }
        });

        crtCardBtn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "crtCardBtnBtn Clicked");
                dbManager.showCardInfoActivity();
            }
        });
    }
}