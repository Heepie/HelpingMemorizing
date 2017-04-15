package kr.co.heepie.helpingmemorizingapp.alarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

import java.util.Calendar;

import kr.co.heepie.helpingmemorizingapp.ui.MainActivity;

/**
 * Created by Hee_Ju.M on 2017-04-04.
 */

public class AlarmHelper {
    // The instance for Singleton
    private static AlarmHelper instance;

    // The hook into alarm register service
    private RegisterService registerService;

    // The context to start the service in
    private Context context;

    // Singleton Pattern
    // initialize the instance
    public static synchronized AlarmHelper getInstance() {
        if (instance == null) {
            instance = new AlarmHelper();
        }
        return instance;
    }

    public void setContext(Context context) {this.context = context;}

    // RegisterService Start.
    public void startRegisterService() {
        context.bindService(new Intent(context, RegisterService.class), mConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // This is called when the connection with our service has been established,
            // giving us the service object we can use to interact with our service.
            registerService = ((RegisterService.ServiceBinder) service).getService();
        }

        public void onServiceDisconnected(ComponentName className) {
            registerService = null;
        }
    };

    // Alarm setting by using the RegisterService
    public void setAlarm(Calendar c) {
        Log.i("Heepie", "AlarmHelper: " + c.toString());
        registerService.setAlarm(c);
    }

}
