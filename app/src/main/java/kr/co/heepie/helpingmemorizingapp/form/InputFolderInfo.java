package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.db.DBManager;

/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputFolderInfo extends Activity{
    private static final String TAG = InputFolderInfo.class.getSimpleName();
    private DBManager dbManager = DBManager.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folderinfo);
//        setContentView(R.layout.activity_folderinfo2);



//        Button btn = (Button)findViewById(R.id.createFolder);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment1 fragment1 = (Fragment1)getFragmentManager().findFragmentById(R.id.getInfoFragment1);
//                dbManager.insertFolderData(fragment1.getFolderName(), fragment1.getDescription(), null);
//
//                finish();
//            }
//        });


/*
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.getInfoFragment1, new Fragment1());
        fragmentTransaction.add(R.id.getInfoFragment2, new Fragment1());
//        fragmentTransaction.replace(R.id.getInfoFragment1, new Fragment1());
//        fragmentTransaction.replace(R.id.getInfoFragment2, new Fragment2());
        fragmentTransaction.commit();
*/

        final TextView name = (TextView)findViewById(R.id.input_folderName);
        final TextView description = (TextView)findViewById(R.id.input_folderDescription);
        final TextView upperFolder = (TextView)findViewById(R.id.input_upperFolder);

        Button btn = (Button)findViewById(R.id.input_folderInfo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "name: " + name.getText() + "description: " + description.getText() + "color: " + upperFolder.getText());
                if (name.getText() != "" && description.getText() != "" && upperFolder.getText() != "") {
                    dbManager.insertFolderData(name.getText().toString(), description.getText().toString(), upperFolder.getText().toString());

//                    intent.putExtra("name", (String)name.getText())
//                            .putExtra("description", (String)description.getText())
//                            .putExtra("color", (String)color.getText());
//                    setResult(RESULT_OK, intent);

                } else {
                    Log.i("Heepie", "Input Error");
                }
                finish();
            }
        });
    }
}
