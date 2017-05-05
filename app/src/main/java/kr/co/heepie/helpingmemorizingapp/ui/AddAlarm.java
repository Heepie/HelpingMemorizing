package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmListItem;

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
        AlarmListItem item = new AlarmListItem.ItemBuilder()
                                              .startBuild()
                                              .setYear(datePicker.getYear())
                                              .setMonth(datePicker.getMonth())
                                              .setDay(datePicker.getDayOfMonth())
                                              .setHour(timePicker.getHour())
                                              .setMinute(timePicker.getMinute())
                                              .finishBuild();

        Intent intent = new Intent();
        intent.putExtra("item", item);
        setResult(RESULT_OK, intent);

        finish();
    }

    public void onClickBackBtn(View v) {
        finish();
    }
}
