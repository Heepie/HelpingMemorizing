package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmHelper;


/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputCardInfo extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardinfo);

        final AlarmHelper alarmHelper = AlarmHelper.getInstance();
        alarmHelper.setContext(this);

        Button btn = (Button)findViewById(R.id.input_cardInfo);
        final TextView name = (TextView)findViewById(R.id.input_CardName);
        final TextView description = (TextView)findViewById(R.id.input_CardDescription);
//        final TextView upperFolder = (TextView)findViewById(R.id.input_upperFolder);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // BackgroundService Start
                alarmHelper.startRegisterService();

                // Register Alarm 6 times.

            }
        });


    }
}