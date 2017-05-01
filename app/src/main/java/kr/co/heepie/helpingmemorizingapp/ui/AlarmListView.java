package kr.co.heepie.helpingmemorizingapp.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.alarm.AlarmListItem;

/**
 * Created by Heepie on 2017-05-01.
 */

public class AlarmListView extends LinearLayout {
    Context mContext;
    TextView textViewTime;
    Button btnSingleAlarmItemCancel;

    AlarmListItem item;
    private int position;

    public AlarmListView(Context context) {
        super(context);
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.alarm_list, this);
        textViewTime = (TextView)layout.findViewById(R.id.alarm_listItem);
        btnSingleAlarmItemCancel = (Button)findViewById(R.id.alarm_deleteBtn);

        btnSingleAlarmItemCancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(onRemoveButtonClickListner != null)
                    onRemoveButtonClickListner.onClicked(item.hh, item.mm, item.reqCode, position);
            }
        });
    }


    public interface OnRemoveButtonClickListner{
        void onClicked(int hh, int mm, int reqCode, int position);
    }

    OnRemoveButtonClickListner onRemoveButtonClickListner;

    public void setOnRemoveButtonClickListner(OnRemoveButtonClickListner onRemoveButtonClickListner){
        this.onRemoveButtonClickListner = onRemoveButtonClickListner;
    }

    public boolean setData(AlarmListItem item, int position){

        this.item = item;
        this.position = position;

        textViewTime.setText(item.hh+":"+item.mm +" and requestCode : "+item.reqCode);

        return true;
    }

}