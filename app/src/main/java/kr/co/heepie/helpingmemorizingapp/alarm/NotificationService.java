package kr.co.heepie.helpingmemorizingapp.alarm;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import kr.co.heepie.helpingmemorizingapp.form.DetialCardInfo;

/**
 * Created by Hee_Ju.M on 2017-04-04.
 */

public class NotificationService extends Service {
    Notification notifi;

    /**
     * Class for clients to access
     */
    public class ServiceBinder extends Binder {
        NotificationService getService() {
            return NotificationService.this;
        }
    }

    // Unique id to identify the notification.
    private static final int NOTIFICATION = 123;
    // Name of an intent extra we can use to identify if this service was started to create a notification
    public static final String INTENT_NOTIFY = "Heepie";
    // The system notification manager
    private NotificationManager mNM;

    @Override
    public void onCreate() {
        Log.i("NotifyService", "onCreate()");
        mNM = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }


    // Start notification directly
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        // If this service was started by out AlarmTask intent then we want to show our notification
        if(intent.getBooleanExtra(INTENT_NOTIFY, false))
            showNotification();

        // We don't care if this service is stopped as we have already delivered our notification
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    // This is the object that receives interactions from clients
    private final IBinder mBinder = new ServiceBinder();

    /**
     * Creates a notification and shows it in the OS drag-down status bar
     */
    private void showNotification() {
        Intent intent = new Intent(NotificationService.this, DetialCardInfo.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationService.this, 0, intent,PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            notifi = new Notification.Builder(getApplicationContext())
                    .setContentTitle("Content Title")
                    .setContentText("Content Text")
                    .setSmallIcon(R.mipmap.sym_def_app_icon)
                    .setTicker("알림!!!")
                    .setContentIntent(pendingIntent)
                    .build();
        }

        //Set sound
        notifi.defaults = Notification.DEFAULT_SOUND;

        notifi.flags = Notification.FLAG_ONLY_ALERT_ONCE;

        notifi.flags = Notification.FLAG_AUTO_CANCEL;
        long time = System.currentTimeMillis();

        // Send the notification to the system.
        mNM.notify(NOTIFICATION, notifi);

        // Stop the service when we are finished
        stopSelf();
    }
}

