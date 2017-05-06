package kr.co.heepie.helpingmemorizingapp.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmHelper;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmListAdapter;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmListItem;
import kr.co.heepie.helpingmemorizingapp.db.DBHelper;
import kr.co.heepie.helpingmemorizingapp.ui.AddAlarm;


/**
 * Created by Hee_Ju.M on 2017-03-21.
 */

public class InputCardInfo extends Activity{
    private static final int REQUEST_ADDALRM = 1000;
    private DBHelper dbHelper = DBHelper.getInstance();
    private AlarmHelper alarmHelper;
    private TextView name, description;
    private DatePicker picker;
    private ListView alarmListView;

    // Set Alarm var
    ArrayList<AlarmListItem> alarmList = new ArrayList<AlarmListItem>();
    AlarmListAdapter alarmListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardinfo2);

        // Get AlarmHelper instance and set context
        alarmHelper = AlarmHelper.getInstance();
        Log.i("Heepie", alarmHelper.toString());
        alarmHelper.setContext(this);
        alarmHelper.startRegisterService();

        // Set Alarm List view
        alarmListAdapter = new AlarmListAdapter(getApplicationContext(), alarmList);
        alarmListView = (ListView) findViewById(R.id.listViewAlarm);
        alarmListView.setAdapter(alarmListAdapter);

        name = (TextView)findViewById(R.id.input_CardName);
        description = (TextView)findViewById(R.id.input_CardDescription);
    }

    public void onClickCardCreate(View v) {
        if (name.getText() != "" && description.getText() != "") {
//            dbHelper.insertCardData(name.getText().toString(), description.getText().toString(), "N");
        } else {
            Toast.makeText(this, "Fill all", Toast.LENGTH_LONG);
        }

        Calendar c = Calendar.getInstance();
        for (AlarmListItem item : alarmList) {
            c.set(item.getYear(), item.getMonth(), item.getDay(), item.getHour(), item.getMinute());
            Toast.makeText(this, item.toString(), Toast.LENGTH_LONG).show();
            alarmHelper.setAlarm(c);
        }

        finish();
    }

    public void onClickAddAlrm(View v) {
        Intent intent = new Intent(this, AddAlarm.class);
//        startActivity(intent);
        startActivityForResult(intent, REQUEST_ADDALRM);
    }

    public void onClickDeleteBtn(View v) {
        Toast.makeText(this, "Clicked Delete Btn.", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String tmp = "";

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
            case REQUEST_ADDALRM:
                AlarmListItem item = data.getParcelableExtra("item");
                alarmList.add(item);
                alarmListAdapter.notifyDataSetChanged();
                break;
            default:
                break;
            }
        }
    }
}