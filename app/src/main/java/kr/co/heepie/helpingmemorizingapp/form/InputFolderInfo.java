package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.db.DBHelper;

/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputFolderInfo extends Activity{
    private DBHelper dbHelper = DBHelper.getInstance();
    private TextView name, description, upperFolder;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folderinfo);

        name = (TextView)findViewById(R.id.input_folderName);
        description = (TextView)findViewById(R.id.input_folderDescription);
        upperFolder = (TextView)findViewById(R.id.input_upperFolder);
        spinner = (Spinner) findViewById(R.id.select_folderSpinner);

//        dbHelper.searchAllFolderData();
//        Object[] str = dbHelper.searchAllFolderData();
//        ArrayAdapter<Object> list = new ArrayAdapter<Object> (this, R.layout.support_simple_spinner_dropdown_item, str);
//        spinner.setAdapter(list);
    }

    public void onClickFolderCreate(View v) {
        if (name.getText() != "" && description.getText() != "" && upperFolder.getText() != "") {
            dbHelper.insertFolderData(name.getText().toString(), description.getText().toString(), upperFolder.getText().toString());
            finish();
        } else {
            Toast.makeText(this, "Fill all", Toast.LENGTH_LONG);
        }
    }
}
