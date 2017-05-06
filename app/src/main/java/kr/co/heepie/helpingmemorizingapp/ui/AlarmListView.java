package kr.co.heepie.helpingmemorizingapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmListItem;

/**
 * Created by Heepie on 2017-05-01.
 */

public class AlarmListView extends LinearLayout {
    Context mContext;
    TextView textViewTime;
    Button deleteBtn;

    AlarmListItem item;
    private int position;

    public AlarmListView(Context context) {
        super(context);
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.alarm_list, this);
        textViewTime = (TextView)layout.findViewById(R.id.alarm_listItem);
        deleteBtn = (Button)findViewById(R.id.alarm_deleteBtn);

        deleteBtn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(clickListner != null)
                    clickListner.onClicked(position);
            }
        });
    }


    public interface onDeleteButtonClickListner {
        void onClicked(int position);
    }

    onDeleteButtonClickListner clickListner;

    public void setOnDeleteButtonClickListner (onDeleteButtonClickListner clickListner){
        this.clickListner = clickListner;
    }

    public boolean setAlarm(AlarmListItem item, int position){

        this.item = item;
        this.position = position;

        textViewTime.setText(item.getYear() + "." +
                             item.getMonth() + "." +
                             item.getDay() + "." +
                             item.getHour() + "." +
                             item.getMinute() + " " +
                             item.getReqCode());

        return true;
    }
}

