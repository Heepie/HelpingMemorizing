package kr.co.heepie.helpingmemorizingapp.ui;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.util.Log;

import kr.co.heepie.helpingmemorizingapp.R;
import kr.co.heepie.helpingmemorizingapp.form.InputFolderInfo;

import static android.app.AlarmManager.ELAPSED_REALTIME_WAKEUP;
import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Hee_Ju.M on 2017-03-29.
 * This is the class to handle alarms.
 */

public class AlarmHelper extends BroadcastReceiver {
    // System Side
    private static final String TAG = AlarmHelper.class.getSimpleName();

    private static AlarmHelper instance;
    private Context context;
    private AlarmManager manager;
    private Intent receiverIntent;

    private AlarmHelper() { }

    // Singleton
    // initialize the instance
    public static synchronized AlarmHelper getInstance() {
        if (instance == null) {
            instance = new AlarmHelper();
        }
        return instance;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    // Register Alarm in the system.
    public void registerAlarm() {
        manager = (AlarmManager)context.getSystemService(ALARM_SERVICE);

        receiverIntent = new Intent(context, this.getClass());
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, receiverIntent, 0);

        long period = 1000 * 5;
        long after = 1000 * 5;
        long t = SystemClock.elapsedRealtime();

        manager.setRepeating(ELAPSED_REALTIME_WAKEUP, t + after, period, pendingIntent);
        Log.i(TAG, "register OK");

    }






    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification.Builder mBuilder = new Notification.Builder(context);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mBuilder.setTicker("hi");
        mBuilder.setContentTitle("hi1");
        mBuilder.setContentText("hi3");

        mBuilder.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
        //mBuilder.setContentIntent(pendingIntent);
        mBuilder.setAutoCancel(true);

        nm.notify(111, mBuilder.build());
        Log.i(TAG, "Receive OK");
    }
}
