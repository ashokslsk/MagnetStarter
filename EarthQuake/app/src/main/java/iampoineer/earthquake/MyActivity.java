package iampoineer.earthquake;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.exception.SchemaException;
import com.magnetapi.examples.controller.api.Earthquakes;
import com.magnetapi.examples.controller.api.EarthquakesFactory;
import com.magnetapi.examples.model.beans.EarthquakesResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;


public class MyActivity extends Activity {
    private Earthquakes earthquakes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(getApplicationContext());
        EarthquakesFactory controllerFactory = new EarthquakesFactory(magnetClient);
        try {
            earthquakes = controllerFactory.obtainInstance();
        } catch (SchemaException e) {
            e.printStackTrace();
        }

        String yyy = "2011";
        String mm = "03";
        String min_magnitude = "6";
        String limit = "500";

        Call<EarthquakesResult> callObject = earthquakes.getEarthquakes(
                yyy,
                mm,
                min_magnitude,
                limit, null);

        try {
            EarthquakesResult result = callObject.get();
            final ListView listview = (ListView) findViewById(R.id.list);

            MyCustomAdapter earthAdapter = new MyCustomAdapter(MyActivity.this,result.getEarthquakes());

            listview.setAdapter(earthAdapter);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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
