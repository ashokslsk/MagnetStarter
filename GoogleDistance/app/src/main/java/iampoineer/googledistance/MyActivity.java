package iampoineer.googledistance;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.exception.SchemaException;

import java.util.concurrent.ExecutionException;

import iampoineer.googledistance.controller.api.GoogleDistance;
import iampoineer.googledistance.controller.api.GoogleDistanceFactory;
import iampoineer.googledistance.model.beans.DistanceResult;


public class MyActivity extends Activity {
    private GoogleDistance googleDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(getApplicationContext());
        GoogleDistanceFactory controllerFactory = new GoogleDistanceFactory(magnetClient);
        try {
            googleDistance = controllerFactory.obtainInstance();
        } catch (SchemaException e) {
            e.printStackTrace();
        }

        String origins = "435 Tasso Street, Palo Alto, CA 94301, USA";
        String destinations = "Embarcadero, 298 Market Street, San Francisco, CA 94111, USA";
        String sensor = "";
        String mode = null;
        String language = null;
        String units = null;

        Call<DistanceResult> callObject = googleDistance.getDistance(
                origins,
                destinations,
                sensor,
                mode,
                language,
                units, null);
        try {
            DistanceResult result = callObject.get();
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
