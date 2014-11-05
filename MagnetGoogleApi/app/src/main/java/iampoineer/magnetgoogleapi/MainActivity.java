package iampoineer.magnetgoogleapi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.async.StateChangedListener;
import com.magnet.android.mms.exception.SchemaException;

import com.magnetapi.examples.controller.api.GoogleTimeZone;
import com.magnetapi.examples.controller.api.GoogleTimeZoneFactory;
import com.magnetapi.examples.model.beans.TimeZoneResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {
    private GoogleTimeZone timeZoneResult;
    public TextView t1,t2,t3,t4,t5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView)findViewById(R.id.timeid);
        t2 = (TextView)findViewById(R.id.timelocation);
        t3 = (TextView)findViewById(R.id.status);
        t4 = (TextView)findViewById(R.id.nec1);
        t5 = (TextView)findViewById(R.id.nec2);


        MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(getApplicationContext());
        GoogleTimeZoneFactory controllerFactory = new GoogleTimeZoneFactory(magnetClient);
        try {
            timeZoneResult = controllerFactory.obtainInstance();
        } catch (SchemaException e) {
            e.printStackTrace();
        }


        String location="39.6034810,-119.6822510";
        String timestamp="1331766000";
        String sensor=null;

        Call<TimeZoneResult> callobject = timeZoneResult.getTimeZone(location, timestamp, sensor, null);

        try{
            TimeZoneResult result = callobject.get();
            t1.setText(result.getTimeZoneName().toString());
            t2.setText(result.getTimeZoneId().toString());
            t3.setText(result.getDstOffset().toString());
            t4.setText(result.getStatus().toString());
            t5.setText(result.getRawOffset().toString());


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
