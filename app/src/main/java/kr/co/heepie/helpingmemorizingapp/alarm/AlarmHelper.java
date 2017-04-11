package kr.co.heepie.helpingmemorizingapp.alarm;

import android.content.Context;
import android.content.Intent;
import java.util.Calendar;

/**
 * Created by Hee_Ju.M on 2017-04-04.
 */

public class AlarmHelper {
    private static AlarmHelper instance;
    // The context to start the service in
    private Context context;
    private RegisterService registerService;

    public static synchronized AlarmHelper getInstance() {
        if (instance == null) {
            instance = new AlarmHelper();
        }
        return instance;
    }

    // Singleton
    // initialize the instance

    public void setContext(Context context) {this.context = context;}


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
