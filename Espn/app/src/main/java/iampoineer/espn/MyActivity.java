package iampoineer.espn;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.async.StateChangedListener;
import com.magnet.android.mms.exception.SchemaException;



import com.magnetapi.examples.controller.api.ESPNHeadlines;
import com.magnetapi.examples.controller.api.ESPNHeadlinesFactory;
import com.magnetapi.examples.model.beans.SportsNewsResult;

import java.util.concurrent.ExecutionException;


public class MyActivity extends Activity {
    private ESPNHeadlines espnHeadlines;
    public TextView t1,t2,t3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        t1 = (TextView)findViewById(R.id.t1);
        t2 = (TextView)findViewById(R.id.t2);
        t3 = (TextView)findViewById(R.id.t3);

        MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(getApplicationContext());
        ESPNHeadlinesFactory controllerFactory = new ESPNHeadlinesFactory(magnetClient);

        try{
            espnHeadlines = controllerFactory.obtainInstance();
        } catch (SchemaException e) {
            e.printStackTrace();
        }

        String apikey= "https://wmerydith-espn.p.mashape.com/sports/news?apikey=someApiKey";
        String paramXMashapeAuthorization = null;

        Call<SportsNewsResult> callobject = espnHeadlines.getSportsNews(apikey,paramXMashapeAuthorization,null);
        try{
            SportsNewsResult result = callobject.get();
            t1.setText(result.getMessage().toString());

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
