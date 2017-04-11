package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmHelper;


/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputCardInfo extends Activity{
    private TextView name, description;
    private DatePicker picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardinfo);

        name = (TextView)findViewById(R.id.input_CardName);
        description = (TextView)findViewById(R.id.input_CardDescription);
        picker = (DatePicker) findViewById(R.id.scheduleTimePicker);

//        final TextView upperFolder = (TextView)findViewById(R.id.input_upperFolder);

    }

    public void setOnClick(View v) {
        AlarmHelper alarmHelper = AlarmHelper.getInstance();
        alarmHelper.setContext(this);

        int year, month, day;


        // BackgroundService Start
        alarmHelper.startRegisterService();

        year = picker.getYear();
        month = picker.getMonth();
        day = picker.getDayOfMonth();

        Calendar c = Calendar.getInstance();
        c.set(year, month, day);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        Log.i("Heepie", "InputCardInfo" + c.toString());

        // Register Alarm 6 times.
        alarmHelper.setAlarm(c);

    }
}