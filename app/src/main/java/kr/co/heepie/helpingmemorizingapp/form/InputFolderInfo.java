package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.ui.DBManager;
import kr.co.heepie.helpingmemorizingapp.ui.MainActivity;

/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputFolderInfo extends Activity{
    private DBManager dbManager = DBManager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folderinfo2);

        /*
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.getInfoFragment1, new Fragment1());
        fragmentTransaction.add(R.id.getInfoFragment2, new Fragment1());
//        fragmentTransaction.replace(R.id.getInfoFragment1, new Fragment1());
//        fragmentTransaction.replace(R.id.getInfoFragment2, new Fragment2());
        fragmentTransaction.commit();
*/
/*
















        final TextView name = (TextView)findViewById(R.id.input_folderName);
        final TextView description = (TextView)findViewById(R.id.input_folderDescription);
        final TextView color = (TextView)findViewById(R.id.input_folderColor);
        final Intent intent = new Intent();


        Button btn = (Button)findViewById(R.id.input_folderInfo);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "name: " + name.getText() + "description: " + description.getText() + "color: " + color.getText());
                if (name.getText() != "" && description.getText() != "" && color.getText() != "") {
                    dbManager.insertFolderData(name.getText().toString(), description.getText().toString(), color.getText().toString());

//                    intent.putExtra("name", (String)name.getText())
//                            .putExtra("description", (String)description.getText())
//                            .putExtra("color", (String)color.getText());
//                    setResult(RESULT_OK, intent);
                } else
                    setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
        */
    }
}
