package kr.co.heepie.helpingmemorizingapp.alarm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import kr.co.heepie.helpingmemorizingapp.ui.AlarmListView;

/**
 * Created by Hee_Ju.M on 2017-05-03.
 */

public class AlarmListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<AlarmListItem> alarmList;

    public AlarmListAdapter(Context mContext, ArrayList<AlarmListItem> alarmList) {
        this.mContext = mContext;
        this.alarmList = alarmList;
    }

    @Override
    public int getCount() {
        return alarmList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return alarmList.get(position).getReqCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlarmListView alarmListView = (AlarmListView)convertView;

        // Complete null exception through this code
        if (alarmListView == null) {
            alarmListView = new AlarmListView(mContext);
            alarmListView.setOnDeleteButtonClickListner(deleteButtonClickListner);
        }
        // ---

        alarmListView.setAlarm(alarmList.get(position), position);
        return alarmListView;
    }

    public boolean deleteItem(int position) {
        alarmList.remove(position);
        notifyDataSetChanged();
        return true;
    }

    AlarmListView.onDeleteButtonClickListner deleteButtonClickListner = new AlarmListView.onDeleteButtonClickListner() {
        @Override
        public void onClicked(int position) {
            deleteItem(position);
        }
    };
}
