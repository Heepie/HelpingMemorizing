package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmListAdapter;

/**
 * Created by Heepie on 2017-05-01.
 */

public class AddAlarm extends Activity {
    public static final int DEFAULT_ALARM_REQUEST = 800;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private int year, month, day, hour, minute, reqCode;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_alarm);

        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClickSelectBtn(View v) {

        // Have to change each int var to item class
        year = datePicker.getYear();
        month = datePicker.getMonth();
        day = datePicker.getDayOfMonth();

        hour = timePicker.getHour();
        minute = timePicker.getMinute();

        msg = year+" "+month+" "+day+" "+hour+" "+minute;

        Intent intent = new Intent();
        intent.putExtra("Year", year);
        intent.putExtra("Month", month);
        intent.putExtra("Day", day);
        intent.putExtra("Hour", hour);
        intent.putExtra("Minute", minute);

        setResult(RESULT_OK, intent);
        //----


        Log.i("Heepie", msg);
        finish();
    }

    public void onClickBackBtn(View v) {
        finish();
    }
}
