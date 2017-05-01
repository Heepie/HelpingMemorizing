package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import kr.co.heepie.helpingmemorizingapp.R;

/**
 * Created by Heepie on 2017-05-01.
 */

public class AddAlarm extends Activity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private int year, month, day, hour, minute;
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

        year = datePicker.getYear();
        month = datePicker.getMonth();
        day = datePicker.getDayOfMonth();

        hour = timePicker.getHour();
        minute = timePicker.getMinute();

        msg = year+" "+month+" "+day+" "+hour+" "+minute;

        Log.i("Heepie", msg);
        finish();
    }

    public void onClickBackBtn(View v) {
        finish();
    }
}
