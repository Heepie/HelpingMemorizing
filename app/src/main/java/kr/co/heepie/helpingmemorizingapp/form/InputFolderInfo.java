package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.heepie.helpingmemorizingapp.R;

/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputFolderInfo extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folderinfo);

        final TextView name = (TextView)findViewById(R.id.input_folderName);
        final TextView description = (TextView)findViewById(R.id.input_folderDescription);
        final TextView color = (TextView)findViewById(R.id.input_folderColor);
        final Intent intent = getIntent();


        Button btn = (Button)findViewById(R.id.input_folderInfo);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Heepie", "name: " + name.getText() + "description: " + description.getText() + "color: " + color.getText());
                intent.putExtra("name", (String)name.getText())
                      .putExtra("description", (String)description.getText())
                      .putExtra("color", (String)color.getText());
            }
        });

    }
}
