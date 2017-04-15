package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmHelper;
import kr.co.heepie.helpingmemorizingapp.db.DBHelper;


/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputCardInfo extends Activity{
    private DBHelper dbManager = DBHelper.getInstance();
    private AlarmHelper alarmHelper;
    private TextView name, description;
    private DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardinfo);

        // Get AlarmHelper instance and set context
        alarmHelper = AlarmHelper.getInstance();
        Log.i("Heepie", alarmHelper.toString());
        alarmHelper.setContext(this);
        alarmHelper.startRegisterService();

        name = (TextView)findViewById(R.id.input_CardName);
        description = (TextView)findViewById(R.id.input_CardDescription);
        picker = (DatePicker) findViewById(R.id.scheduleTimePicker);

//        final TextView upperFolder = (TextView)findViewById(R.id.input_upperFolder);

    }

    public void onClickCardCreate(View v) {
        if (name.getText() != "" && description.getText() != "") {
            dbManager.insertCardData(name.getText().toString(), description.getText().toString(), "N");
        } else {
            Toast.makeText(this, "Fill all", Toast.LENGTH_LONG);
        }


        int year = picker.getYear();
        int month = picker.getMonth();;
        int day = picker.getDayOfMonth();;

        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 19);
        c.set(Calendar.SECOND, 30);

        Log.i("Heepie", "InputCardInfo" + c.toString());

        // Register Alarm 6 times.
        alarmHelper.setAlarm(c);
    }
}