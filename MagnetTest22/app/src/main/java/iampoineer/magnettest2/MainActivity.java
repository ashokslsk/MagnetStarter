package iampoineer.magnettest2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import com.magnet.android.mms.MagnetMobileClient;
import com.magnet.android.mms.async.Call;
import com.magnet.android.mms.exception.SchemaException;
import com.magnetapi.examples.controller.api.AsanaUsers;
import com.magnetapi.examples.controller.api.AsanaUsersFactory;
import com.magnetapi.examples.model.beans.AsanaUsersResult;

import java.util.concurrent.ExecutionException;


public class MainActivity extends Activity {
    private AsanaUsers AsanaUsers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MagnetMobileClient magnetClient = MagnetMobileClient.getInstance(getApplicationContext());
        AsanaUsersFactory controllerFactory = new AsanaUsersFactory(magnetClient);
        try{
            AsanaUsers = controllerFactory.obtainInstance();
        } catch (SchemaException e) {
            e.printStackTrace();
        }

        String Authorization= "5gEXSd34.fGHvgpiwe4T83rpieGMv6sZ";

        Call<AsanaUsersResult> callObject = AsanaUsers.getAsanaUsers(Authorization,null);
        try{
            AsanaUsersResult result = callObject.get();
            final ListView listview = (ListView) findViewById(R.id.list);

            MyCustomAdapter AsanaAdapter = new MyCustomAdapter(MainActivity.this, result.getData());
            listview.setAdapter(AsanaAdapter);
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
