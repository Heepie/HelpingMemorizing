package kr.co.heepie.helpingmemorizingapp.alarm;

import android.app.Service;
import android.content.Intent;
import java.util.Calendar;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Hee_Ju.M on 2017-04-04.
 */

public class RegisterService extends Service {
    private final IBinder binder = new ServiceBinder();


    public class ServiceBinder extends Binder {
        RegisterService getService() {
            return RegisterService.this;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public void setAlarm(Calendar c) {
        // Set Alarm by using the thread.
        new SetAlarm(this, c).run();
    }
}
