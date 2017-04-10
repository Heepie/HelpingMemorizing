package kr.co.heepie.helpingmemorizingapp.alarm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.icu.util.Calendar;
import android.os.IBinder;

import kr.co.heepie.helpingmemorizingapp.form.InputCardInfo;

/**
 * Created by Hee_Ju.M on 2017-04-04.
 */

public class AlarmHelper {
    // The context to start the service in
    private Context context;
    private RegisterService registerService;

    AlarmHelper(Context context) {this.context = context;}


    // RegisterService Start.
    public void startRegisterService() {
        Intent intent = new Intent(context, RegisterService.class);
        context.startService(intent);
    }

    // Alarm setting by using the RegisterService
    public void setAlarm(Calendar c) {
        registerService.setAlarm(c);
    }



}
