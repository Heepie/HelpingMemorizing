package kr.co.heepie.helpingmemorizingapp.alarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.icu.util.Calendar;
import android.os.IBinder;

/**
 * Created by Hee_Ju.M on 2017-04-04.
 */

public class AlarmHelper {
    // The context to start the service in
    private Context context;
    private RegisterService registerService;
    private boolean isBind = false;

    public AlarmHelper(Context context) {
        this.context = context;
    }

    public void doBindService() {
        context.bindService(new Intent(context, RegisterService.class), connection, Context.BIND_AUTO_CREATE);
        isBind = true;
    }


    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            registerService = ((RegisterService.ServiceBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            registerService = null;
        }
    };

    public void setAlarm(Calendar c) {

    }

    public void doUnbindService() {
        if (isBind) {
            // Detach our existing connection.
            context.unbindService(connection);
            isBind = false;
        }
    }


}
